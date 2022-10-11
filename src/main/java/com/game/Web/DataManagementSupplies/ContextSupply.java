package com.game.Web.DataManagementSupplies;

import com.game.RawMaterials.User;
import jakarta.servlet.ServletContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContextSupply implements IGameSupply {

    private ServletContext context;

    private static ContextSupply instance;

    private ContextSupply(ServletContext context) {
        this.context = context;

        this.context.setAttribute("Users", Collections.synchronizedList(new ArrayList<User>()));
    }

    //This is a sensitive piece of code the final there guarantees the immutability of the method
    synchronized public static final ContextSupply getInstance(ServletContext context) {
        if (instance == null)
            instance = new ContextSupply(context);

        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) context.getAttribute("Users");
    }

    @Override
    public void updateScore(User user) {
        User currentUser = getUserByLogin(user.getLogin());

        currentUser.setbestScore(user.getBestScore());
    }

    @Override
    public void insertUser(User user) {
        getAllUsers().add(user);
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> users = getAllUsers();

        for (User user: users)
            if(user.getLogin().equals(login)) {
                user.setStorageSupply(this);
                return user;
            }

        return null;
    }

}

package com.game.Web.DataManagementSupplies;

import com.game.RawMaterials.User;

import java.util.List;

public interface IGameSupply {

    public List<User> getAllUsers();

    public void updateScore(User user);

    public void insertUser(User user);

    public User getUserByLogin(String login);

}

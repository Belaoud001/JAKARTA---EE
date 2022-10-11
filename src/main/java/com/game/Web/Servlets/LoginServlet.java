package com.game.Web.Servlets;

import com.game.RawMaterials.GameLogic;
import com.game.RawMaterials.Message;
import com.game.RawMaterials.User;
import com.game.Web.DataManagementSupplies.IGameSupply;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {

    Logger LOGGER = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Retreive data from request
        String login    = request.getParameter("login");
        String password = request.getParameter("password");

        //Retreive Data Supply from Context
        IGameSupply storageSupply = (IGameSupply) request.getServletContext().getAttribute("storageSupply");

        List<Message> messages = new ArrayList<>();

        //Treatment
        User user = storageSupply.getUserByLogin(login);

        //Flag Variable
        boolean allowed = true;

        while(true) {
            if (user != null && allowed) {
                //Compare Passwords THEN -> Dispatch to UserHome
                if (user.isValidPassword(password)) {
                    //Store user in a session
                    request.getSession().setAttribute("currentUser", user);

                    //Create GameLogic Instance
                    request.getSession().setAttribute("gameLogic", new GameLogic(user));

                    //Set Flag Parameter
                    request.getSession().setAttribute("justStart", 1);

                    //Dispatch to UserHome
                    getServletContext().getRequestDispatcher("/WEB-INF/Views/Home.jsp").forward(request, response);

                    return;
                } else {
                    allowed = false;
                    continue;
                }
            } else {
                //Log Operation
                LOGGER.warn("Failed Authentification by  " + request.getRemoteAddr());

                // Re-Display Login Page with associated errors
                getServletContext().getRequestDispatcher("/WEB-INF/Views/loginPage.jsp?failed=1").forward(request, response);

                return;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}

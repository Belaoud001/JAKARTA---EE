package com.game.Web.Servlets;

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

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
    Logger LOGGER = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IGameSupply storageSupply = (IGameSupply) getServletContext().getAttribute("storageSupply");
        String login = request.getParameter("login");

        if(storageSupply.getUserByLogin(login) == null) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");

            User newUser = new User(lastName, firstName, login, password, -2, null);

            storageSupply.insertUser(newUser);

            getServletContext().getRequestDispatcher("/WEB-INF/Views/loginPage.jsp").forward(request, response);

        } else {
            System.out.println("Redandant user");
            LOGGER.error("Redandant user");
            getServletContext().getRequestDispatcher("/WEB-INF/Views/SignUp.jsp?exist=1").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

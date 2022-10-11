package com.game.Web.Servlets;

import com.game.RawMaterials.GameLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameLogic gameLogic = ((GameLogic) request.getSession().getAttribute("gameLogic"));

        if(gameLogic != null) {
            gameLogic.reInitialize();
            System.out.println("Initialized ...");
        }

        request.getSession().setAttribute("justStart", 1);
        getServletContext().getRequestDispatcher("/WEB-INF/Views/Home.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
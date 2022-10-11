package com.game.Web.Filters;

import jakarta.servlet.Filter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SecurityFilter implements Filter {

    private static final String CONNEXION_PAGE = "/WEB-INF/Views/loginPage.jsp";

    private final Logger LOGGER;

    public SecurityFilter() {
        LOGGER = LogManager.getLogger(SecurityFilter.class);
    }

    public void destroy() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        LOGGER.debug("Filter has started his work ...");


        HttpServletRequest rq = (HttpServletRequest) request;

        //Retrieve Session
        HttpSession session = rq.getSession();

        //Authentification verifiaction
        if (session.getAttribute("user") == null) {

            //Block Access
            rq.getRequestDispatcher(CONNEXION_PAGE).forward(request, response);

            return;

        } else {
            //Let the chain complete
            chain.doFilter(request, response);

        }

    }

}
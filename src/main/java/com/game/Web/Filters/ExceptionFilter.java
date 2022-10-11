package com.game.Web.Filters;

import com.game.RawMaterials.Message;
import jakarta.servlet.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

public class ExceptionFilter implements Filter {
    Logger LOGGER = LogManager.getLogger(getClass());


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.debug("Execution du filtre ExceptionFilter");

        try {

            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
            LOGGER.debug("Erreur gérée par le filtre. Cause de l'exception :" + e.getMessage(), e);
            List<Message> list = new ArrayList<>();
            list.add(new Message("Une erreur est survenue veuillez consulter le fichier journal pour plus de détails",
                    Message.ERROR));
            servletRequest.setAttribute("messages", list);
            servletRequest.getServletContext().getRequestDispatcher("/WEB-INF/Views/e rror.jsp").forward(servletRequest, servletResponse);

        }
    }
}
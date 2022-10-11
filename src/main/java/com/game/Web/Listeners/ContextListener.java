package com.game.Web.Listeners;

import com.game.RawMaterials.User;
import com.game.Web.DataManagementSupplies.IGameSupply;
import com.game.Web.DesignPattern.DataManagementFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.apache.logging.log4j.*;

import java.util.Collections;
import java.util.*;

@WebListener
public class ContextListener implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        String storageSupplyType = servletContext.getInitParameter("storage_type");

        //Injection
        IGameSupply storageSupply = DataManagementFactory.getSupply(storageSupplyType, servletContext);

        //Stocker "Strage Supply" dans le contexte
        servletContext.setAttribute("storageSupply", storageSupply);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}

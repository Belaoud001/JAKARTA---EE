package com.game.Web.DesignPattern;

import com.game.Web.DataManagementSupplies.*;
import jakarta.servlet.ServletContext;

public class DataManagementFactory {

    public static IGameSupply getSupply(String supplyType, ServletContext context) {
        if(!"MySql".equals(supplyType))
            return ContextSupply.getInstance(context);
        return DataBaseSupply.getInstance();
    }

}

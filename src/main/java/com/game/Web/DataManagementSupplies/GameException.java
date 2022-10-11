package com.game.Web.DataManagementSupplies;

public class GameException extends RuntimeException {

    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameException(String message) {
        super(message);
    }

    public GameException(Throwable cause) {
        super(cause);
    }

    public GameException(Exception e) {
        super(e);
    }
}

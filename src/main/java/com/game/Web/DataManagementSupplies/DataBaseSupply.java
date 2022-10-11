package com.game.Web.DataManagementSupplies;

import com.game.RawMaterials.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseSupply implements IGameSupply {

    private String URLConnection = "jdbc:mysql://localhost:3306/dicegame?user=root&password=YmirFritz@18";

    private static DataBaseSupply instance;

    private DataBaseSupply() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new GameException(e);
        }
    }

    synchronized public static final DataBaseSupply getInstance() {
        if (instance == null)
            instance = new DataBaseSupply();

        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        Connection connection;

        try {
            connection = DriverManager.getConnection(URLConnection);

            try {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM user ORDER BY bestscore DESC");

                while (resultSet.next()) {
                    User user = new User(
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getInt("bestscore"),
                            this
                    );

                    users.add(user);
                }
            } finally {
                if(connection != null)
                    connection.close();
            }
        } catch(Exception e) {
            throw new GameException(e);
        }

        return users;
    }

    @Override
    public void updateScore(User user) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URLConnection);

            try {
                String query = "UPDATE user SET bestScore = ? WHERE login=?";

                System.out.println("Best Score : " + user.getBestScore());

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setInt(1, user.getBestScore());
                preparedStatement.setString(2, user.getLogin());

                preparedStatement.executeUpdate();
            } finally {
                if(connection != null)
                    connection.close();
            }
        } catch(Exception e) {
            throw new GameException(e);
        }
    }

    @Override
    public void insertUser(User user) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URLConnection);

            try {
                String query = "INSERT INTO user VALUES(?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setInt(5, user.getBestScore());

                preparedStatement.executeUpdate();

            } finally {
                if(connection != null)
                    connection.close();
            }
        } catch(Exception e) {
            throw new GameException(e);
        }
    }

    @Override
    public User getUserByLogin(String login) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URLConnection);

            try {
                Statement statement = connection.createStatement();

                String query = "SELECT * FROM user WHERE login = '" + login + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if(resultSet.next()) {
                    User user = new User(
                            resultSet.getString("firstname"),
                            resultSet.getString("lastname"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getInt("bestscore"),
                            this
                    );

                    return user;
                } else
                    return null;
            } finally {
                if(connection != null)
                    connection.close();
            }
        } catch(Exception e) {
            throw new GameException(e);
        }
    }

}

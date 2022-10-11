package com.game.RawMaterials;

import com.game.Web.DataManagementSupplies.IGameSupply;

import java.util.Objects;

public class User {

    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private int    bestScore;
    private int    roundCounter;
    private IGameSupply storageSupply;

    public User(String lastName, String firstName, String login, String password, int bestScore, IGameSupply storageSupply) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.password = password;
        this.bestScore = bestScore;
        this.storageSupply = storageSupply;
        this.roundCounter = 1;
    }

    public void setStorageSupply(IGameSupply storageSupply) {
        this.storageSupply = storageSupply;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setbestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public void setBestScore(int bestScore) {
        if(this.bestScore < bestScore) {
            this.bestScore = bestScore;
            System.out.println("best Detected");
            storageSupply.updateScore(this);
        }
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }

    public void nextRoll() {
        this.roundCounter++;
    }

    public boolean isValidPassword(String attemptedPass) {
        return password.equals(attemptedPass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
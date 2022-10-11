package com.game.RawMaterials;

import java.util.ArrayList;
import java.util.*;

public class GameLogic {

    private User user;

    private final int MAX_ROUND_COUNT = 3;

    private int currentScore;

    private List<Integer> previousScores = new ArrayList<>();

    private boolean isGameOver = false;

    private Map<String, Integer> scoresPerRound = new Hashtable<>();

    private List<Message> messages = new ArrayList<>();

    public void setPreviousScores() {
        for (Map.Entry<String, Integer> roundScore : scoresPerRound.entrySet())
            previousScores.add(roundScore.getValue());
    }

    public List<Integer> getPreviousScores() {
        return previousScores;
    }

    public void reInitialize() {
        isGameOver = true;
        messages = new ArrayList<Message>();
        user.setRoundCounter(1);
        user.setBestScore(currentScore);
        setPreviousScores();
        scoresPerRound.clear();
    }

    public GameLogic(User user) {
        this.user = user;
        this.currentScore = -2;
    }

    public boolean isOver() {
        return scoresPerRound.size() == 0 && currentScore != -2;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public boolean isRoundOver() {
        return user.getRoundCounter() >= MAX_ROUND_COUNT;
    }

    public int getRandomDiceFace() {
        return new Random().nextInt(6) + 1;
    }

    public int Roll(String diceId) {
        int diceFace = getRandomDiceFace();

        System.out.println("Round : " + user.getRoundCounter());
        appendScore(diceId, diceFace);

        return diceFace;
    }

    public void appendScore(String diceId, int diceFace) {
        if(!isRoundOver()) {
            if (scoresPerRound.containsKey(diceId)) {
                currentScore = -1;
                System.out.println(scoresPerRound);
                System.out.println(currentScore);
                previousScores.clear();
                reInitialize();
            } else {
                if((diceId.equals("dice-1") && diceFace >= 5) || (diceId.equals("dice-2") && diceFace > 5)) {
                    currentScore = 0;
                    System.out.println(scoresPerRound);
                    System.out.println(currentScore);
                    previousScores.clear();

                    reInitialize();
                } else {
                    scoresPerRound.put(diceId, diceFace);
                    user.nextRoll();
                }
            }
        } else {
            scoresPerRound.put(diceId, diceFace);
            currentScore = scoreThisRound();
            System.out.println(scoresPerRound);
            System.out.println(currentScore);
            previousScores.clear();
            reInitialize();
        }
    }

    public int scoreThisRound() {
        int sum = 0;

        if(scoresPerRound.get("dice-1") < scoresPerRound.get("dice-2") && scoresPerRound.get("dice-2") < scoresPerRound.get("dice-3")) {
            for (Map.Entry<String, Integer> roundScore : scoresPerRound.entrySet())
                sum += roundScore.getValue();
            return sum;
        } else
            return 0;
    }

    public String toString() {
        return "GameLog [Score= " + ", messages= "
                + messages + "]";
    }

}

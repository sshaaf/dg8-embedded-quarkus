package org.acme;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class Score {

    public static final int HOLES = 18;

    private int currentHole = 0;

    private String playerName;

    private String playerId;

    private int[] card = new int[HOLES];

    private String course = "St.Andrews Links";

    private int[] courseCard = {4,4,4,4,5,4,4,3,4,4,3,4,4,5,4,4,4,4};

    public Score() {
    }


    @JsonbCreator
    public Score(@JsonbProperty("playerName") String playerName, @JsonbProperty("playerId") String playerId, @JsonbProperty("card") int[] card) {
        if(playerName == null || playerName.equals(""))
            throw new IllegalArgumentException("Player name cannot be null "+playerName);
        else {
            this.playerName = playerName;
            this.playerId = playerId;
            this.setCard(card);
        }
    }

    public Score(String playerName, String playerId, String course, int[] courseCard) {
        if(playerName == null || playerName.equals(""))
            throw new IllegalArgumentException("Player name cannot be null "+playerName);
        else {
            this.playerName = playerName;
            this.playerId = playerId;
            this.course = course;
            this.courseCard = courseCard;
        }
    }


    public Score(String playerName, String playerId) {
        if(playerName == null || playerName.equals(""))
            throw new IllegalArgumentException("Player name cannot be null "+playerName);
        else {
            this.playerName = playerName;
            this.playerId = playerId;
        }
    }

    public int getCurrentHole() {
        return currentHole;
    }

    public void setCurrentHole(int currentHole) {
        this.currentHole = currentHole;
    }

    public void addScore(int score){
        card[currentHole] = score;
        currentHole++;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalScore(){
        int score = 0;
        int courseScore = 0;
        for(int i=0; i<currentHole; i++) {
            score = score + card[i];
            courseScore = courseScore + courseCard[i];
        }

        return score-courseScore;
    }

    public String getPlayerId() { return playerId; }

    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int[] getCard() {
        return card;
    }

    public void setCard(int[] card) {
        this.card = card;

        if(card.length < HOLES)
            currentHole = card.length + 1;
    }
}
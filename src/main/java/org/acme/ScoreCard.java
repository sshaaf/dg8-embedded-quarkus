package org.acme;

import java.util.ArrayList;

public class ScoreCard {

    public static final int HOLES = 18;

    public String playerName;

    public String playerId;

    public ArrayList<Score> holeScore;

    public ScoreCard(String playerName, String playerId) {
        if(playerName == null || playerName.equals(""))
            throw new IllegalArgumentException("Player name cannot be null "+playerName);
        else {
            this.playerName = playerName;
            this.playerId = playerId;
            holeScore = new ArrayList<>();
        }

    }

    public int getHolesPlayed(){
        return holeScore.size();
    }

    public void addScore(Score score){
        if(score != null)
            holeScore.add(score);
    }


    public String getPlayerId() { return playerId; }

    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Score> getHoleScore() {
        return holeScore;
    }

    public void setHoleScore(ArrayList<Score> holeScore) {
        this.holeScore = holeScore;
    }
}
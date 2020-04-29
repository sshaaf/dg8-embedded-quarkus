package org.acme;

public class Score {

    private String key = null;

    // Name of the player
    private String playerName = null;

    private int score = 0;

    private String course = null;

    private String country = null;

    public String getKey(){
        return playerName+","+country;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
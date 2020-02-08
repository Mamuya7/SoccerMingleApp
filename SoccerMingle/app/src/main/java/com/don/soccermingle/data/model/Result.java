package com.don.soccermingle.data.model;

public class Result {
    private int homeScores;
    private int awayScores;
    private int homePossession;
    private int awayPossession;

    public Result(int homeScores, int awayScores, int homePossession, int awayPossession) {
        this.homeScores = homeScores;
        this.awayScores = awayScores;
        this.homePossession = homePossession;
        this.awayPossession = awayPossession;
    }

    public int getHomeScores() {
        return homeScores;
    }

    public void setHomeScores(int homeScores) {
        this.homeScores = homeScores;
    }

    public int getAwayScores() {
        return awayScores;
    }

    public void setAwayScores(int awayScores) {
        this.awayScores = awayScores;
    }

    public int getHomePossession() {
        return homePossession;
    }

    public void setHomePossession(int homePossession) {
        this.homePossession = homePossession;
    }

    public int getAwayPossession() {
        return awayPossession;
    }

    public void setAwayPossession(int awayPossession) {
        this.awayPossession = awayPossession;
    }
}

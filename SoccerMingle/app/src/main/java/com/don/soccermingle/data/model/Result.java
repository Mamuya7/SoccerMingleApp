package com.don.soccermingle.data.model;

public class Result {
    private String homeScores;
    private String awayScores;
    private String homePossession;
    private String awayPossession;

    public Result(){}
    public Result(String homeScores, String awayScores, String homePossession, String awayPossession) {
        this.homeScores = homeScores;
        this.awayScores = awayScores;
        this.homePossession = homePossession;
        this.awayPossession = awayPossession;
    }

    public String getHomeScores() {
        return homeScores;
    }

    public void setHomeScores(String homeScores) {
        this.homeScores = homeScores;
    }

    public String getAwayScores() {
        return awayScores;
    }

    public void setAwayScores(String awayScores) {
        this.awayScores = awayScores;
    }

    public String getHomePossession() {
        return homePossession;
    }

    public void setHomePossession(String homePossession) {
        this.homePossession = homePossession;
    }

    public String getAwayPossession() {
        return awayPossession;
    }

    public void setAwayPossession(String awayPossession) {
        this.awayPossession = awayPossession;
    }
}

package com.don.soccermingle.data.model;

public class Fixture {
    private String id;
    private String homeTeam;
    private String awayTeam;
    private String stadium;
    private String matchStatus;
    private Result result;

    public Fixture(){}

    public Fixture(String id, String homeTeam, String awayTeam, String stadium, String matchStatus) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.matchStatus = matchStatus;
    }

    public Fixture(String homeTeam, String awayTeam, String stadium, String matchStatus,Result result) {
        this.setResult(result);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
        this.matchStatus = matchStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}

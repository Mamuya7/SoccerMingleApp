package com.don.soccermingle.data.model;

import java.util.ArrayList;

public class Team {
    private int id;
    private String name;
    private Coach coach;
    private ArrayList<Players> players;

    public Team(int id, String name, Coach coach, ArrayList<Players> players) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public ArrayList<Players> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
    }
}

package com.don.soccermingle.data.model;

public class Coach {
    private int id;
    private String name;
    private int age;
    private String contract;

    public Coach(int id, String name, int age, String contract) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contract = contract;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}

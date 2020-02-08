package com.don.soccermingle.data.model;

class Players {
    private int id;
    private String name;
    private int age;
    private int kitno;
    private float ft;
    private String contract;

    public Players(int id, String name, int age, int kitno, float ft, String contract) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.kitno = kitno;
        this.ft = ft;
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

    public int getKitno() {
        return kitno;
    }

    public void setKitno(int kitno) {
        this.kitno = kitno;
    }

    public float getFt() {
        return ft;
    }

    public void setFt(float ft) {
        this.ft = ft;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}

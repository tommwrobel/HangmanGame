package com.tom.models;

public class Player {

    private String name;
    int score;
    int chancesLeft;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getChancesLeft() {
        return chancesLeft;
    }

    public void setChancesLeft(int chancesLeft) {
        this.chancesLeft = chancesLeft;
    }
}

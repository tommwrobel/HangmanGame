package com.tom.model;

public class Player {

    private String name;
    int score;

    public Player() {
        this.score = 0;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int scoreNumber) {
        this.score += scoreNumber;
    }

}

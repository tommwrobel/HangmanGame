package com.tom.models;

public enum DifficultyLevel {

    EASY(10, "łatwy"),
    MEDIUM(8, "średni"),
    HARD(6, "trudny");

    private int chancesNumber;
    private String displayName;

    DifficultyLevel(int chancesNumber, String displayName) {
        this.chancesNumber = chancesNumber;
        this.displayName = displayName;
    }

    public int getChancesNumber() {
        return chancesNumber;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
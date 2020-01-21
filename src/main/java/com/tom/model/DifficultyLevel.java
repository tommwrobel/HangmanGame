package com.tom.model;

public enum DifficultyLevel {

    EASY(10, "łatwy"),
    MEDIUM(8, "średni"),
    HARD(6, "trudny"),
    CHEATER(100, "cheater");

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

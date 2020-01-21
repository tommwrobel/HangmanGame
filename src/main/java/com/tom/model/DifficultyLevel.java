package com.tom.model;

public enum DifficultyLevel {

    EASY(10, "łatwy"),
    MEDIUM(8, "średni"),
    HARD(6, "trudny"),
    CHEATER(100, "cheater");

    private final int chancesNumber;
    private final String displayName;

    DifficultyLevel(int chancesNumber, String displayName) {
        this.chancesNumber = chancesNumber;
        this.displayName = displayName;
    }

    public static DifficultyLevel fromInt(int difficultyLevel) {
        if (difficultyLevel <= 0 || difficultyLevel > DifficultyLevel.values().length) {
            return CHEATER;
        } else {
            return DifficultyLevel.values()[difficultyLevel - 1];
        }
    }

    public int getChancesNumber() {
        return chancesNumber;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

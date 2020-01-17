package com.tom.models;

public class Game {

    private DifficultyLevel difficultyLevel;

    public Game(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
}

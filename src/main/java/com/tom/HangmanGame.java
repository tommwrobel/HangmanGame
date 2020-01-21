package com.tom;

import com.tom.controllers.GameController;

public class HangmanGame {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        gameController.initializeGame();
    }
}

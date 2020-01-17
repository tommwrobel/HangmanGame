package com.tom.controllers;

import com.tom.models.DifficultyLevel;
import com.tom.models.Game;
import com.tom.models.Player;
import com.tom.views.GameView;

import java.util.Scanner;

public class GameController {

    private Game game;
    private Player player;
    private GameView gameView;

    public void startNewGame() {


        game = new Game();

    }

    public DifficultyLevel getDifficultyLevelFromUser() {
        gameView.showMessage("Ustaw poziom trudności");
        getIntFromUser(1, 3);
    }

    public int getIntFromUser(int from, int to) {

        boolean inputIsValid = false;
        int userInput;
        Scanner userInput = new Scanner(System.in);

        do {
            if (userInput.hasNextInt()) {
                userInput = userInput.nextInt();
                if (userInput >= from || userInput <= to) {
                    inputIsValid = true;
                }
            }

            if(!inputIsValid) {
                gameView.showMessage("Nieprawidłowe wejście! Spróbuj jeszcze raz.");
            }
        } while (!inputIsValid)

        return userInput;
    }

}

package com.tom.controllers;

import com.tom.models.DifficultyLevel;
import com.tom.models.Menu;
import com.tom.views.GameView;

import java.util.Scanner;

public class InputController {

    private GameView gameView;
    private Menu menu;

    public InputController(GameView gameView) {
        this.gameView = gameView;
    }

    public int chooseMenuOption(Menu menu) {
        gameView.showMenu(menu);
        int to = menu.getMenuItems().length;
        return getIntFromUser(1, to);
    }

    public DifficultyLevel getDifficultyLevelFromUser() {

        int choosenDifficultyLevelIndex;
        DifficultyLevel choosenDifficultyLevel;

        choosenDifficultyLevelIndex = chooseMenuOption(Menu.DIFFICULTY_LEVEL);

        switch (choosenDifficultyLevelIndex) {
            case 1:
                choosenDifficultyLevel = DifficultyLevel.EASY;
                break;
            case 2:
                choosenDifficultyLevel = DifficultyLevel.MEDIUM;
                break;
            case 3:
                choosenDifficultyLevel = DifficultyLevel.HARD;
                break;
            default:
                choosenDifficultyLevel = DifficultyLevel.EASY;
        }

        return choosenDifficultyLevel;
    }

    public int getIntFromUser(int from, int to) {

        int number;
        Scanner userInput = new Scanner(System.in);

        do {
            while (!userInput.hasNextInt()) {
                gameView.showErrorMessage("Podana wartość nie jest wartością liczbową!");
                userInput.next();
            }

            number = userInput.nextInt();

            if (number < from || number > to) {
                gameView.showErrorMessage("Podana wartość nie mieści się w zakresie od" + from + " do " + to);
            }

        } while (number < from || number > to);
        userInput.close();

        return number;
    }
}

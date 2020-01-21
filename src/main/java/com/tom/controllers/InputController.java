package com.tom.controllers;

import com.tom.models.DifficultyLevel;
import com.tom.models.Menu;
import com.tom.views.GameView;

import java.util.Scanner;

public class InputController {

    private GameView gameView;
    private Menu menu;
    private Scanner scanner;

    public InputController(GameView gameView) {
        this.gameView = gameView;
        scanner = new Scanner(System.in);
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
                choosenDifficultyLevel = DifficultyLevel.CHEATER;
        }

        return choosenDifficultyLevel;
    }

    public int getIntFromUser(int from, int to) {

        int number;

        do {
            while (!scanner.hasNextInt()) {
                gameView.showErrorMessage("Podana wartość nie jest wartością liczbową!");
                scanner.next();
            }

            number = scanner.nextInt();
            scanner.nextLine();

            if (number < from || number > to) {
                gameView.showErrorMessage("Podana wartość nie mieści się w zakresie od " + from + " do " + to);
            }

        } while (number < from || number > to);

        return number;
    }

    public String getStringFromUser(String message, int minLength, int maxLength) {

        String userInput;
        gameView.showMessage(message);

        do {
            userInput = scanner.nextLine();

            if(userInput.length() < minLength || userInput.length() > maxLength) {
                gameView.showErrorMessage("Wpisany ciąg znaków ma niepoprawną długość [" + minLength + "-" + maxLength + "]!");
            }

            if(!userInput.matches("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*")) {
                gameView.showErrorMessage("Wpisany ciąg znaków zawiera niepoprawne znaki!");
            }
        } while(userInput.length() < minLength || userInput.length() > maxLength || !userInput.matches("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*"));

        return userInput;
    }
}
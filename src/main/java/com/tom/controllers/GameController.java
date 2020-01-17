package com.tom.controllers;

import com.tom.models.DifficultyLevel;
import com.tom.models.Game;
import com.tom.models.Menu;
import com.tom.models.Player;
import com.tom.views.GameView;

import java.util.Scanner;

public class GameController {

    private Game game;
    private Player player;
    private GameView gameView;

    public GameController() {
        this.gameView = new GameView();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void startNewGame(Game game, Player player, GameView gameView) {

        this.game = game;
        this.player = player;
        this.gameView = gameView;

    }

    public DifficultyLevel getDifficultyLevelFromUser() {

        Menu difficultyLevelMenu = new Menu("Łatwy", "Średni", "Trudny");
        int choosenDifficultyLevelIndex;
        DifficultyLevel choosenDifficultyLevel = DifficultyLevel.EASY;

        gameView.showMessage("Ustaw poziom trudności");
        gameView.showMenu(difficultyLevelMenu.getMenuItems());
        choosenDifficultyLevelIndex = getIntFromUser(1, 3);

        switch(choosenDifficultyLevelIndex) {
            case 1:
                choosenDifficultyLevel = DifficultyLevel.EASY;
                break;
            case 2:
                choosenDifficultyLevel = DifficultyLevel.MEDIUM;
                break;
            case 3:
                choosenDifficultyLevel = DifficultyLevel.HARD;
                break;
        }

        return choosenDifficultyLevel;
    }

    public int getIntFromUser(int from, int to) {

        int number;
        Scanner userInput = new Scanner(System.in);

        do {
            while(!userInput.hasNextInt()) {
                gameView.showErrorMessage("Podana wartość nie jest wartością liczbową!");
                userInput.next();
            }

            number = userInput.nextInt();

            if(number < from || number > to) {
                gameView.showErrorMessage("Podana wartość nie mieści się w zakresie od" + from + " do " + to);
            }

        } while(number < from || number > to);
        userInput.close();

        return number;
    }

}

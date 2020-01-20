package com.tom.controllers;

import com.tom.models.Menu;
import com.tom.models.Player;
import com.tom.models.Round;
import com.tom.views.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameView gameView;
    private InputController inputController;

    public GameController() {
        this.gameView = new GameView();
        this.inputController = new InputController(gameView);
    }

    public void startNewGame() {

        gameView.showTitle();
        int mainMenuChoosenOption = inputController.chooseMenuOption(Menu.MAIN);

        switch (mainMenuChoosenOption) {
            case 1:
                startNewRound();
                break;
            case 2:
                exitGame();
                break;
            default:
                System.out.println("Wybrana opcja nie istenieje!");
        }
    }

    public void startNewRound() {

        String wordToGuess = "NikarAgua";

        Player player = new Player(inputController.getStringFromUser("Podaj nazwę gracza:", 3, 20));
        Round round = new Round(inputController.getDifficultyLevelFromUser(), wordToGuess);
        List<String> guessedLetters = new ArrayList<>();
        Boolean win;

        do {
            gameView.showHangman(round.getChancesLeft());
            gameView.showWord(guessedLetters, round.getWordToGuess());

            String letterFromUser = inputController.getStringFromUser("Podaj literkę", 1, 1);
            int numberOfGuessedLetters = round.checkLetter(letterFromUser);

            if(numberOfGuessedLetters > 0) {
                gameView.showMessage("Brawo! Odgadłeś " + numberOfGuessedLetters + " liter!");
                guessedLetters.add(letterFromUser);
            } else {
                System.out.println("Niestety, tej litery nie ma w słowie!");
                round.deleteChances(1);
            }

        } while(round.getChancesLeft() > 0);



    }

    public void exitGame() {

        System.exit(0);
    }

}

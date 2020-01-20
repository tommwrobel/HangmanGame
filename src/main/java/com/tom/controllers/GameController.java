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
                gameView.showMessage("Wybrana opcja nie istenieje!");
        }
    }

    public void startNewRound() {

        Player player = new Player(inputController.getStringFromUser("Podaj nazwę gracza:", 3, 20));
        Round round = new Round(inputController.getDifficultyLevelFromUser());
        List<String> guessedLetters = new ArrayList<>();

        do {
            gameView.showWord(guessedLetters, round.getWordToGuess());

            String letterFromUser = inputController.getStringFromUser("Podaj literkę", 1, 1);
            int numberOfGuessedLetters = round.checkLetter(letterFromUser);

            if (numberOfGuessedLetters > 0) {
                gameView.showMessage("Brawo! Odgadłeś " + numberOfGuessedLetters + " liter!");
                guessedLetters.add(letterFromUser);
                player.addScore(numberOfGuessedLetters);
            } else {
                gameView.showMessage("Niestety, tej litery nie ma w słowie!");
                round.deleteChances(1);
            }

            gameView.showHangman(round.getChancesLeft());

            if (player.getScore() == round.getWordToGuess().length()) {
                gameView.showMessage("Brawo! Wygrałeś!");
                gameView.showMessage("Odgadłeś słowo: " + round.getWordToGuess());
                gameView.showMessage("Pozostało Ci " + round.getChancesLeft() + " szans!");
            } else if (round.getChancesLeft() == 0) {
                gameView.showMessage("Niestety, przegrałeś :(");
                gameView.showMessage("Słowo którego nie odgadłeś to " + round.getWordToGuess());
            }

        } while (round.getChancesLeft() > 0 && player.getScore() < round.getWordToGuess().length());

        int nextGame = inputController.chooseMenuOption(Menu.AFTER_ROUND);
        switch (nextGame) {
            case 1:
                startNewRound();
                break;
        }
    }

    public void exitGame() {

        System.exit(0);
    }

}

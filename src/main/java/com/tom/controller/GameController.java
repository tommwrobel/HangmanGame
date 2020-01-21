package com.tom.controller;

import com.tom.model.Menu;
import com.tom.model.Player;
import com.tom.model.Round;
import com.tom.view.GameView;

public class GameController {

    private GameView gameView;
    private InputController inputController;

    public GameController() {
        this.gameView = new GameView();
        this.inputController = new InputController(gameView);
    }

    public void initializeGame() {
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

        do {
            gameView.showWord(round.getGuessedLetters(), round.getWordToGuess());

            String letterFromUser = inputController.getStringFromUser("Podaj literkę", 1, 1);
            int numberOfGuessedLetters = round.checkLetter(letterFromUser);

            if (numberOfGuessedLetters > 0) {
                gameView.showMessage("Brawo! Odgadłeś " + numberOfGuessedLetters + " liter!");
                player.addScore(numberOfGuessedLetters);
            } else {
                gameView.showMessage("Niestety, tej litery nie ma w słowie!");
                round.deleteChances(1);
            }

            gameView.showHangman(round.getChancesLeft());

            if (player.getScore() == round.getWordToGuess().length()) {
                gameView.showWinMessage(round.getWordToGuess(), round.getChancesLeft());
            } else if (round.getChancesLeft() == 0) {
                gameView.showLooseMessage(round.getWordToGuess());
            }

        } while (round.getChancesLeft() > 0 && player.getScore() < round.getWordToGuess().length());

        int nextGame = inputController.chooseMenuOption(Menu.AFTER_ROUND);
        switch (nextGame) {
            case 1:
                startNewRound();
                break;
            case 2:
                initializeGame();
                break;
        }
    }

    public void exitGame() {
        System.exit(0);
    }

}

package com.tom;

import com.tom.controllers.GameController;
import com.tom.models.DifficultyLevel;
import com.tom.models.Game;
import com.tom.models.Menu;
import com.tom.models.Player;
import com.tom.views.GameView;

public class HangmanGame {
    public static void main(String[] args) {

        Game game = new Game();
        Player player = new Player("Tomek");
        GameView gameView = new GameView();
        GameController gameController = new GameController();

        gameController.startNewGame(game, player, gameView);

        player.setName("Adrian");
        System.out.println(gameController.getPlayer().getName());

        game.setDifficultyLevel(gameController.getDifficultyLevelFromUser());

    }
}

package com.tom.controllers;

import com.tom.models.Round;
import com.tom.models.Player;
import com.tom.views.GameView;

public class GameController {

    private Round round;
    private Player player;
    private GameView gameView;

    public GameController() {
        this.gameView = new GameView();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void startNewGame(Round game, Player player, GameView gameView) {

        this.game = game;
        this.player = player;
        this.gameView = gameView;

    }

}

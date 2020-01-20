package com.tom;

import com.tom.models.*;
import com.tom.views.GameView;

public class HangmanGame {
    public static void main(String[] args) {

        GameView gameView = new GameView();

        gameView.showMenu(Menu.DIFFICULTY_LEVEL);

    }
}

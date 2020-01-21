package com.tom.views;

import com.tom.models.Menu;

import java.util.Set;

public interface GameViewInterface {

    void showTitle();

    void showMessage(String message);

    void showErrorMessage(String message);

    void showMenu(Menu menu);

    void showHangman(int chancesLeft);

    void showWord(Set<String> guessedLetters, String word);

    void showWinMessage(String message, int chancesLeft);

    void showLooseMessage(String message);

}

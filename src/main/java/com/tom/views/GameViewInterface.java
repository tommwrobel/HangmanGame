package com.tom.views;

import com.tom.models.Menu;

import java.util.List;

public interface GameViewInterface {

    void showTitle();
    void showMessage(String message);
    void showErrorMessage(String message);
    void showMenu(Menu menu);
    void showHangman(int chancesLeft);
    void showWord(List<String> guessedLetters, String word);

}

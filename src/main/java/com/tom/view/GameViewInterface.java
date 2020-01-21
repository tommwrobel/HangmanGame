package com.tom.view;

import com.tom.model.Menu;

import java.util.Set;

public interface GameViewInterface {

    void showTitle();

    void showMessage(String message);

    void showErrorMessage(String message);

    void showMenu(Menu menu);

    void showHangman(int chancesLeft);

    void showWord(Set<String> guessedLetters, String word);

}

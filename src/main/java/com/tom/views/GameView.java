package com.tom.views;

import com.tom.models.Menu;

import java.util.List;

public class GameView implements GameViewInterface {

    @Override
    public void showTitle() {
        System.out.println("+---------------------------+");
        System.out.println("|        Hangman Game       |");
        System.out.println("+---------------------------+");
    }

    @Override
    public void showMenu(Menu menu) {

        int menuItemsCount = menu.getMenuItems().length;
        String[] menuItems = menu.getMenuItems();

        System.out.println(menu.getTitle() + ":");
        for (int i = 0; i < menuItemsCount; i++) {
            System.out.println("[" + (i + 1) + "] " + menuItems[i]);
        }
        System.out.println("Twój wybór: ");
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showHangman(int chancesLeft) {
        switch (chancesLeft) {
            case 10:
                System.out.println("         ");
                System.out.println("         ");
                System.out.println("         ");
                System.out.println("         ");
                System.out.println("         ");
                System.out.println("________ ");
                break;
            case 9:
                System.out.println("         ");
                System.out.println("         ");
                System.out.println("         ");
                System.out.println("         ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 8:
                System.out.println("         ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 7:
                System.out.println("  ____   ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 6:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 5:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |    O  ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 4:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |    O_ ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 3:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |   _O_ ");
                System.out.println(" |       ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 2:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |   _O_ ");
                System.out.println(" |    |  ");
                System.out.println(" |       ");
                System.out.println("_|______ ");
                break;
            case 1:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |   _O_ ");
                System.out.println(" |    |  ");
                System.out.println(" |     \\ ");
                System.out.println("_|______ ");
                break;
            case 0:
                System.out.println("  ____   ");
                System.out.println(" |    |  ");
                System.out.println(" |   _O_ ");
                System.out.println(" |    |  ");
                System.out.println(" |   / \\ ");
                System.out.println("_|______ ");
                break;
        }
    }

    @Override
    public void showWord(List<String> guessedLetters, String word) {

        String[] wordLetters = word.split("(?!^)");

        for (String letter : wordLetters) {
            boolean isVisible = false;
            for (int i = 0; i < guessedLetters.size(); i++) {
                if (letter.equalsIgnoreCase(guessedLetters.get(i))) {
                    isVisible = true;
                }
            }
            System.out.print(isVisible ? " " + letter + " " : " _ ");
        }
        System.out.println("");
    }

}

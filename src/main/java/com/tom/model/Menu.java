package com.tom.model;

public enum Menu {
    MAIN("Wybierz opcję", "Nowa gra", "Koniec gry"),
    AFTER_ROUND("Rozpocząć kolejną rundę?", "Tak", "Nie"),
    DIFFICULTY_LEVEL("Wybierz poziom trudności", "Łatwy", "Średni", "Trudny");

    private final String title;
    private final String[] menuItems;

    Menu(String title, String... menuItems) {
        this.title = title;
        this.menuItems = menuItems;
    }

    public String getTitle() {
        return title;
    }

    public String[] getMenuItems() {
        return menuItems;
    }

}
package com.tom.models;

public enum Menu {

    MAIN("Wybierz opcję", "Nowa gra", "Rekordy", "Koniec gry"),
    DIFFICULTY_LEVEL("Wybierz poziom trudności", "Łatwy", "Średni", "Trudny");

    private String[] title;
    private String[] menuItems;

    Menu(String title, String... menuItems) {
        this.menuItems = menuItems;
    }

    public String[] getTitle() {
        return title;
    }

    public String[] getMenuItems() {
        return menuItems;
    }

    public String getMenuItem(int index) {
        return menuItems[index];
    }
}

package com.tom.models;

public class Menu {
    String[] menuItems;

    public Menu(String... menuItems) {
        this.menuItems = menuItems;
    }

    public String[] getMenuItems() {
        return menuItems;
    }

    public String getMenuItem(int index) {
        return menuItems[index];
    }
}

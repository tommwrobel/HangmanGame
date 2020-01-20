package com.tom.models;

import java.util.stream.Stream;

public enum MainMenu
{
    NEWGAME("Nowa gra"),
    EXITGAME("Wyjdź z gry");

    String displayName;

    MainMenu(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    public static Stream<MainMenu> stream() {
        return Stream.of(MainMenu.values());
    }
}

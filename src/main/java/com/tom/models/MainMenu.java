package com.tom.models;

public enum MainMenu
{
    NEWGAME("Nowa gra"),
    EXITGAME("Wyjdź z gry");

    String optionName;

    MainMenu(String optionName) {
        this.optionName = optionName;
    }
}

package com.tom.models;

public class Round {

    private DifficultyLevel difficultyLevel;
    private String wordToGuess;
    private int chancesLeft;

    public Round(DifficultyLevel difficultyLevel, String wordToGuess) {
        this.difficultyLevel = difficultyLevel;
        this.wordToGuess = wordToGuess;
        this.chancesLeft = difficultyLevel.getChancesNumber();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void deleteChances(int numberToDelete) {
        chancesLeft -= numberToDelete;
        if (chancesLeft < 0) {
            chancesLeft = 0;
        }
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getChancesLeft() {
        return chancesLeft;
    }

    public int checkLetter(String letter) {

        int numberOfGuessedLetters = 0;

        String[] wordToGuess = this.wordToGuess.split("(?!^)");
        for(int i = 0; i < wordToGuess.length; i++) {
            if(wordToGuess[i].equalsIgnoreCase(letter)) {
                numberOfGuessedLetters++;
            }
        }

        return numberOfGuessedLetters;
    }

}

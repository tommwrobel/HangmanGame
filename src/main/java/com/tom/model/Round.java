package com.tom.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Round {
    private final String wordToGuess;
    private final Set<String> guessedLetters;
    private int chancesLeft;

    public Round(DifficultyLevel difficultyLevel) {
        this.wordToGuess = getRandomWordFromFile("src/main/resources/words.cvs");
        this.chancesLeft = difficultyLevel.getChancesNumber();
        this.guessedLetters = new HashSet<>();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public String getRandomWordFromFile(String filename) {
        try {
            File file = new File(filename);
            List<String> words = Files.readAllLines(file.toPath());
            Collections.shuffle(words);
            return words.get(0);
        } catch (IOException e) {
            return "Error";
        }
    }

    public void deleteChances(int numberToDelete) {
        chancesLeft -= numberToDelete;
        if (chancesLeft < 0) {
            chancesLeft = 0;
        }
    }

    public int getChancesLeft() {
        return chancesLeft;
    }

    public int checkLetter(String letter) {
        int numberOfGuessedLetters = 0;
        letter = letter.toUpperCase();

        if (!guessedLetters.contains(letter)) {
            String[] lettersToGuess = this.wordToGuess.split("(?!^)");
            for (String letterToGuess : lettersToGuess) {
                if (letterToGuess.equalsIgnoreCase(letter)) {
                    numberOfGuessedLetters++;
                    guessedLetters.add(letter);
                }
            }
        }
        return numberOfGuessedLetters;
    }

    public Set<String> getGuessedLetters() {
        return guessedLetters;
    }

}

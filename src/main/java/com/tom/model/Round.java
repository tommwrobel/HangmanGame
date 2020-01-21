package com.tom.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Round {

    private final DifficultyLevel difficultyLevel;
    private final String wordToGuess;
    private final Set<String> guessedLetters;
    private int chancesLeft;

    public Round(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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
            Scanner scan = new Scanner(file);
            int numberOfWords = 0;
            List<String> words = new ArrayList<>();

            while (scan.hasNextLine()) {
                words.add(scan.nextLine());
                numberOfWords++;
            }

            return words.get(random(0, numberOfWords - 1));
        } catch (FileNotFoundException e) {
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

        if (!letterExistInGuessedLetterList(letter)) {
            String[] wordToGuess = this.wordToGuess.split("(?!^)");
            for (String toGuess : wordToGuess) {
                if (toGuess.equalsIgnoreCase(letter)) {
                    numberOfGuessedLetters++;
                    addLetterToGuessedList(letter);
                }
            }
        }

        return numberOfGuessedLetters;
    }

    public Set<String> getGuessedLetters() {
        return guessedLetters;
    }

    private void addLetterToGuessedList(String letter) {
        guessedLetters.add(letter);
    }

    private boolean letterExistInGuessedLetterList(String letter) {
        return guessedLetters.contains(letter);
    }

    private int random(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

}

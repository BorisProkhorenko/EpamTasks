package com.prokhorenko;

import java.util.Arrays;

public class Sentence {

    private Word[] words;

    public Sentence(Word[] words) {
        this.words = words;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public void printSentence() {
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(words);
    }
}

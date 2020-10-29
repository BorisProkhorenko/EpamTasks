package com.prokhorenko;

import java.util.Arrays;

public class Text {
    private String header;
    private Sentence[] sentences;

    public Text(Sentence[] sentences, String header) {
        this.sentences = sentences;
        this.header = header;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void printHeader() {
        System.out.println(header);
    }

    public void printText(){
        for (Sentence sentence:sentences) {
            sentence.printSentence();
        }
    }

    public void overrideSentence(int num, Sentence sentence) {
        sentences[num] = sentence;
    }

    @Override
    public String toString() {
        return "header='" + header  +
                ", sentences=" + Arrays.toString(sentences);
    }
}

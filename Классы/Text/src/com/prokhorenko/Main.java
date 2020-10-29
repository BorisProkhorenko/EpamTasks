package com.prokhorenko;

/*
1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
    консоль текст, заголовок текста.
*/
public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("Hello");
        Word word2 = new Word("World!");
        Word word3 = new Word("I");
        Word word4 = new Word("like");
        Word word5 = new Word("Java.");

        Word[] words1 = {word1, word2};
        Word[] words2 = {word3, word4, word5};
        Sentence sentence1 = new Sentence(words1);
        Sentence sentence2 = new Sentence(words2);
        Sentence[] sentences = {sentence1, sentence2};
        Text text = new Text(sentences, "Test");
        text.printHeader();
        text.printText();
        text.overrideSentence(0,sentence2);
        text.printText();
    }
}

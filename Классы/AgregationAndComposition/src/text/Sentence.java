package text;


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

    @Override
    public String toString() {
        return  Arrays.toString(words);
    }
}

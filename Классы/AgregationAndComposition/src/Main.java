import text.Sentence;
import text.Text;
import text.Word;

public class Main {


    public static void main(String[] args) {

        Word word1 = new Word("Hello");
        Word word2 = new Word("World");
        Word word3 = new Word("I");
        Word word4 = new Word("Love");
        Word word5 = new Word("You");

        Word[] words1 = {word1, word2};
        Word[] words2 = {word3, word4, word5};
        Sentence sentence1 = new Sentence(words1);
        Sentence sentence2 = new Sentence(words2);
        Sentence[] sentences = {sentence1, sentence2};
        Text text = new Text(sentences, "Header");

        System.out.println(text);
    }
}

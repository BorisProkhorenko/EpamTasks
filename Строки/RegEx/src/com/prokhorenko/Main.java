package com.prokhorenko;
import java.util.Arrays;


public class Main {
    /*
    1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
алфавиту.
     */

    /*
    Считает количество предложений
     */
    public static int sentenceCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?')
                count++;
        }
        return count;
    }

    /*
    Сортирует абзацы по кол-ву предложений
     */

    public static String paragraphSort(String s) {
        String[] strings = s.split("\n");
        for (int j = 0; j < strings.length - 1; j++)
            for (int i = 0; i < strings.length - 1; i++) {
                if (sentenceCount(strings[i]) > sentenceCount(strings[i + 1])) {
                    String temp = new String(strings[i]);
                    strings[i] = strings[i + 1];
                    strings[i + 1] = temp;
                }
            }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    /*
    Сортирует слова по длинне в каждом предложении
     */
    public static String sentenceSort(String s) {
        String[] sentences = s.split("\\.");
        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split("\\s");
            for (int j = 0; j < words.length - 1; j++)
                for (int z = 0; z < words.length - 1; z++) {
                    if (words[z].length() > words[z + 1].length()) {
                        String temp = new String(words[z]);
                        words[z] = words[z + 1];
                        words[z + 1] = temp;
                    }
                }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = 0; j < words.length; j++) {
                stringBuilder.append(" " + words[j]);
            }
            stringBuilder.append(".");
            sentences[i] = stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < sentences.length; i++) {
            stringBuilder.append(sentences[i]);
        }
        return stringBuilder.toString();
    }

    /*
    Сортирует слова по алфавиту в предложении
     */
    public static String[] alfSort(String s) {
        String[] strings = s.split("\\s");
        Arrays.sort(strings);
        return strings;
    }
    /*
    Считает кол-во символов в слове
     */
    public static int charCount(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                count++;

        }
        return count;
    }
    /*
    Сортирует лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
    алфавиту
     */
    public static String wordSort(String s, char c) {
        String[] strings = alfSort(s);
        for (int i = 0; i < strings.length - 1; i++)
            for (int j = 0; j < strings.length - 1; j++) {
                if (charCount(strings[j], c) < charCount(strings[j + 1], c)) {
                    String temp = new String(strings[j]);
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
            if (i < strings.length - 1)
                stringBuilder.append(" ");
        }
        stringBuilder.append(". ");
        return stringBuilder.toString();
    }

    /*
    wordSort ко всему тексту
     */
    public static String massWordSort(String s, char c) {
        String[] sentences = s.split("\\.");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = wordSort(sentences[i], c);
            stringBuilder.append(sentences[i]);

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String s = "But I must explain. to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";
        System.out.println(massWordSort(s, 'i'));

    }
}
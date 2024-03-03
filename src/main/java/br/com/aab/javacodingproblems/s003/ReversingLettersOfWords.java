package br.com.aab.javacodingproblems.s003;

import java.util.Arrays;

public class ReversingLettersOfWords {
    public String reverse(String[] words) {
        StringBuilder sbWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sbWords.append(revertLetters(words[i])).append(" ");
        }
        return sbWords.toString().substring(0, sbWords.length()-1);
    }

    private String revertLetters(String word) {
        StringBuilder sbLetters = new StringBuilder();
        char[] chars = word.toCharArray();
        for (int i = chars.length -1; i >= 0; i--) {
            sbLetters.append(chars[i]);
        }
        return sbLetters.toString();
    }

    public static void main(String[] args) {
        String[] s = "oluaP oaS a odnagehc avatse uE".split(" ");
        String[] input = Arrays.stream(s).toArray(String[]::new);
        ReversingLettersOfWords reversing = new ReversingLettersOfWords();
        System.out.printf("Inverting %s is [%s]%n", Arrays.toString(input), reversing.reverse(input));
    }
}

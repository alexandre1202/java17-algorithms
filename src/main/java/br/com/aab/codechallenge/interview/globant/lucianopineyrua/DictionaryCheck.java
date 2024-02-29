package br.com.aab.codechallenge.interview.globant.lucianopineyrua;

import java.util.List;
import java.util.Set;

/**
 * Dictionary Check -> "hello", "hall", "holy"
 * isValidPrefix
 *          ("h") -> true
 *          ("hell") -> true
 *          ("hon") -> false
 * isValidWord
 *          ("hell") -> false
 *          ("hello") -> true
 */
public class DictionaryCheck {

    private Set<String> dictionary = Set.of("hello", "hall", "holy");
    public boolean isValidPrefix(String prefix) {
        for (String wordFromDictionary: dictionary) {
            if (wordFromDictionary.startsWith(prefix)) return true;
        }
        return false;
    }

    public boolean isValidWord(String word) {
        for (String wordFromDictionary: dictionary) {
            if (wordFromDictionary.equals(word)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DictionaryCheck dictionaryCheck = new DictionaryCheck();
        String prefix = "h";
        var result = dictionaryCheck.isValidPrefix(prefix);
        System.out.printf("Searching for the prefix [%s] the result is [%b]%n", prefix, result);

        prefix = "hell";
        result = dictionaryCheck.isValidPrefix(prefix);
        System.out.printf("Searching for the prefix [%s] the result is [%b]%n", prefix, result);

        prefix = "hon";
        result = dictionaryCheck.isValidPrefix(prefix);
        System.out.printf("Searching for the prefix [%s] the result is [%b]%n", prefix, result);

        prefix = "hell";
        result = dictionaryCheck.isValidWord(prefix);
        System.out.printf("Searching for valid word [%s] the result is [%b]%n", prefix, result);

        prefix = "hello";
        result = dictionaryCheck.isValidWord(prefix);
        System.out.printf("Searching for valid word [%s] the result is [%b]%n", prefix, result);
    }
}

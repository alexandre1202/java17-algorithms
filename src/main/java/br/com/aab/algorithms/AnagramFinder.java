package br.com.aab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Context for Candidate: Given a list of words, return all groups of words that are anagrams of each other.
 *  An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
 *  all the original letters exactly once.
 *  Input:
 *      "listen", "integral", "enlist", "inlets","inlets", "silent", "earth", "apple", "heart", "earth", "cinema", "iceman", "triangle"
 *  Expected output:
 *      [earth, heart]
 *      [inlets, silent, enlist, listen]
 *      [integral, triangle]
 *      [apple]
 *      [iceman, cinema]
 */
public class AnagramFinder {
    public List<List<String>> findAnagrams(String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(this::sortedWord, HashMap::new, Collectors.toSet()))
                .values().stream().map(ArrayList::new)
                .collect(Collectors.toList());
    }
    private String sortedWord(String word) {
        char[] charWord = word.toCharArray();
        Arrays.sort(charWord);
        return new String(charWord);
    }
}

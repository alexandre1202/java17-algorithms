package br.com.aab.codechallenge.interview.justappraised;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string paragraph and a string array of the banned words banned,
 * return the most frequent word that is not banned, I mean, banned are exclusions
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.",
 * banned = ["hit"]
 * Output: "ball"
 * Challenged shared by Yan Xie
 */
public class MostFrequentWord {

    public String mostFrequentWord(String paragraph, List<String> bannedWords) {
        String[] paragraphArray = paragraph.toLowerCase().replaceAll(",", "").split(" ");
        var paragraphs = Arrays.stream(paragraphArray).toList();
        Map<String, Long> countingWords = new HashMap<>();

        List<String> filteredParagraphs = paragraphs.stream().filter(w -> !bannedWords.contains(w)).toList();
        for (String word: filteredParagraphs) {
            countingWords.compute(word, (k, v) -> v == null ? 1 : ++v);
        }

        long mostFrequent = 0;
        String result = "";
        for (Map.Entry<String, Long> entry: countingWords.entrySet()) {
            if (entry.getValue() > mostFrequent) {
                mostFrequent = entry.getValue();
                result = entry.getKey();
            }
        }
        return mostFrequent < 2 ? "" : result;
    }
}

package br.com.aab.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatedChar {
    static char findV1(String inputStr) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            map.compute(c, (k,v) -> v == null ? 1 : ++v);
        }

        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findAny().get();
    }

    static char findV2(String inputStr) {
        Map<Character, Integer> map = new LinkedHashMap();
        for (int i = 0; i < inputStr.length(); i++) {
            char letter = inputStr.charAt(i);
            map.compute(letter, (k, v) -> v == null ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return Character.MIN_VALUE;
    }
    public static void main(String[] args) {
        System.out.println("V1 -> aaabbcccdeeefffffxxz = " + findV1("aaabbcccdeeefffffxxz"));
        System.out.println("V2 -> aaabbcccdeeefffffxxz = " + findV2("aaabbcccdeeefffffxxz"));
    }
}

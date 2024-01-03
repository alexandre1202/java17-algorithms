package br.com.aab.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    static char findV3(String input) {
        Map<Character, Long> map = input.codePoints()
                .mapToObj(c -> Character.valueOf((char)c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findAny()
                .map(Map.Entry::getKey)
                .orElseGet(() -> Character.MIN_VALUE);
    }

    static char findV4(String input) {
         return input.codePoints()
                .mapToObj(c -> Character.valueOf((char)c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findAny()
                .map(Map.Entry::getKey)
                .orElseGet(() -> Character.MIN_VALUE);
    }

    static char findV5(String input) {
        var result = input.codePoints().boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(), HashMap::new, Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
        return (char) result.intValue();
    }

    public static void main(String[] args) {
        System.out.println("V1 -> aaabbcccdeeefffffxxz = " + findV1("aaabbcccdeeefffffxxz"));
        System.out.println("V2 -> aaabbcccdeeefffffxxz = " + findV2("aaabbcccdeeefffffxxz"));
        System.out.println("V5 -> aaabbcccdeeefffffxxz = " + findV5("aaabbcccdeeefffffxxz"));
    }
}

package br.com.aab.javacodingproblems.s001;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicatedChars {
    public Map<Character, Integer> countDuplicatedCharactersV1(String str) {
        Map<Character, Integer> result = new HashMap<>();
        char[] charsOfStr = str.toCharArray();
        for (char c: charsOfStr) {
            result.compute(c, (k,v) -> v == null ? 1 : ++v);
        }
        return result;
    }

    public Map<Character, Integer> countDuplicatedCharactersV2(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c: str.toCharArray()) {
            result.merge(c, 1, Integer::sum);
        }
        return result;
    }

    public void countMinMax(String input) {
        final char[] chars = input.toLowerCase().toCharArray();
        int indexOfMax = 0;
        int indexOfMin = 122;
        int[] alphabetic = new int[26];
        for (char c: chars) {
            int index = c - 'a';
            alphabetic[index]++;
            indexOfMax = Math.max(alphabetic[index], indexOfMax);
            indexOfMin = Math.min(alphabetic[index], indexOfMin);
        }
        System.out.printf("The character that repeats the most is [%s], occurring [%d] times.%n",
                (char) ('a' + alphabetic[indexOfMax]), indexOfMax);
        System.out.printf("The character that repeats the least is [%s], occurring [%d] times.%n",
                (char) ('a' + alphabetic[indexOfMin]), indexOfMin);
    }
    public Map<Character, Long> countDuplicatedCharactersV3(String str) {
        return str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(), HashMap::new, Collectors.counting()
                ));
    }

    public Map<Character, Long> countDuplicatedCharactersV4(String str) {
        return str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c-> c, Collectors.counting()));
    }

    public static void main(String[] args) {
        CountingDuplicatedChars count = new CountingDuplicatedChars();
        String input = "aaabaccdddd";

        count.countMinMax(input);

        var result = count.countDuplicatedCharactersV1(input);
        System.out.printf("V1 = %s%n", result);

        result = count.countDuplicatedCharactersV2(input);
        System.out.printf("V2 = %s%n", result);

        Map<Character, Long> resultLong = count.countDuplicatedCharactersV3(input);
        System.out.printf("V3 = %s%n", resultLong);

        resultLong = count.countDuplicatedCharactersV4(input);
        System.out.printf("V4 = %s%n", resultLong);
    }
}

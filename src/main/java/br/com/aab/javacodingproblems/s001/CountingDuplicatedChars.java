package br.com.aab.javacodingproblems.s001;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicatedChars {
    private Map<Character, Integer> result = new HashMap<>();
    public Map<Character, Integer> countDuplicatedCharactersV1(String str) {
        char[] charsOfStr = str.toCharArray();
        for (char c: charsOfStr) {
            result.compute(c, (k,v) -> v == null ? 1 : ++v);
        }
        return result;
    }

    public Map<Character, Integer> countDuplicatedCharactersV2(String str) {
        result = new HashMap<>();
        for (char c: str.toCharArray()) {
            result.merge(c, 1, Integer::sum);
        }
        return result;
    }

    public Map<Character, Long> countDuplicatedCharactersV3(String str) {
        return str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(), HashMap::new, Collectors.counting()
                ));
    }

    public static void main(String[] args) {
        CountingDuplicatedChars count = new CountingDuplicatedChars();
        String input = "aaabaccdddd";

        var result = count.countDuplicatedCharactersV1(input);
        System.out.printf("V1 = %s%n", result);

        result = count.countDuplicatedCharactersV2(input);
        System.out.printf("V2 = %s%n", result);

        Map<Character, Long> resultLong = count.countDuplicatedCharactersV3(input);
        System.out.printf("V3 = %s%n", resultLong);
    }
}

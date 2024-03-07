package br.com.aab.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountingRepeatedChars {
    public Map<Character, Integer> countingTheMostV1(String input) {
        Map<Character, Long> counting = buildMapCount(input);
        int maxValue = 0;
        Character charMaxValue = Character.MIN_VALUE;
        for (Map.Entry<Character, Long> e: counting.entrySet()) {
            int value = e.getValue().intValue();
            if (value > maxValue) {
                maxValue = value;
                charMaxValue = e.getKey();
            }
        }
        Map<Character, Integer> result = new HashMap<>();
        result.put(charMaxValue, maxValue);
        return result;
    }

    public Map<Character, Integer> countingTheMostV2(String input) {
        return buildMapCount(input).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> Map.of(entry.getKey(), entry.getValue().intValue()))
                .orElseGet(HashMap::new);
    }

    public Map<Character, Integer> countingTheLeastV1(String input) {
        Map<Character, Long> counting = buildMapCount(input);
        int minValue = "x".chars().sum();
        Character charMinValue = Character.MAX_VALUE;
        for (Map.Entry<Character, Long> e: counting.entrySet()) {
            int value = e.getValue().intValue();
            if (value < minValue) {
                minValue = value;
                charMinValue = e.getKey();
            }
        }
        Map<Character, Integer> result = new HashMap<>();
        result.put(charMinValue, minValue);
        return result;
    }

    public Map<Character, Integer> countingTheLeastV2(String input) {
        return buildMapCount(input).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(entry -> Map.of(entry.getKey(), entry.getValue().intValue()))
                .orElseGet(HashMap::new);
    }

    private static Map<Character, Long> buildMapCount(String input) {
        return input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    public static void main(String[] args) {
        CountingRepeatedChars counting = new CountingRepeatedChars();
        String input = "aaaaddxxxxxxxxxexjx";

        printTheMap(counting.countingTheMostV1(input),
                "V1 !!! The maximum input of [%s] contain [%d] times of value [%s]%n", input);

        printTheMap(counting.countingTheMostV2(input),
                "V2 !!! The maximum input of [%s] contain [%d] times of value [%s]%n", input);
        System.out.printf("%n============================%n");
        printTheMap(counting.countingTheLeastV1(input),
                "V1 !!! The minimum input of [%s] contain [%d] times of value [%s]%n", input);

        printTheMap(counting.countingTheLeastV2(input),
                "V2 !!! The minimum input of [%s] contain [%d] times of value [%s]%n", input);

    }

    private static void printTheMap(Map<Character, Integer> result, String format, String input) {
        var resultKey = result.entrySet().stream().findFirst().orElse(null);
        resultKey = result.entrySet().stream().findFirst().orElse(null);
        if (!Objects.isNull(resultKey))
            System.out.printf(format,
                    input, resultKey.getValue(), resultKey.getKey());
    }
}

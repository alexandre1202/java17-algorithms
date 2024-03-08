package br.com.aab.codechallenge.hackerrank.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
 */
public class BirthdayCakeCandles {
    public int birthdayCakeCandlesV1(List<Integer> candles) {
        if (Objects.isNull(candles) || candles.size() < 2) return 0;

        return candles.stream().collect(Collectors.groupingBy(
                        i -> i, Collectors.counting()
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .map(Long::intValue)
                .orElseGet(() -> 0);
    }

    public int birthdayCakeCandlesV2(List<Integer> candles) {
        if (Objects.isNull(candles) || candles.size() < 2) return 0;

        var candlesToMap = candles.stream().collect(Collectors.groupingBy(
                c -> c, Collectors.counting()
        ));
        long maxCount = 0;
        for (long count : candlesToMap.values()) {
            maxCount = Math.max(maxCount, count);
        }

        return (int) maxCount;
    }

    public static void main(String[] args) {
        BirthdayCakeCandles candles = new BirthdayCakeCandles();
        var inputSample1 = List.of(4, 4, 1, 3);
        var result = candles.birthdayCakeCandlesV1(inputSample1);
        System.out.printf("Sample 1/V1 - The input %s contain %d highest candles.%n", inputSample1, result);

        var inputSample2 = List.of(3, 2, 1, 3);
        result = candles.birthdayCakeCandlesV1(inputSample2);
        System.out.printf("Sample 2/V1 - The input %s contain %d highest candles.%n", inputSample2, result);

        result = candles.birthdayCakeCandlesV2(inputSample1);
        System.out.printf("Sample 1/V2 - The input %s contain %d highest candles.%n", inputSample1, result);

        result = candles.birthdayCakeCandlesV2(inputSample2);
        System.out.printf("Sample 2/V2 - The input %s contain %d highest candles.%n", inputSample2, result);

    }
}

package br.com.aab.algorithms;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Objects;

public class FindingTheMissingNumber {
    public long missingNumberV1(int[] array) {
        if (Objects.isNull(array) || array.length < 2) return array[0];
        IntSummaryStatistics iss = Arrays.stream(array).summaryStatistics();
        long lower = iss.getMin(), high = iss.getMax(), sum = iss.getSum();
        long result = (high + lower) * (high - lower + 1) / 2 - sum;
        return Long.valueOf(result).intValue();
    }
}

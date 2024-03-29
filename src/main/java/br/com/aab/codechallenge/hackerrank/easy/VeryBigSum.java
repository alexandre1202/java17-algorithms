package br.com.aab.codechallenge.hackerrank.easy;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem?isFullScreen=true
 */
public class VeryBigSum {
    public long aVeryBigSum(List<Long> ar) {
        long result = 0L;
        for(Long n: ar) {
            result += n;
        }
        return result;
    }

    public long aVeryBigSumWithStream(List<Long> ar) {
        return ar.stream().mapToLong(Long::longValue).sum();
    }
}

package br.com.aab.codechallenge.hackerrank.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
 */
public class MinAndMaxSum {
    public void miniMaxSumUsingSort(List<Integer> arr) {
        /**
         * Using sort
         */
        Collections.sort(arr);
        long sum = arr.stream().mapToInt(i -> i).sum();
        long left = sum - arr.get(arr.size() - 1);
        long right = sum - arr.get(0);
        System.out.printf("%d %d%n", left, right);
    }

    public void miniMaxSumUsingWithoutSort(List<Integer> arr) {
        /**
         * Most efficient, without sort
         */
        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int num : arr) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        long left = sum - max;
        long right = sum - min;
        System.out.printf("%d %d\n", left, right);
    }

    public static void main(String[] args) {
        MinAndMaxSum minAndMaxSum = new MinAndMaxSum();

        var immutableInput1 = List.of(1, 3, 5, 7, 9); //Result 16 24
        var mutableInput1 = new ArrayList<>(immutableInput1);
        minAndMaxSum.miniMaxSumUsingSort(mutableInput1);
        minAndMaxSum.miniMaxSumUsingWithoutSort(immutableInput1);

        var immutableList2 = List.of(1, 2, 3, 4, 5); //Result 10 14
        var mutableList2 = new ArrayList<>(immutableList2);
        minAndMaxSum.miniMaxSumUsingSort(mutableList2);
        minAndMaxSum.miniMaxSumUsingWithoutSort(immutableList2);
    }
}

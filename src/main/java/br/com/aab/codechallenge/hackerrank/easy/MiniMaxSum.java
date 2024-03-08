package br.com.aab.codechallenge.hackerrank.easy;

import java.util.Collections;
import java.util.List;

public class MiniMaxSum {
    public void miniMaxSumUsingSort(List<Integer> arr) {
        /**
         * Using sort
         */
        Collections.sort(arr);
        long sum = arr.stream().mapToInt(i -> i).sum();
        long left = sum - arr.get(arr.size() - 1);
        long right = sum - arr.get(0);
        System.out.printf("%d %d", left, right);
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
        MiniMaxSum miniMaxSum = new MiniMaxSum();

        var input1 = List.of(1, 3, 5, 7, 9); //Result 16 24
        miniMaxSum.miniMaxSumUsingWithoutSort(input1);

        var input2 = List.of(1, 2, 3, 4, 5); //Result 10 14
        miniMaxSum.miniMaxSumUsingWithoutSort(input2);
    }
}

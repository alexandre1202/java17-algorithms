package br.com.aab.leetcode.dsa.arraysandstrings.slidingwindow;

import java.util.Arrays;

public class LongestSubArrayForSum {

    public static void main(String[] args) {
        LongestSubArrayForSum practicing = new LongestSubArrayForSum();
        int[] input = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        int result = practicing.findWindowOfTheSum(input, k);
        System.out.printf("For the array %s this is the index window [%d] for sum of [%d]%n",
                Arrays.toString(input), result, k);
    }
    private int findWindowOfTheSum(int[] input, int k) {
        int i = 0;
        int sum = 0;
        for (int j = 0; j < input.length; j++) {
            sum += input[j];
            while (sum > k) {
                sum -= input[i++];
            }
            if (sum == k) return j - i + 1;
        }
        return 0;
    }
}

package br.com.aab.leetcode.dsa.arraysandstrings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumAverageSubarray {
    public int getMaxAverage(int[] nums, int k) {
        int result = 0;
        int[] sums = IntStream.range(0, nums.length)
                .map(n -> nums[n] + (n == 0 ? 0 : nums[n-1]) )
                .toArray();
        return result;
    }

    public static void main(String[] args) {
        /**
         * Preciso encontrar o enunciado e consertar o codigo
         */
        MaximumAverageSubarray mas = new MaximumAverageSubarray();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("max average " + Arrays.toString(nums) + " = " + mas.getMaxAverage(nums, k));
    }
}

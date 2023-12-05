package br.com.aab.leetcode.dsa.prefixsum;

import java.util.Arrays;

public class FindingHighestSegment {
    /**
     * Given an integer array nums, find the number of ways to split the array into two parts so
     * that the first section has a sum greater than or equal to the sum of the second section.
     * The second section should have at least one number.
     * Leetcode - prefix
     */

    private int countingHighSegmentsInOrder(int[] nums) {
        int result = 0;
        int lengthOfNums = nums.length;
        int[] prefix = new int[lengthOfNums];
        prefix[0] = nums[0];
        for (int i = 1; i < lengthOfNums - 1; i++) {
            prefix[i] = nums[i] + nums[i-1];
        }
        for (int i = 0; i < lengthOfNums-1; i++) {
            int sum = prefix[lengthOfNums-1] - prefix[i];
            if (prefix[i] >= sum) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, -8, 7};
        FindingHighestSegment exec = new FindingHighestSegment();
        int result = exec.countingHighSegmentsInOrder(nums);
        System.out.printf("There are [%d] segments with sum are greater than the sequence of %s",
                result, Arrays.toString(nums));
    }
}

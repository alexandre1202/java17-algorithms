package br.com.aab.leetcode.dsa.arraysandstrings.maxconsecutiveones;

import java.util.Arrays;

public class MaxConsecutiveOnes {
    private int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;
            if (k < 0) k += 1 - nums[left++];
        }
        return right - left;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes max = new MaxConsecutiveOnes();

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = max.longestOnes(nums, k);
        System.out.printf("The longest sequence of zeros is [%d] for the array %s with window [%d]%n",
                result, Arrays.toString(nums), k);

        nums = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        k = 3;
        result = max.longestOnes(nums, k);
        System.out.printf("The longest sequence of zeros is [%d] for the array %s with window [%d]%n",
                result, Arrays.toString(nums), k);
    }
}

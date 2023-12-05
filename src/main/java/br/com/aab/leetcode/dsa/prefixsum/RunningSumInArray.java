package br.com.aab.leetcode.dsa.prefixsum;

import java.util.Arrays;

public class RunningSumInArray {
    private int[] buildingPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        return prefix;
    }

    public static void main(String[] args) {
        RunningSumInArray exec = new RunningSumInArray();
        int[] nums = {1,2,3,4};
        int[] result = exec.buildingPrefixSum(nums);
        System.out.printf("The running sum of %s is %s%n",
                Arrays.toString(nums), Arrays.toString(result));

        nums = new int[] {1,1,1,1};
        result = exec.buildingPrefixSum(nums);
        System.out.printf("The running sum of %s is %s%n",
                Arrays.toString(nums), Arrays.toString(result));

        nums = new int[] {3,1,2,10,1};
        result = exec.buildingPrefixSum(nums);
        System.out.printf("The running sum of %s is %s%n",
                Arrays.toString(nums), Arrays.toString(result));
    }
}

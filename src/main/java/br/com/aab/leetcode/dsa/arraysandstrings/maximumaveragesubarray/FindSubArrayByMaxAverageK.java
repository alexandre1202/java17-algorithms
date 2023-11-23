package br.com.aab.leetcode.dsa.arraysandstrings.maximumaveragesubarray;

import java.util.Arrays;

public class FindSubArrayByMaxAverageK {
    private double findMaxAverageByK(int[] nums, int k) {
        double sum = 0;
        double maxAverage = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k-1) {
                if (i > k-1) sum -= nums[i-k];
                double average = sum / k;
                maxAverage = Math.max(average, maxAverage);
            }
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        FindSubArrayByMaxAverageK finder = new FindSubArrayByMaxAverageK();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double result = finder.findMaxAverageByK(nums, k);
        System.out.printf("The max average for the array %s with window [%d] is [%f]%n",
                Arrays.toString(nums), k, result);

        nums = new int[]{5};
        k = 1;
        result = finder.findMaxAverageByK(nums, k);
        System.out.printf("The max average for the array %s with window [%d] is [%f]%n",
                Arrays.toString(nums), k, result);
    }
}

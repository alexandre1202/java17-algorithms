package br.com.aab.leetcode.dsa.arraysandstrings.maximumaveragesubarray;

import java.util.Arrays;

public class FindSubArrayByMaxAverageK {
    private double findMaxAverageByK(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        double sum = 0;
        double maxAverage = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k-1) {
                if (i > k-1) sum -= nums[i-k];
                double average = sum / k;
                maxAverage = (i+1) == k ? average : Math.max(average, maxAverage);
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

        nums = new int[]{-1};
        k = 1;
        result = finder.findMaxAverageByK(nums, k);
        System.out.printf("The max average for the array %s with window [%d] is [%f]%n",
                Arrays.toString(nums), k, result);

        nums = new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
        k = 93;
        //result = 3768.28.571
        result = finder.findMaxAverageByK(nums, k);
        System.out.printf("The max average for the array %s with window [%d] is [%f]%n",
                Arrays.toString(nums), k, result);

    }
}

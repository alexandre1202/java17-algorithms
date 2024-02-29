package br.com.aab.leetcode.dsa.prefixsum;

import java.util.Arrays;

public class FindMinimumValueGetPositiveStepByStep {
    /**
     * The step-by-step total equals startValue at the beginning. Use boolean parameter "isValid"
     * to record whether the total is larger than or equal to 1.
     */
    public int minStartValue(int[] nums) {
        int left = 1;
        int right = 100 * nums.length + 1;

        while (left < right) {
            int middle = (left + right) / 2;
            int total = middle;
            boolean isValid = true;

            for (int num : nums) {
                total += num;
                if (total < 1) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        FindMinimumValueGetPositiveStepByStep exec = new FindMinimumValueGetPositiveStepByStep();
        int[] nums = {-3,2,-3,4,2};
        int result = exec.minStartValue(nums);
        System.out.printf("The minimal value in the %s is %d ",
                Arrays.toString(nums), result);
    }
}

package br.com.aab.leetcode.dsa.slidingwindow;

import java.util.Arrays;
import java.util.TreeSet;

public class FindTheLargestSumForFixedWindow {
    public static void main(String[] args) {
        FindTheLargestSumForFixedWindow exec = new FindTheLargestSumForFixedWindow();

        int[] input = {3, -1, 4, 12, -8, 5, 6};
        int windowSize = 4;
        int result = exec.findTheMaxValueForElements(input, windowSize);
        System.out.printf("The maximum value of the sum for the array %s is [%d] with window of [%d]%n", Arrays.toString(input), result, windowSize);

        input = new int[]{3, 4, 5, 6, 1, 12, 2, 1};
        windowSize = 2;
        result = exec.findTheMaxValueForElements(input, windowSize);
        System.out.printf("The maximum value of the sum for the array %s is [%d] with window of [%d]%n", Arrays.toString(input), result, windowSize);

        input = new int[]{3, 4, 1, 1};
        windowSize = 2;
        result = exec.findTheMaxValueForElements(input, windowSize);
        System.out.printf("The maximum value of the sum for the array %s is [%d] with window of [%d]%n", Arrays.toString(input), result, windowSize);
    }

    private int findTheMaxValueForElements(int[] input, int windowSize) {
        TreeSet<Integer> result = new TreeSet<>();
        int acum = 0;
        for (int i = 0; i < input.length; i++) {
            acum += input[i];
            if ((i+1) > windowSize) {
                acum -= input[i - windowSize];
            }
            if (i >= (windowSize-1) ) {
                result.add(acum);
            }
        }
        return result.last();
    }
}

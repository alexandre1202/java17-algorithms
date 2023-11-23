package br.com.aab.leetcode.dsa.arraysandstrings.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSubArray {
    private static int[] findPairsOfOrderedNumbersForTheSum(int[] arr, int s) {
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[leftIndex] + arr[rightIndex]) == s) {
                return new int[]{arr[leftIndex], arr[rightIndex]};
            } else {
                if ((arr[leftIndex] + arr[rightIndex]) > s) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return new int[]{};
    }

    private static List<Integer> findWindowOfIndexesForTheSum(int[] arr, int n, int s) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            /** Here I sum every element until the sum is greater than the target parameter sum */
            sum += arr[j];
            while (sum > s) {
                /** !!! Here I subtract the initial values that were added in the beginning !!! */
                sum -= arr[i];
                i++;
            }
            if (sum == s && i <= j) {
                result.add(i+1);
                result.add(j+1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("findWindowOfIndexesForTheSum({1,2,3,7,5}, 5, 12) = " + findWindowOfIndexesForTheSum(new int[]{1,2,3,7,5}, 5, 12));
        System.out.println("findWindowOfIndexesForTheSum({1,2,3,4,5,6,7,8,9,10}, 10, 15) = " + findWindowOfIndexesForTheSum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 15));

        System.out.println("findPairsOfOrderedNumbersForTheSum({1,2,4,6,8,9,14, 15}, 13) = " + Arrays.toString(findPairsOfOrderedNumbersForTheSum(new int[]{1, 2, 4, 6, 8, 9, 14, 15}, 13)));
        System.out.println("findPairsOfOrderedNumbersForTheSum({1,2,4,6,8,9,14, 15}, 99) = " + Arrays.toString(findPairsOfOrderedNumbersForTheSum(new int[]{1, 2, 4, 6, 8, 9, 14, 15}, 99)));
        System.out.println("findPairsOfOrderedNumbersForTheSum({1, 2}, 99) = " + Arrays.toString(findPairsOfOrderedNumbersForTheSum(new int[]{1,2}, 99)));
        System.out.println("findPairsOfOrderedNumbersForTheSum({1, 2}, 3) = " + Arrays.toString(findPairsOfOrderedNumbersForTheSum(new int[]{1,2}, 3)));
    }

}

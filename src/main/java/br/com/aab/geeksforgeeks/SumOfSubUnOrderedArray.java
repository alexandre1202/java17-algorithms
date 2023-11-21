package br.com.aab.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&sprint=a663236c31453b969852f9ea22507634&sortBy=submissions
 */
public class SumOfSubUnOrderedArray {
    private static List<Integer> algorithm(int[] arr, int n, int s) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            while (sum > s) {
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
        System.out.println("algorithm({1,2,3,7,5}, 5, 12) = " + algorithm(new int[]{1,2,3,7,5}, 5, 12));
        System.out.println("algorithm({1,2,3,4,5,6,7,8,9,10}, 10, 15) = " + algorithm(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 15));
    }
}

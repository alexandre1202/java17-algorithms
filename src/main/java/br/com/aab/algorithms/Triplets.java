package br.com.aab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets {
    /**
     *  n elements
     *  objective: sum of 3 of them == zero, without duplicated numbers
     *  nums = [-1, 0, 1, 2, -1, -4]
     *  result = {[-1,0,1],[-1,2,-1]}
     */

    public static void main(String[] args) {
        Integer[] input = new Integer[]{-1, 0, 1, 2, -1, -4};
        List<Integer[]> integers = sumOfSubArrayWithOutDuplicatedValues(input, 0);
        for (Integer[] intArray: integers) {
            System.out.println("intArray = " + Arrays.toString(intArray));
        }
    }
    public static List<Integer[]> sumOfSubArrayWithOutDuplicatedValues(Integer[] integers, int s) {
        Arrays.sort(integers);
        List<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < integers.length - 2; i++) {
            if (i > 0 && integers[i] == integers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = integers.length - 1;
            while (left < right) {
                int sum = integers[i] + integers[left] + integers[right];
                if (sum == s) {
                    result.add(new Integer[] {integers[left++], integers[right--]});
                } else if (sum > s) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}

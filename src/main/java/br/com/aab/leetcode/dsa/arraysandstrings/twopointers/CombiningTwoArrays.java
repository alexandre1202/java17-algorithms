package br.com.aab.leetcode.dsa.arraysandstrings.twopointers;

import java.util.Arrays;
import java.util.List;

public class CombiningTwoArrays {
    static int[] array1 = {1, 4, 7, 20};
    static int[] array2 = {3, 5, 6};
    public static void main(String[] args) {
        System.out.println("Merging the array1 " + Arrays.toString(array1) + " with " + Arrays.toString(array2));
        Arrays.asList(combineArraysSorted(array1, array2)).forEach(e -> System.out.println(Arrays.toString(e)));
        System.out.println("========================================");

        System.out.println("Combining the array1 " + Arrays.toString(array1) + " with " + Arrays.toString(array2));
        System.out.println(combineArraysInPairs());
    }

    private static int[] combineArraysSorted(int[] array1, int[] array2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int limit = array1.length + array2.length;
        int[] result = new int[limit];
        int counter = 0;
        while (pointer1 < array1.length && pointer2 < array2.length) {
            if (array1[pointer1] < array2[pointer2]) {
                result[counter] = array1[pointer1++];
            } else if (array2[pointer2] < array1[pointer1]) {
                result[counter] = array2[pointer2++];
            } else {
                result[counter] = array2[pointer1++];
                pointer2++;
            }
            counter++;
        }
        if (array1.length < array2.length) {
            int newCounter = limit - (array2.length - array1.length) - 1;
            for (int i = newCounter; i < limit; i++) {
                result[i] = array2[pointer2++];
            }
        } else {
            int newCounter = limit - (array1.length - array2.length) - 1;
            for (int i = newCounter; i < limit; i++) {
                result[i] = array1[pointer1++];
            }
        }
        return result;
    }

    private static String combineArraysInPairs() {
        List<Integer> integers1 = Arrays.stream(array1).boxed().toList();
        List<Integer> integers2 = Arrays.stream(array2).boxed().toList();
        List<List<Integer>> pairs = integers1
                .stream().flatMap(i -> integers2.stream().map(j -> Arrays.asList(i, j))).toList();
        return Arrays.toString(pairs.toArray());
    }
}

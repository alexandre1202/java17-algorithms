package br.com.aab.leetcode.dsa.prefixsum;

import java.util.Arrays;

public class ArrayOfQueriesForIntegerArray {
    private boolean[] answerQueries(int[] integers, int[][] queries, int limit) {
        int[] prefix = new int[integers.length];
        prefix[0] = integers[0];
        for (int i = 1; i < integers.length; i++) {
            prefix[i] = prefix[i-1] + integers[i];
        }

        boolean[] queriesResult = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            queriesResult[i] = (prefix[y] - prefix[x] + integers[x]) < limit;
        }
        return queriesResult;
    }

    public static void main(String[] args) {
        /**
         * Example 1: Given an integer array nums, an array queries where queries[i] = [x, y] and
         * an integer limit, return a boolean array that represents the answer to each query. A
         * query is true if the sum of the subarray from x to y is less than limit, or false otherwise.
         *
         * For example,
         *      given nums = [1, 6, 3, 2, 7, 2],
         *      queries = [[0, 3], [2, 5], [2, 4]], and
         *      limit = 13,
         *      the answer is [true, false, true].
         * For each query, the subarray sums are [12, 14, 12].
         * By Leetcode
         * The prefix are [1, 7, 10, 12, 19, 21]
         */
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
        int limit = 13;

        ArrayOfQueriesForIntegerArray queriesForIntegerArray = new ArrayOfQueriesForIntegerArray();
        boolean[] result = queriesForIntegerArray.answerQueries(nums, queries, limit);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("The result is [%s] for query %s and limit of %d%n",
                    result[i], Arrays.toString(nums), limit);
        }
    }
}

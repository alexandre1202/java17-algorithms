package br.com.aab.codechallenge.hackerrank.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/magic-square-forming/problem?isFullScreen=true
 */
public class FormingMagicSquare {
    public static int formingMagicSquare(List<List<Integer>> s) {
        List<List<List<Integer>>> possibleMagicSquares = new ArrayList<>(Arrays.asList(
                Arrays.asList(Arrays.asList(8, 1, 6), Arrays.asList(3, 5, 7), Arrays.asList(4, 9, 2)),
                Arrays.asList(Arrays.asList(6, 1, 8), Arrays.asList(7, 5, 3), Arrays.asList(2, 9, 4)),
                Arrays.asList(Arrays.asList(4, 9, 2), Arrays.asList(3, 5, 7), Arrays.asList(8, 1, 6)),
                Arrays.asList(Arrays.asList(2, 9, 4), Arrays.asList(7, 5, 3), Arrays.asList(6, 1, 8)),
                Arrays.asList(Arrays.asList(8, 3, 4), Arrays.asList(1, 5, 9), Arrays.asList(6, 7, 2)),
                Arrays.asList(Arrays.asList(4, 3, 8), Arrays.asList(9, 5, 1), Arrays.asList(2, 7, 6)),
                Arrays.asList(Arrays.asList(6, 7, 2), Arrays.asList(1, 5, 9), Arrays.asList(8, 3, 4)),
                Arrays.asList(Arrays.asList(2, 7, 6), Arrays.asList(9, 5, 1), Arrays.asList(4, 3, 8))
        ));

        int minCost = Integer.MAX_VALUE;
        for (List<List<Integer>> p : possibleMagicSquares) {
            int curCost = 0;
            for (int i = 0; i < p.size(); i++) {
                for (int j = 0; j < p.get(i).size(); j++) {
                    curCost += Math.abs(s.get(i).get(j) - p.get(i).get(j));
                }
            }
            if (curCost < minCost) {
                minCost = curCost;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        List<List<Integer>> s = new ArrayList<>(Arrays.asList(
                Arrays.asList(4, 9, 2),
                Arrays.asList(3, 5, 7),
                Arrays.asList(8, 1, 5)
        ));
        System.out.println(formingMagicSquare(s)); // Output: 1
    }

}

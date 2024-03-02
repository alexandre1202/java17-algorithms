package br.com.aab.codechallenge.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

/**
 * https://www.hackerrank.com/challenges/magic-square-forming/problem?isFullScreen=true
 * Explained by FelixTechTips
 * https://youtu.be/FMxA_g9oQnA?si=tvxakb2xtqpWtykf
 */
public class FormingMagicSquare {
    public static int formingMagicSquare(List<List<Integer>> s) {
        List<List<List<Integer>>> possibleMagicSquares = new ArrayList<>(asList(
                asList(asList(8, 1, 6), asList(3, 5, 7), asList(4, 9, 2)),
                asList(asList(6, 1, 8), asList(7, 5, 3), asList(2, 9, 4)),
                asList(asList(4, 9, 2), asList(3, 5, 7), asList(8, 1, 6)),
                asList(asList(2, 9, 4), asList(7, 5, 3), asList(6, 1, 8)),
                asList(asList(8, 3, 4), asList(1, 5, 9), asList(6, 7, 2)),
                asList(asList(4, 3, 8), asList(9, 5, 1), asList(2, 7, 6)),
                asList(asList(6, 7, 2), asList(1, 5, 9), asList(8, 3, 4)),
                asList(asList(2, 7, 6), asList(9, 5, 1), asList(4, 3, 8))
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
        List<List<Integer>> s = new ArrayList<>(asList(
                asList(4, 9, 2),
                asList(3, 5, 7),
                asList(8, 1, 5)
        ));
        System.out.println(formingMagicSquare(s)); // Output: 1
    }

}

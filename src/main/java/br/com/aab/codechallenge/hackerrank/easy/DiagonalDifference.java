package br.com.aab.codechallenge.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
 */
public class DiagonalDifference {
    public int diagonalDifference(List<List<Integer>> arr) {
        int l = 0;
        int r = arr.get(0).size() -1;
        List<Integer> leftToRight = new ArrayList<>();
        List<Integer> rightToLeft = new ArrayList<>();
        for (List<Integer> line: arr) {
            leftToRight.add(line.get(l++));
            rightToLeft.add(line.get(r--));
        }
        int sum = sumList(leftToRight) - sumList(rightToLeft);
        return Math.abs(sum);
    }

    private int sumList(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        List<List<Integer>> input = List.of(List.of(1,2,3), List.of(4,5,6), List.of(9,8,9));
        DiagonalDifference difference = new DiagonalDifference();
        int result = difference.diagonalDifference(input);
        System.out.printf("The diagonal difference is [%d]%n", result);
    }
}

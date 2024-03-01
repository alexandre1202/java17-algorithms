package br.com.aab.codechallenge.hackerrank.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=true
 */
public class PlusMinus {
    public  void plusMinus(List<Integer> arr) {
        float positives = 0;
        float negatives = 0;
        float zeros = 0;
        float divisor = arr.size();
        for (Integer i: arr) {
            if (i < 0) {
                negatives++;
            } else if (i > 0) {
                positives++;
            } else {
                zeros++;
            }
        }

        System.out.printf("%.6f%n", (positives / divisor));
        System.out.printf("%.6f%n", (negatives / divisor));
        System.out.printf("%.6f%n", (zeros / divisor));
    }

    public static void main(String[] args) {
        var input = List.of(-4, 3, -9, 0, 4, 1);
        PlusMinus plusMinus = new PlusMinus();
        plusMinus.plusMinus(input);
    }
}

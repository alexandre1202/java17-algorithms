package br.com.aab.algorithms;

import java.util.Arrays;

public class SquareOfArray {
    public static void main(String[] args) {
        int[] numbers = {12,9,2,3,10};
        int[] array = Arrays.stream(numbers)
                .filter(e -> e > 0)
                .sorted()
                .map(e -> e * e).toArray();
        Arrays.stream(array).forEach(System.out::println);
    }
}

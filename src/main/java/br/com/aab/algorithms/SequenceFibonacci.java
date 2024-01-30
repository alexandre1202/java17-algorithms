package br.com.aab.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SequenceFibonacci {
    public int[] calcSequence(final Integer LIMIT) {
        return Stream.iterate(new int[] {0, 1}, s -> new int[] {s[1] + s[0], s[0]})
                .limit(LIMIT)
                .collect(Collectors.toList())
                .stream()
                .mapToInt(f -> f[0])
                .toArray();
    }

    public int sumSequence(final int LIMIT) {
        final int[] fibonacciSequence = calcSequence(LIMIT);
        return Arrays.stream(fibonacciSequence).sum();
    }

    public static void main(String[] args) {
        SequenceFibonacci fibonacci = new SequenceFibonacci();
        Arrays.stream(fibonacci.calcSequence(10)).forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println("Sum of sequence 10 = " + fibonacci.sumSequence(10));
    }
}
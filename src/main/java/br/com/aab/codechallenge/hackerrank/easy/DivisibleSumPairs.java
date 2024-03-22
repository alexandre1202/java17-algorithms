package br.com.aab.codechallenge.hackerrank.easy;

import java.util.List;

public class DivisibleSumPairs {
    public static int divisibleSumPairsBruteForce(int divisor, List<Integer>numbers) {
        int numberOfPairs = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                int sumOfPairs = numbers.get(i) + numbers.get(j);
                if ((sumOfPairs % divisor) == 0)
                    numberOfPairs++;
            }
        }
        return numberOfPairs;
    }
//    public static int divisibleSumPairsOptimizationV1(int divisor, List<Integer> numbers) {
//        int[] countRemain = new int[divisor];
//        int numberOfPairs = 0;
//        for (int number: numbers) {
//            int remain = number % divisor;
//            if (remain < 0)
//                remain += divisor;
//            numberOfPairs += countRemain[remain];
//            countRemain[remain]++;
//        }
//        return numberOfPairs;
//    }

//    public static int divisibleSumPairsOptimizationV1(int divisor, List<Integer> numbers) {
//        Map<Integer, Integer> remainderCount = new HashMap<>();
//        int count = 0;
//
//        for (int number : numbers) {
//            int remainder = number % divisor;
//            int complement = (divisor - remainder) % divisor;
//
//            count += remainderCount.getOrDefault(complement, 0);
//            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
//        }
//
//        return count;
//    }

    public static int divisibleSumPairsOptimizationV1(int divisor, List<Integer> numbers) {
        int[] remainderCount = new int[divisor];
        int count = 0;

        for (int number : numbers) {
            int remainder = number % divisor;
            int complement = (divisor - remainder) % divisor;
            count += remainderCount[complement];
            remainderCount[remainder]++;
        }

        return count;
    }

    public static void main(String[] args) {
        String output = "[%d] is the total of pairs that the sum is mod of [%d] for this input %s.%n";
        var immutableInputSample1 = List.of(1, 2, 3, 4, 5, 6);    // Result is 3
        var divisorSample1 = 5;

        var immutableInputSample2 = List.of(8, 10);               // Result is 2
        var divisorSample2 = 2;

        var immutableInputSample3 = List.of(5, 9, 10, 7, 4);      // Result is 4
        var divisorSample3 = 2;

        System.out.println("---------------- Brute Force ----------------");
        var resultSample1OptimizationV1 = divisibleSumPairsBruteForce(divisorSample1, immutableInputSample1);
        System.out.printf("Brute force - " + output,
                resultSample1OptimizationV1, divisorSample1, immutableInputSample1);

        var resultSample2OptimizationV1 = divisibleSumPairsBruteForce(divisorSample2, immutableInputSample2);
        System.out.printf("Brute force - " + output,
                resultSample2OptimizationV1, divisorSample2, immutableInputSample2);

        var resultSample3OptimizationV1 = divisibleSumPairsBruteForce(divisorSample3, immutableInputSample3);
        System.out.printf("Brute force - " + output,
                resultSample3OptimizationV1, divisorSample3, immutableInputSample3);

        System.out.println("\n---------------- Optimizations V1 ----------------");
        resultSample1OptimizationV1 = divisibleSumPairsOptimizationV1(divisorSample1, immutableInputSample1);
        System.out.printf("Optimization V1 - " + output,
                resultSample1OptimizationV1, divisorSample1, immutableInputSample1);

        resultSample2OptimizationV1 = divisibleSumPairsOptimizationV1(divisorSample2, immutableInputSample2);
        System.out.printf("Optimization V1 - " + output,
                resultSample2OptimizationV1, divisorSample2, immutableInputSample2);

        resultSample3OptimizationV1 = divisibleSumPairsOptimizationV1(divisorSample3, immutableInputSample3);
        System.out.printf("Optimization V1 - " + output,
                resultSample3OptimizationV1, divisorSample3, immutableInputSample3);

    }
}

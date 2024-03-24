package br.com.aab.codechallenge.hackerrank.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true
 * Find the number that is multiple of the first array and factor of the second array
 * Solution provided by Nikhil Lohia in YT => https://youtu.be/-c_V4fQ2mKU?si=ThVbC2xuSAxa0geu
 */
public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0;
        int lcm = a.get(0);
        for (int number: a)
            lcm = getLCM(lcm, number);

        int gcd = b.get(0);
        for (int number: b)
            gcd = getGCD(gcd, number);

        int multiple = 0;
        while (multiple <= gcd) {
            multiple += lcm;
            if (gcd % multiple == 0)
                result++;
        }
        return result;
    }

    private static int getLCM(int number1, int number2) {
        if (number1 == 0 || number2 == 0)
            return 0;
        else {
            int gcd = getGCD(number1, number2);
            return Math.abs(number1 * number2) / gcd;
        }
    }

    private static int getGCD(int number1, int number2) {
        if (number2 == 0)
            return number1;
        return getGCD(number2, number1 % number2);
    }

    public static void main(String[] args) {
        var aExample1 = List.of(2, 6);
        var bExample1 = List.of(24, 36);
        var resultExample1 = getTotalX(aExample1, bExample1);
        System.out.printf("The result is [%d] for array a = %s and b = %s %n",
                resultExample1, aExample1, bExample1);
    }

    /**
     * Brute force version but incomplete because the dependency of
     * LCM (Least common multiple) and GCD (Greatest common divisor)
     * Be in mind about HCF - Highest Common factor
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        final int limit = b.get(b.size()-1);
        final Map<Integer, Set<Integer>> mapA = new HashMap<>();
        for (int i: a) {
            mapA.put(i, multiple(i, limit));
        }

        final Map<Integer, Set<Integer>> mapB  = new HashMap<>();
        for (int i: b) {
            mapB.put(i,  buildFactors(i));
        }

        return 0;
    }

    private static Set<Integer> multiple(int input, int limit) {
        Set<Integer> multiples = new HashSet<>();
        int count = 1;
        int dividend = 0;
        while (count < limit && dividend < limit) {
            dividend = input * count;
            multiples.add(dividend);
            count++;
        }
        return multiples;
    }

    private static Set<Integer> buildFactors(int compoundNumber) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i < compoundNumber; i++) {
            if (compoundNumber % i == 0)
                factors.add(i);
        }
        return factors;
    }
     */

}

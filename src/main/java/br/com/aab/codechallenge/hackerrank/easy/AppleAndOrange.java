package br.com.aab.codechallenge.hackerrank.easy;

import java.util.List;
import java.util.Objects;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem?isFullScreen=true
 */
class AppleAndOrange {

    public void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        if (Objects.isNull(apples) || apples.isEmpty() || Objects.isNull(oranges) || oranges.isEmpty()) return;
        if (s < 0 || t < s ) return;

        int countApples = 0;
        for (int apple: apples) {
            if ((a + apple) >= s && (a + apple) <= t) countApples++;
        }
        
        int countOranges = 0;
        for (int orange: oranges) {
            if ((b + orange) >= s && (b + orange) <= t) countOranges++;
        }
        
        System.out.printf("%d%n", countApples);
        System.out.printf("%d%n", countOranges);
    }

    public static void main(String[] args) {
        AppleAndOrange aao = new AppleAndOrange();
        int s0 = 7;
        int t0 = 10;
        int a0 = 4;
        int b0 = 12;
        var apples0 = List.of(2, 3, -4);
        var oranges0 = List.of(3, -2, -4);
        aao.countApplesAndOranges(s0, t0, a0, b0, apples0, oranges0);

        int s1 = 7;
        int t1 = 11;
        int a1 = 5;
        int b1 = 15;
        var apples1 = List.of(3, 2);
        var oranges1 = List.of(-2, 2, 1);
        aao.countApplesAndOranges(s1, t1, a1, b1, apples1, oranges1);

    }
}

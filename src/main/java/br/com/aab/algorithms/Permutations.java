package br.com.aab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    private static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String input = "abc";
        System.out.println("Permutation of [" + input + "]");
        permute(input).forEach(System.out::println);
    }

    public static List<String> permute(String input) {
        return permuteHelper("", input);
    }

    private static List<String> permuteHelper(String prefix, String remaining) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permuteHelper(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1, n));
            }
        }
        return result;
    }
}
package br.com.aab.javacodingproblems.s004;

public class CheckingOnlyDigits {
    public boolean onlyDigits(String input) {
        return input.chars().anyMatch(d -> Character.isDigit(d));
    }
}

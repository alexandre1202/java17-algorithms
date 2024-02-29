package br.com.aab.javacodingproblems.s004;

public class CheckingOnlyDigits {
    public boolean onlyDigits(String input) {
        return input.chars().anyMatch(Character::isDigit);
    }


    public static void main(String[] args) {
        // Defining the codepoint values
        // 57-> 9     95 -> _     9 -> TAB
        int a = 57, b = 95, c = 9;

        // Applying the isDigit() function
        System.out.println(a + ": a : " + Character.isDigit(a));
        System.out.println(b + ": b : " + Character.isDigit(b));
        System.out.println(c + ": c : " + Character.isDigit(c));
    }
}

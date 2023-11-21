package br.com.aab.algorithms;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("<<<<< Palindrome with Array >>>>>");
        System.out.println("dummy -> " + isPalindrome("dummy"));
        System.out.println("Natan -> " + isPalindrome("Natan"));
        System.out.println("I did did I -> " + isPalindrome("I did did I"));
        System.out.println("COVID19 -> " + isPalindrome("COVID19"));
        System.out.println("---------------------------------\n\n");

        System.out.println("<<<<< Palindrome with With StringBuffer >>>>>");
        System.out.println("dummy -> " + isPalindromeWithStringBuffer("dummy"));
        System.out.println("Natan -> " + isPalindromeWithStringBuffer("Natan"));
        System.out.println("I did did I -> " + isPalindromeWithStringBuffer("I did did I"));
        System.out.println("COVID19 -> " + isPalindromeWithStringBuffer("COVID19"));

        System.out.println("---------------------------------");

    }

    public static boolean isPalindromeWithStringBuffer(String str) {

        String input = str.toLowerCase();
        return input.equals(new StringBuffer(input).reverse().toString());
    }

    private static boolean isPalindrome(String palindrome) {
        char[] chars = palindrome.toLowerCase().toCharArray();
        int l = 0;
        int r = chars.length-1;
        while (r > l) {
            if (chars[r--] != chars[l++]) {
                return false;
            }
        }
        return true;
    }
}

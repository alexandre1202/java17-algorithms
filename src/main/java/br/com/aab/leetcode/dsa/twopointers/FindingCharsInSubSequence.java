package br.com.aab.leetcode.dsa.twopointers;

public class FindingCharsInSubSequence {
    private boolean found(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        FindingCharsInSubSequence find = new FindingCharsInSubSequence();

        String s = "ace";
        String t = "abcde";
        System.out.println("Finding if [" + s + "] is in the [" + t + "] by sequence :: result is " + find.found(s, t));

        s = "kmx";
        t = "alexandreabcdefghijklmnopqrstuvxz";
        System.out.println("Finding if [" + s + "] is in the [" + t + "] by sequence :: result is " + find.found(s, t));

        s = "mxk";
        t = "alexandreabcdefghijklmnopqrstuvxz";
        System.out.println("Finding if [" + s + "] is in the [" + t + "] by sequence :: result is " + find.found(s, t));

        s = "mxk";
        t = "";
        System.out.println("Finding if [" + s + "] is in the [" + t + "] by sequence :: result is " + find.found(s, t));

    }
}

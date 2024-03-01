package br.com.aab.codechallenge.hackerrank.easy;

public class StairCase {
    public void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%s%s%n", buildStr(n-i, " "), buildStr(i, "#"));
        }
    }

    private String buildStr(int n, String theChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(theChar);
        return sb.toString();
    }

    public static void main(String[] args) {
        StairCase stairCase = new StairCase();
        stairCase.staircase(4);
    }
}

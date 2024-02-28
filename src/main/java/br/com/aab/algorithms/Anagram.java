package br.com.aab.algorithms;

import java.util.Arrays;

public class Anagram {

    private boolean isAnagramWithSort(char[] s1, char[] s2) {
        if (s1.length != s2.length) return false;
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s1.length; i++)
            if (s1[i] != s2[i]) return false;

        return true;
    }

    private boolean isAnagramWithOutSort(char[] s1, char[] s2) {
        if (s1.length != s2.length) return false;
        int[] letterCount = new int[26];

        for (int i = 0; i < s1.length; i++) {
            letterCount[s1[i] - 'a']++;
            letterCount[s2[i] - 'a']--;
        }
        for (int i: letterCount) {
            if (i != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        char[] chars1 = "restful".toCharArray();
        char[] chars2 = "fluster".toCharArray();
        Anagram anagram = new Anagram();
        boolean resultAnagramWithSort = anagram.isAnagramWithSort(chars1, chars2);
        System.out.printf(
                "By sorting the array 1 %s and 2 %s are Anagram [%s]%n",
                Arrays.toString(chars1),
                Arrays.toString(chars2),
                resultAnagramWithSort);

        chars1 = "Alex".toCharArray();
        chars2 = "Aley".toCharArray();
        boolean resultAnagramWithOutSort = anagram.isAnagramWithOutSort(chars1, chars2);
        System.out.printf(
                "WithOut sorting the array 1 %s and 2 %s are Anagram [%s]%n",
                Arrays.toString(chars1),
                Arrays.toString(chars2),
                resultAnagramWithOutSort);

    }


}

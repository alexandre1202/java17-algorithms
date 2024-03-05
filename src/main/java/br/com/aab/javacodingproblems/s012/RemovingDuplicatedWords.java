package br.com.aab.javacodingproblems.s012;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemovingDuplicatedWords {
    public String removeDuplicatedFromString(String input) {
        return Arrays.stream(input.toLowerCase().split(" "))
                .distinct()
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String paragraph = "Bla bla is too much bla or is too much so";
        RemovingDuplicatedWords remover = new RemovingDuplicatedWords();
        System.out.printf("Removing duplicated words from [%s] the result is [%s]%n",
                paragraph, remover.removeDuplicatedFromString(paragraph));
    }
}

package br.com.aab.javacodingproblems.s012;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemovingDuplicatedCharacters {
    public String removeDuplicatedCharsV1(String input) {
        StringBuilder sbResult = new StringBuilder();
        Set<Character> inputSet = input.toLowerCase()
                .chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        for (char c: inputSet) {
            sbResult.append(c);
        }
        return sbResult.toString();
    }

    public String removeDuplicatedCharsV2(String input) {
        return input.toLowerCase()
                .chars().mapToObj(c -> (char)c).collect(Collectors.toSet())
                .stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String removeDuplicatedCharsV3(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String input = "aabcdeeeabbdh";
        RemovingDuplicatedCharacters remover = new RemovingDuplicatedCharacters();
        System.out.printf("V1 - Removing the duplicates values from this [%s] the result is [%s]%n",
                input, remover.removeDuplicatedCharsV1(input));

        System.out.printf("V2 - Removing the duplicates values from this [%s] the result is [%s]%n",
                input, remover.removeDuplicatedCharsV2(input));

        System.out.printf("V3 - Removing the duplicates values from this [%s] the result is [%s]%n",
                input, remover.removeDuplicatedCharsV3(input));
    }
}

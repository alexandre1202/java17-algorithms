package br.com.aab.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JoiningMultipleStrings {

    public String joinByDelimiter(char delimiter, String... words) {
        return Arrays.stream(words).collect(Collectors.joining(String.valueOf(delimiter)));
    }

}

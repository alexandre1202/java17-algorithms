package br.com.aab.lambdas.telusko;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface PrintConciseFormat {
    void print();
}

@FunctionalInterface
interface AddTwoValues {
    int add(int x, int y);
}

public class MyFIs {
    public static void main(String[] args) {
        PrintConciseFormat pcf = () -> System.out.printf("Printing ...\n");
        pcf.print();

        AddTwoValues addTwoValues = (x, y) -> x + y;
        System.out.printf("Soma de dois valores %d%n", addTwoValues.add(3, 5));

        Function<String, Integer> biFunction = s -> s.codePoints().boxed().collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new, Collectors.counting()
        )).entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
        var result = biFunction.apply("AAABBBCCCDEEEFFF");
        System.out.printf("Non repeated char is %s%n", (char)result.intValue());
    }
}

package br.com.aab.map.enummap;

import java.util.EnumMap;

public class EnumMapExample {
    enum MATH_OPERATIONS {
        SUM, SUBTRACT, MULTIPLE, DIVIDE, RESULT
    }

    public static void main(String[] args) {
        EnumMap<MATH_OPERATIONS, Character> mathOperations = new EnumMap<>(MATH_OPERATIONS.class){{
            put(MATH_OPERATIONS.SUM, '+');
            put(MATH_OPERATIONS.SUBTRACT, '-');
            put(MATH_OPERATIONS.MULTIPLE, '*');
            put(MATH_OPERATIONS.DIVIDE, '/');
            put(MATH_OPERATIONS.RESULT, '=');
        }};

        mathOperations.entrySet().forEach(entry -> System.out.printf("Math operation [%s] is done by [%s]%n",
                entry.getKey(), entry.getValue()));

        System.out.printf("Enum contain SQRT? [%s] %n", mathOperations.containsKey("SQRT"));
    }
}

package br.com.aab.algorithms;

public class NumberInverter {
    private int inverter(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int input = 123456789;
        NumberInverter inverter = new NumberInverter();
        int result = inverter.inverter(input);
        System.out.printf("The number [%d] is inverted equal [%d]", input, result);
    }
}

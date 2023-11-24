package br.com.aab.leetcode.dsa.arraysandstrings.slidingwindow;

public class FlippingTheBinaryString {
    public static void main(String[] args) {
        FlippingTheBinaryString exec = new FlippingTheBinaryString();

        String input = "1101100111";
        int result = exec.longestBinary(input);
        System.out.printf("The size of the biggest binary [%s] is [%d]%n", input, result);

        input = "11001011";
        result = exec.longestBinary(input);
        System.out.printf("The size of the biggest binary [%s] is [%d]%n", input, result);

        input = "100100100101";
        result = exec.longestBinary(input);
        System.out.printf("The size of the biggest binary [%s] is [%d]%n", input, result);
    }
    private int longestBinary(String input) {
        int left = 0;
        int current = 0;
        int result = 0;
        for (int right = 0; right < input.length(); right++) {
            if (input.charAt(right) == '0') current++;
            while (current > 1) {
                if (input.charAt(left) == '0') {
                    current--;
                }
                left++;
            }
            result = Math.max(result, right - left +1);
        }
        return result;
    }
}

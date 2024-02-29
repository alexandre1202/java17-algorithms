package br.com.aab.codechallenge.interview.deviget;

public class NextGreatestNumber {

    public static int findNextGreatestNumber(int number) {
        // Convert the number to a char array for easy manipulation
        char[] digits = String.valueOf(number).toCharArray();

        // Find the first digit that is smaller than the digit to its right
        int i;
        for (i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
        }

        // If no such digit is found, the number is the greatest possible
        if (i == -1) {
            return number;
        }

        // Find the smallest digit to the right of digits[i] and greater than digits[i]
        int j;
        for (j = digits.length - 1; j > i; j--) {
            if (digits[j] > digits[i]) {
                break;
            }
        }

        // Swap the digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Reverse the sub-array to the right of digits[i]
        reverse(digits, i + 1, digits.length - 1);

        // Convert the char array back to an integer
        return Integer.parseInt(new String(digits));
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int number = 12345;
        int nextGreatest = findNextGreatestNumber(number);
        System.out.println("Next greatest number: " + nextGreatest);
    }
}

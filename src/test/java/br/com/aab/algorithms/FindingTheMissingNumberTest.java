package br.com.aab.algorithms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FindingTheMissingNumberTest {

    private FindingTheMissingNumber findingTheMissingNumber = new FindingTheMissingNumber();

    @Test
    public void findByNumberFour() {
        int[] input = {1,2,3,5};
        int expected = 4;
        long result = findingTheMissingNumber.missingNumberV1(input);
        Assertions.assertThat(result == expected);
    }

    @Test
    public void findByNumberOne() {
        int[] input = {2};
        int expected = 1;
        long result = findingTheMissingNumber.missingNumberV1(input);
        Assertions.assertThat(result == expected);
    }

}
package br.com.aab.codechallenge.hackerrank.easy;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VeryBigSumTest {
    VeryBigSum veryBigSum = new VeryBigSum();

    @Test
    public void happyPathNaive() {
        var input = List.of(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        var result = veryBigSum.aVeryBigSum(input);
        Assertions.assertThat(result).isEqualTo(5000000015L);
    }

    @Test
    public void consumingAnEmptyListShouldReturnZero() {
        List<Long> input = Collections.emptyList();
        var result = veryBigSum.aVeryBigSum(input);
        Assertions.assertThat(result).isEqualTo(0L);
    }

    @Test
    public void consumingAnListWithPositiveAndNegativeValuesShouldReturnValidNumber() {
        var input = List.of(1000000001L, -1000000002L, -1000000003L, 1000000004L, 1000000005L);
        var result = veryBigSum.aVeryBigSum(input);
        Assertions.assertThat(result).isEqualTo(1000000005L);
    }

    @Test
    public void happyPathNaiveStream() {
        var input = List.of(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        var result = veryBigSum.aVeryBigSumWithStream(input);
        Assertions.assertThat(result).isEqualTo(5000000015L);
    }

    @Test
    public void consumingAnEmptyListShouldReturnZeroStream() {
        List<Long> input = Collections.emptyList();
        var result = veryBigSum.aVeryBigSumWithStream(input);
        Assertions.assertThat(result).isEqualTo(0L);
    }

    @Test
    public void consumingAnListWithPositiveAndNegativeValuesShouldReturnValidNumberStream() {
        var input = List.of(1000000001L, -1000000002L, -1000000003L, 1000000004L, 1000000005L);
        var result = veryBigSum.aVeryBigSumWithStream(input);
        Assertions.assertThat(result).isEqualTo(1000000005L);
    }
}

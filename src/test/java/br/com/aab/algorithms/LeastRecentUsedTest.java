package br.com.aab.algorithms;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LeastRecentUsedTest {
    private LeastRecentUsed lru = new LeastRecentUsed();
    private final int[] pages = new int[] {7,0,1,2,0,3,0,4,2,3,0,3,2};
    final int capacity = 4;
    List<Integer> expected = Arrays.asList(4,0,3,2);

    @Test
    public void testThirteenNumbersWithCapacityFourWithQueue() {
        List<Integer> cachedValues = lru.getCachedValuesVQueue(pages, capacity);
        Assertions.assertThat(cachedValues.equals(expected));
    }

    @Test
    public void testThirteenNumbersWithCapacityFourWithMap() {
        List<Integer> cachedValues = lru.getCachedValuesVMap(pages, capacity);
        Assertions.assertThat(cachedValues.equals(expected));
    }
}
package br.com.aab.streamapi;

import java.util.stream.IntStream;

public class MathStreamApi<T> {
    public Integer getAverage(int[] ints) {
        IntStream intStream = IntStream.of(ints);
        Double result = intStream.average().orElse(-1);
        return result.intValue();
    }
    
}

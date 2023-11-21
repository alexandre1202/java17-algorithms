package br.com.aab;

import java.util.stream.IntStream;

public class Douglas {
    public void getReduce() {
        var x = IntStream.rangeClosed(1,10).reduce(Integer::sum).getAsInt();
    }
}
package br.com.aab.streamapi.javacollectors;

import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.teeing;

public class JavaCollectorsTeeing {
    public static void main(String[] args) {
        record StringPair(String first, String second) {}
        var strings = Stream.of("a", "b", "c").collect(teeing(
                joining(":"),
                joining(","),
                StringPair::new
        ));
        System.out.printf("StringPair %s%n", strings);
    }
}

package br.com.aab.streamiterate;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStreamIterate {
    public static Set<String> calcSequenceStr(final int LIMIT) {
        return Stream.iterate(new String[] {"0", "1"}, s -> new String[]{s[1] + s[0], s[0]})
                .limit(LIMIT)
                .collect(Collectors.toList())
                .stream().map(f -> f[0])
                .collect(Collectors.toSet());
    }
}

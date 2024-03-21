package br.com.aab.codechallenge.interview.globant;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchWithExclusionsTest {
    SearchWithExclusions search = new SearchWithExclusions();

    @Test
    public void searches() {
        Set<Character> alphabetic = Set
                .of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z');
        Map<String, Set<Character>> expected = new HashMap<>() {{
            put("Mickey", Set.of('e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z'));
            put("Minnie", Set.of('a', 'c', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z'));
            put("Disney", Set.of('a', 'b', 'c', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z'));
            put("Donald", alphabetic);
            put("", alphabetic);
        }};

        var inputs = List.of("Mickey", "Minnie", "Disney", "Donald", "");
        inputs.forEach(i -> {
            List<String> resultForEach = search.search(i);
            List<String> expectedEvaluated = expected
                    .getOrDefault(String.valueOf(i), Collections.emptySet())
                    .stream().map(Object::toString).toList();

            Assertions.assertThat(resultForEach).containsExactlyInAnyOrder(expectedEvaluated.toArray(new String[expected.size()]));
        });

    }
}

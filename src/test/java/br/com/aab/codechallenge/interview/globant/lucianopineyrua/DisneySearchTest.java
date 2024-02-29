package br.com.aab.codechallenge.interview.globant.lucianopineyrua;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DisneySearchTest {

    DisneySearch disneySearch = new DisneySearch();
    private Set<Character> alphabetic = Set
            .of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private Map<String, Set<Character>> expected = new HashMap<>() {{
        put("Mickey", Set.of('e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        put("Minnie", Set.of('a', 'c', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        put("Disney", Set.of('a', 'b', 'c', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'z'));
        put("Donald", alphabetic);
        put("", alphabetic);
    }};

    @Test
    public void searchForListOfValidOrInvalidValuesAndReturn() {
        var inputs = List.of("Mickey", "Minnie", "Disney", "Donald", "");
        inputs.forEach(i -> {
            List<String> resultForEach = disneySearch.search(i);
            List<String> expected = this.expected
                    .getOrDefault(String.valueOf(i), Collections.emptySet())
                    .stream().map(Object::toString).toList();

            Assertions.assertThat(resultForEach).containsExactlyInAnyOrder(expected.toArray(new String[expected.size()]));
        });
    }

}

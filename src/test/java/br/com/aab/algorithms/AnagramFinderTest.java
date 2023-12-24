package br.com.aab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AnagramFinderTest {
    private AnagramFinder anagramFinder = new AnagramFinder();

    @Test
    public void testingAnagramFinder() {
        String[] input = {"listen", "integral", "enlist", "inlets","inlets", "silent", "earth", "apple", "heart", "earth", "cinema", "iceman", "triangle"};
        List<List<String>> expected = new ArrayList<>() {{
            add(Arrays.asList("earth", "heart"));
            add(Arrays.asList("listen", "enlist", "inlets", "silent"));
            add(Arrays.asList("integral", "triangle"));
            add(Arrays.asList("apple"));
            add(Arrays.asList("iceman", "cinema"));
        }};
        var result = anagramFinder.findAnagrams(input);
        result.forEach(System.out::println);
        for (List<String> expectedGroup : expected) {
            Assertions.assertThat(result)
                    .anySatisfy(anagramGroup -> Assertions
                            .assertThat(anagramGroup).containsExactlyInAnyOrder(expectedGroup.toArray(new String[0])));
        }
    }
}
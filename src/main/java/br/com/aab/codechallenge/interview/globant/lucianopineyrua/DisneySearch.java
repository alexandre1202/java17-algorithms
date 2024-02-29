package br.com.aab.codechallenge.interview.globant.lucianopineyrua;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implement a search method that excludes a given data from a fixed list of
 * alphabetic letters [a, b, c, ... z]
 * i.e.
 * if the query is "Mickey" you are expected to exclude [a, b, c, d] from the result
 * if the query is "Minnie" you are expected to exclude [d, e, b] from the result
 * if the query is "Disney" you are expected to exclude [d, e, y] from the result
 * Otherwise the result is a full list of the
 */
public class DisneySearch {
//    private String alphas = "abcdefghijklmnopqrstuvxz";
//    private Set<Character> aabApproach = alphas.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
    private Set<Character> alphabetic = Set
            .of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private Map<String, Set<Character>> exclusionsMap = new HashMap<>() {{
        put("Mickey", Set.of('a', 'b', 'c', 'd'));
        put("Minnie", Set.of('d','e', 'b'));
        put("Disney", Set.of('d','e', 'y'));
    }};
    public List<String> search(String query) {
        /**
         * This first approach works
         */
//        var exclusionsFound = exclusionsMap.get(query);
//        if (Objects.isNull(exclusionsFound)) {
//            return alphabetic.stream().map(Object::toString).collect(Collectors.toList());
//        } else {
//            List<String> result = new ArrayList<>();
//            for (char c: alphabetic) {
//                if (! exclusionsFound.contains(c)) {
//                    result.add(String.valueOf(c));
//                }
//            }
//            return result;
//        }

        /**
         * This is more concise and another possibility
         */
        if (Objects.isNull(query) || query.isEmpty())
            return alphabetic.stream().map(Object::toString).collect(Collectors.toList());

        Set<Character> exclusionsFound = exclusionsMap.getOrDefault(query, Collections.emptySet());
        return alphabetic.stream()
                .filter(c -> !exclusionsFound.contains(c))
                .map(Objects::toString)
                .collect(Collectors.toList());
    }
}

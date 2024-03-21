package br.com.aab.codechallenge.interview.globant;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchWithExclusions {

    private final String alphabet = "abcdefghijklmnopqrstuvxz";
    private final Map<String, Set<Character>> exclusions = new HashMap<>() {{
        put("Mickey", Set.of('a', 'b', 'c', 'd'));
        put("Minnie", Set.of('d','e', 'b'));
        put("Disney", Set.of('d','e', 'y'));
    }};
    private final Set<Character> alphabeticSet = alphabet
        .chars().mapToObj(c -> (char)c)
        .collect(Collectors.toSet());
        
    public List<String> search(String query) {
        if (Objects.isNull(query) || query.length() < 2)
            return alphabeticSet.stream().map(Object::toString).collect(Collectors.toList());

        Set<Character> exclusionsFound = exclusions.getOrDefault(query, Collections.emptySet());
        return alphabeticSet.stream()
                .filter(c -> ! exclusionsFound.contains(c))
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}

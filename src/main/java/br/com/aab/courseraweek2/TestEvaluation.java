package br.com.aab.courseraweek2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestEvaluation {
    private static Evaluation evaluateGuess(String secret, String guess) {
        var map = new HashMap<Character, Set<Integer>>();
        var secretAr = secret.toCharArray();
        var guessAr = guess.toCharArray();

        for (int i = 0; i < secretAr.length; i++) {
            var c = secretAr[i];
            var count = map.get(c);
            if (Objects.nonNull(count)) {
                count.add(i);
                continue;
            }
            int finalI = i;
            map.put(c, new HashSet<>(){{
                add(finalI);
            }});
        }

        var rightPosition = 0;
        var wrongPosition = 0;

        for (int i = 0; i < guessAr.length; i++) {
            var c = guessAr[i];
            var foundGuess = map.get(c);
            if (Objects.nonNull(foundGuess)) {
                if(foundGuess.isEmpty()) continue;
                if (foundGuess.contains(i)) {
                    rightPosition++;
                } else {
                    wrongPosition++;
                }
                foundGuess.remove(i);
            }
        }

        return new Evaluation(rightPosition, wrongPosition);
    }


}

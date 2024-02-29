package br.com.aab.codechallenge.interview.agileengine;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class VisitCounter {

    public Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null && visits.length == 0) return Collections.emptyMap();

        return Arrays.stream(visits)
                .filter(this::isValidMap)
                .flatMap(map -> map.entrySet().stream())
                .filter(entry -> isValidUserStats(entry.getValue()))
                .collect(Collectors.groupingBy(
                        entry -> convertToLong(entry.getKey()).orElse(-1L),
                        Collectors.counting()
                ));
    }

    private boolean isValidMap(Map<String, UserStats> map) {
        return map != null && !map.isEmpty();
    }

    private boolean isValidUserStats(UserStats userStats) {
        return userStats != null && userStats.getVisitCount().isPresent();
    }
    private Optional<Long> convertToLong(String s) {
        try {
            return Optional.of(Long.parseLong(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    static private class UserStats {
        public Optional<Long> visitCount;

        public UserStats(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }
    }

    public static void main(String[] args) {
        VisitCounter visitCounter = new VisitCounter();
        Map<String, UserStats> input1 = new HashMap<>(){{
            put("1", new UserStats(Optional.of(100L)));
            put("2", new UserStats(Optional.of(200L)));
            put("3", new UserStats(Optional.of(300L)));
            put("4", new UserStats(Optional.of(400L)));
            put("5", new UserStats(Optional.of(500L)));
            put("6", new UserStats(Optional.of(600L)));
            put("7", new UserStats(Optional.of(700L)));
            put("8", new UserStats(Optional.of(800L)));
        }};
        Map<String, UserStats> input2 = new HashMap<>(){{
            put("1", new UserStats(Optional.of(100L)));
            put("2", new UserStats(Optional.of(200L)));
            put("3", new UserStats(Optional.of(300L)));
            put("7", new UserStats(Optional.of(400L)));
            put("8", new UserStats(Optional.of(600L)));
            put("9", new UserStats(Optional.of(600L)));
        }};

        Map<Long, Long> count = visitCounter.count(input1, input2);
        count.entrySet().stream().forEach(System.out::println);
    }
}

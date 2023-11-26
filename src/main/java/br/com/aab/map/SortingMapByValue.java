package br.com.aab.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortingMapByValue {
    private final static Map<String, Integer> countryRankings = new HashMap<>() {{
        put("England", 3);
        put("USA", 1);
        put("China", 2);
        put("Russia", 4);
        put("Brazil", 8);
        put("Canada", 5);
    }};

    private <K extends Comparable<K>, V extends Comparable<V>> Map<K,V> sortingByValue(Map<K, V> inputMap) {
        List<Map.Entry<K,V>> listOfMap = new LinkedList<>(inputMap.entrySet());
        Collections.sort(listOfMap, Map.Entry.comparingByValue());
        Map<K,V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K,V> entry : listOfMap) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        SortingMapByValue sortingMap = new SortingMapByValue();

        System.out.println("Unordered Rank of countries");
        countryRankings.entrySet().forEach(entry -> System.out.printf("Key [%s] and Value [%d]%n", entry.getKey(), entry.getValue()));

        Map<String, Integer> sortedMap = sortingMap.sortingByValue(countryRankings);
        System.out.printf("%nSorted Map of the countries by Value %n");
        sortedMap.entrySet().forEach(entry -> System.out.printf("Key [%s] and Value [%d]%n", entry.getKey(), entry.getValue()));
    }
}

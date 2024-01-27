package br.com.aab.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeastRecentUsed {
    public List<Integer> getCachedValuesVMap(int[] pages, final int capacity) {
        final Map<Integer, Integer> cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        Arrays.stream(pages).forEach(i -> cache.put(i, 0));
        return new ArrayList<>(cache.keySet());
    }
}



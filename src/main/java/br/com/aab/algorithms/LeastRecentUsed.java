package br.com.aab.algorithms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LeastRecentUsed {

    public List<Integer> getCachedValuesVQueue(int[] pages, final int capacity) {
        Queue<Integer> cache = new LinkedList<>();
        for (int i = 0; i < pages.length; i++) {
            if (cache.size() <= capacity) {
                cache.add(pages[i]);
            } else {
                if (cache.contains(pages[i])) {
                    cache.remove(pages[i]);
                } else {
                    cache.poll();
                }
            }
        }
        return new ArrayList<>(cache);
    }

    public List<Integer> getCachedValuesVMap(int[] pages, final int capacity) {
        Map<Integer, Integer> cache = new LinkedHashMap<>(capacity, 0.75f, true);
        for (int page: pages) {
            cache.put(page, 0);
        }
        return new ArrayList<>(cache.keySet());
    }
}



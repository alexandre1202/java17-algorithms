package br.com.aab.mixedsubjects;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyHash {
    public static void main(String[] args) {
        var capacity = 5;
        Map<Integer, Integer> hashMap = new ConcurrentHashMap<>() {{
            put(1, 10);
            put(2, 20);
            put(3, 30);
        }};
        hashMap.put(2, 200);

        hashMap.entrySet().stream().forEach(System.out::println);
    }
}

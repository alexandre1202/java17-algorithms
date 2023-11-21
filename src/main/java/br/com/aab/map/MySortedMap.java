package br.com.aab.map;

import java.util.Map;
import java.util.TreeMap;

public class MySortedMap {
    public static void buildMap() {
        Map<String, String> students = new TreeMap<>(){{
            put("John", "SC");
            put("Gaby", "RJ");
            put("Zillow", "SP");
            put("Alex", "RJ");
            put("Mike", "BA");
        }};

        students.forEach((k,v) -> System.out.println("key " + k + " value " + v));
    }

    public static void main(String[] args) {
        buildMap();
    }
}

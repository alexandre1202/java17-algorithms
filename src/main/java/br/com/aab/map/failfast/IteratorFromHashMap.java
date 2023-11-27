package br.com.aab.map.failfast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorFromHashMap {
    /**
     * In Java, the iterator returned by HashMap is fail-fast. This means that if the underlying collection
     * is modified after the iterator is created, the iterator will throw a ConcurrentModificationException
     * to indicate that the collection has been concurrently modified.
     * But this behavior occurs only when we add or remove data, I mean, changing the structure.
     * The exception does not occur when we change the value of existent data.
     */

    private static final Map<String, String> students = new HashMap<>(){{
        put("John", "SC");
        put("Gaby", "RJ");
        put("Zillow", "SP");
        put("Alex", "RJ");
        put("Mike", "BA");
    }};

    private static void triggerConcurrentModificationException() {
        Iterator<Map.Entry<String, String>> iteratorStudents = students.entrySet().iterator();
        try {
            while (iteratorStudents.hasNext()) {
                Map.Entry<String, String> studentsEntry = iteratorStudents.next();
                System.out.println(studentsEntry.getKey() + ": " + studentsEntry.getValue());

                if ("John".equals(studentsEntry.getKey())) {
                    System.out.printf("Vai lançar a exception!!! %n");
                    students.put("Stanley", "MT");
                }
            }
        } catch (Exception e) {
            System.out.printf("Exception bizzara due to fail-fast iterator %s%n", e);
        }
    }

    public static void main(String[] args) {
        triggerConcurrentModificationException();
    }
}

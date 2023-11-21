package br.com.aab.streammap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStreamMap {

    public static final List<Student> students = new LinkedList<>() {{
        add(new Student("Alice", 20, "123 Main St"));
        add(new Student("Bob", 22, "456 Elm St"));
        add(new Student("Charlie", 21, "789 Oak St"));
        add(new Student("David", 19, "567 Pine St"));
        add(new Student("Eve", 23, "101 Maple St"));
        add(new Student("Frank", 24, "222 Cedar St"));
        add(new Student("Grace", 18, "333 Birch St"));
        add(new Student("Helen", 25, "444 Willow St"));
        add(new Student("Ivy", 22, "555 Redwood St"));
        add(new Student("Jack", 20, "666 Sequoia St"));
        add(new Student("Bob", 21, "789 Oak St"));
        add(new Student("Michal", 19, "567 Pine St"));
        add(new Student("John", 23, "101 Maple St"));
    }};

    public static void mapListToObject() {
        System.out.println("Printing students address");
        students.stream().map(Student::address).collect(Collectors.toList())
                .forEach(System.out::println);

        Map<Integer, Long> groupedByAge = students
                .stream()
                .collect(Collectors.groupingBy(Student::age, Collectors.counting()));
        System.out.println("Counting students by age");
        groupedByAge.forEach((k,v) -> System.out.println("Age = " + k + " Count = " + v));
    }

    public static void main (String[]args){
        mapListToObject();
    }

    record Student(String name , int age, String address){}
}
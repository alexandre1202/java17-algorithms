package br.com.aab.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class MyQueues {

    public static void buildArrayQueue() {

        Queue<String> queues = new ArrayDeque<>() {{
            add("John");
            add("Gaby");
            add("Alex");
            add("Mike");
        }};
        queues.forEach(System.out::println);
        System.out.println("===============================");
        queues.remove();
        queues.forEach(System.out::println);
    }

    public static void main(String[] args) {
        buildArrayQueue();
    }
}

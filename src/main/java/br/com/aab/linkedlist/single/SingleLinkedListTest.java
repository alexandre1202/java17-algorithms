package br.com.aab.linkedlist.single;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList<UUID> uuidLinkedList = new SingleLinkedList<>();
        int limit = 10;
        List<UUID> uuids = Stream.iterate(UUID.randomUUID(), uuid -> UUID.randomUUID()).limit(limit).toList();
        uuids.forEach(uuid -> uuidLinkedList.insert(uuid));
        uuidLinkedList.traverseList();
    }
}

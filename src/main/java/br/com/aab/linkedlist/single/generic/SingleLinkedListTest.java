package br.com.aab.linkedlist.single.generic;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList<UUID> uuidLinkedList = new SingleLinkedList<>();
        int limit = 10;
        List<UUID> uuids = Stream.iterate(UUID.randomUUID(), uuid -> UUID.randomUUID()).limit(limit).toList();
        uuids.forEach(uuid -> uuidLinkedList.insert(uuid));
        uuidLinkedList.traverseList();
        System.out.printf("Single LinkedList size [%d]%n%n", uuidLinkedList.getSize());

        UUID itemRemoved = uuids.get(2);
        uuidLinkedList.remove(itemRemoved);
        System.out.printf("Single LinkedList after the item [%s] was removed]%n", itemRemoved);
        uuidLinkedList.traverseList();
    }
}

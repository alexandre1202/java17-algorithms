package br.com.aab.linkedlist.single.generic;

import java.util.Objects;
import lombok.Getter;

@Getter
public class SingleLinkedList <T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private int size;

    @Override
    public void insert(T data) {
        if (Objects.isNull(data)) return;
        if (Objects.isNull(this.head)) {
            this.head = new Node<>(data);
        } else {
            insertInTheBeginning(data);
        }
        this.size++;
    }

    private void insertInTheBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    @Override
    public void remove(T data) {
        if (this.head.getData().compareTo(data) == 0) {
            this.head = this.head.getNextNode();
        } else {
            Node<T> actualNode = this.head.getNextNode();
            Node<T> previousNode = this.head;
            while (Objects.nonNull(actualNode)) {
                if (actualNode.getData().compareTo(data) == 0) {
                    previousNode.setNextNode(actualNode.getNextNode());
                    actualNode = null;
                    return;
                }
                previousNode = actualNode;
                actualNode = actualNode.getNextNode();
            }
        }
        this.size--;
    }

    @Override
    public void traverseList() {
        Node<T> currentNode = this.head;
        while (Objects.nonNull(currentNode)) {
            System.out.printf("%s%n", currentNode);
            currentNode = currentNode.getNextNode();
        }
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Node<T> getMiddle() {
        return null;
    }
}

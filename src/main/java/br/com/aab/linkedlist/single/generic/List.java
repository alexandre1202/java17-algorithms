package br.com.aab.linkedlist.single.generic;

public interface List <T extends Comparable<T>> {
    void insert(T data);
    void remove(T data);
    void traverseList();
    Node<T> getMiddle();
}

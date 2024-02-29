package br.com.aab.codechallenge.interview.globant.lucianopineyrua;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TriePrefixDisneySearch {

    private TrieNode root;

    public TriePrefixDisneySearch(Set<String> dictionary) {
        this.root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean isValidPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    private static class TrieNode {
        private boolean isEndOfWord;
        private Map<Character, TrieNode> children;

        public TrieNode() {
            this.isEndOfWord = false;
            this.children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Set<String> dictionary = Set.of("hello", "hall", "holy");
        TriePrefixDisneySearch triePrefixDisneySearch = new TriePrefixDisneySearch(dictionary);
        System.out.println(triePrefixDisneySearch.isValidPrefix("hel")); // Output: true
        System.out.println(triePrefixDisneySearch.isValidPrefix("hal")); // Output: true
        System.out.println(triePrefixDisneySearch.isValidPrefix("xyz")); // Output: false
    }
}

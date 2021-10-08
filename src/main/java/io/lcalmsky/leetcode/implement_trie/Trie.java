package io.lcalmsky.leetcode.implement_trie;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (current.children[position] == null) {
                current.children[position] = new TrieNode();
            }
            current = current.children[position];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = find(word);
        return current != null && current.isWord;
    }

    private TrieNode find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int position = word.charAt(i) - 'a';
            if (current.children[position] == null) {
                return null;
            }
            current = current.children[position];
        }
        return current;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
}
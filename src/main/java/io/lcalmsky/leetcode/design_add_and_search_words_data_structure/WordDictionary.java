package io.lcalmsky.leetcode.design_add_and_search_words_data_structure;

import java.util.LinkedList;
import java.util.List;

public class WordDictionary {

  private final TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        node.children[index] = new TrieNode();
      }
      node = node.children[index];
    }
    node.word = word;
  }

  public boolean search(String word) {
    return match(word.toCharArray(), 0, root);
  }

  private boolean match(char[] charArray, int index, TrieNode node) {
    if (index == charArray.length) {
      return node.word != null;
    }
    if (charArray[index] != '.') {
      int i = charArray[index] - 'a';
      return node.children[i] != null && match(charArray, index + 1, node.children[i]);
    }
    for (int i = 0; i < node.children.length; i++) {
      if (node.children[i] != null) {
        if (match(charArray, index + 1, node.children[i])) {
          return true;
        }
      }
    }
    return false;
  }


  public static class TrieNode {

    TrieNode[] children;
    String word;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }
}

class WordDictionary2 {

  private final List<String>[] list;

  public WordDictionary2() {
    //noinspection unchecked
    list = new LinkedList[501];
    for (int i = 0; i < list.length; i++) {
      list[i] = new LinkedList<>();
    }
  }

  public void addWord(String word) {
    List<String> words = list[word.length()];
    words.add(word);
  }

  public boolean search(String word) {
    List<String> words = list[word.length()];
    for (String currentWord : words) {
      if (compare(currentWord, word)) {
        return true;
      }
    }
    return false;
  }

  private boolean compare(String source, String pattern) {
    for (int i = 0; i < source.length(); i++) {
      char letter = pattern.charAt(i);
      if (letter == '.') {
        continue;
      }
      if (source.charAt(i) != letter) {
        return false;
      }
    }
    return true;
  }
}
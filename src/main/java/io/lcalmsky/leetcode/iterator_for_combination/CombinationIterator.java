package io.lcalmsky.leetcode.iterator_for_combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationIterator {

  private final int combinationLength;
  private final List<String> words;
  private int currentIndex;

  public CombinationIterator(String characters, int combinationLength) {
    this.combinationLength = combinationLength;
    boolean[] visited = new boolean[characters.length()];
    this.words = new ArrayList<>();
    this.currentIndex = 0;
    generateWords(characters, 0, new StringBuilder(), visited);
  }

  private void generateWords(String characters, int startIndex, StringBuilder stringBuilder,
      boolean[] visited) {
    if (stringBuilder.length() == combinationLength) {
      words.add(stringBuilder.toString());
      return;
    }
    while (startIndex < characters.length()) {
      if (visited[startIndex]) {
        startIndex++;
        continue;
      }
      visited[startIndex] = true;
      stringBuilder.append(characters.charAt(startIndex));
      generateWords(characters, startIndex++, stringBuilder, visited);
      visited[startIndex - 1] = false;
      stringBuilder.setLength(stringBuilder.length() - 1);
    }
  }

  public String next() {
    return words.get(currentIndex++);
  }

  public boolean hasNext() {
    return currentIndex < words.size();
  }
}

class CombinationIterator2 {

  private final List<String> words = new ArrayList<>();
  private int currentIndex = 0;

  public CombinationIterator2(String characters, int combinationLength) {
    char[] chs = characters.toCharArray();
    Arrays.sort(chs);
    dfs(chs, new StringBuilder(), 0, combinationLength);
  }

  public String next() {
    return words.get(currentIndex++);
  }

  public boolean hasNext() {
    return currentIndex < words.size();
  }

  public void dfs(char[] characters, StringBuilder stringBuilder, int start, int length) {
    if (stringBuilder.length() == length) {
      words.add(stringBuilder.toString());
      return;
    }
    if (start >= characters.length) {
      return;
    }
    dfs(characters, stringBuilder.append(characters[start]), start + 1, length);
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    dfs(characters, stringBuilder, start + 1, length);
  }
}
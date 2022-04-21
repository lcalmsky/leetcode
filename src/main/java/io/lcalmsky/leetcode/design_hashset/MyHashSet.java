package io.lcalmsky.leetcode.design_hashset;

public class MyHashSet {

  private final boolean[] elements;

  public MyHashSet() {
    elements = new boolean[1000001];
  }

  public void add(int key) {
    elements[key] = true;
  }

  public void remove(int key) {
    elements[key] = false;
  }

  public boolean contains(int key) {
    return elements[key];
  }
}

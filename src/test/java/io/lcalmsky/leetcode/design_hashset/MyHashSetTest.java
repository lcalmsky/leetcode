package io.lcalmsky.leetcode.design_hashset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyHashSetTest {

  @Test
  void test() {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);
    myHashSet.add(2);
    assertTrue(myHashSet.contains(1));
    assertFalse(myHashSet.contains(3));
    myHashSet.add(2);
    assertTrue(myHashSet.contains(2));
    myHashSet.remove(2);
    assertFalse(myHashSet.contains(2));
  }
}
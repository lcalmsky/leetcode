package io.lcalmsky.leetcode.iterator_for_combination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CombinationIteratorTest {

  @Test
  void test() {
    CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
    assertEquals("ab", combinationIterator.next());
    assertTrue(combinationIterator.hasNext());
    assertEquals("ac", combinationIterator.next());
    assertTrue(combinationIterator.hasNext());
    assertEquals("bc", combinationIterator.next());
    assertFalse(combinationIterator.hasNext());
  }
}
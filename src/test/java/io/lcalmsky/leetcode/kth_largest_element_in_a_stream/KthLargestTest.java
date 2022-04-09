package io.lcalmsky.leetcode.kth_largest_element_in_a_stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KthLargestTest {

  @Test
  void test() {
    KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
    assertEquals(4, kthLargest.add(3));
    assertEquals(5, kthLargest.add(5));
    assertEquals(5, kthLargest.add(10));
    assertEquals(8, kthLargest.add(9));
    assertEquals(8, kthLargest.add(4));
  }
}
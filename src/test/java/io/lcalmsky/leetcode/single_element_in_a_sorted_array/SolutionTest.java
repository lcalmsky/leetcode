package io.lcalmsky.leetcode.single_element_in_a_sorted_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSortedArray_whenFindSingleElement_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, 2),
        () -> test(new int[]{3, 3, 7, 7, 10, 11, 11}, 10)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution singleElementInASortedArray = new Solution();
    int actual = singleElementInASortedArray.singleNonDuplicate(given);

    // then
    assertEquals(expected, actual);
  }
}
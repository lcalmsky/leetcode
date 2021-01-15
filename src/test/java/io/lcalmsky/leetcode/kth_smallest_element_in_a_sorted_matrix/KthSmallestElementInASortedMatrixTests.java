package io.lcalmsky.leetcode.kth_smallest_element_in_a_sorted_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementInASortedMatrixTests {
    @Test
    public void givenSortedMatrix_whenFindKthSmallestElement_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8, 13)
        );
    }

    private void test(int[][] given, int k, int expected) {
        // when
        Solution kthSmallestElementInASortedMatrix = new Solution();
        int actual = kthSmallestElementInASortedMatrix.kthSmallest(given, k);

        // then
        assertEquals(expected, actual);
    }
}

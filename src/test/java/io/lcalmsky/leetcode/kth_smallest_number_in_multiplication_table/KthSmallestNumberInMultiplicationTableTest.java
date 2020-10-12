package io.lcalmsky.leetcode.kth_smallest_number_in_multiplication_table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestNumberInMultiplicationTableTest {
    @Test
    public void givenHeightAndLengthOfMultiplicationTable_whenFindKthSmallestNumber_thenCorrect() {
        assertAll(
                () -> test(3, 3, 5, 3),
                () -> test(2, 3, 6, 6)
        );
    }

    private void test(int m, int n, int k, int expected) {
        // when
        KthSmallestNumberInMultiplicationTable kthSmallestNumberInMultiplicationTable = new KthSmallestNumberInMultiplicationTable();
        int actual = kthSmallestNumberInMultiplicationTable.findKthNumber(m, n, k);

        // then
        assertEquals(expected, actual);
    }
}
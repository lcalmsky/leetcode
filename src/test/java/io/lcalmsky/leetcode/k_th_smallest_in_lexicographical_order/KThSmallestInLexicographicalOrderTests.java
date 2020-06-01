package io.lcalmsky.leetcode.k_th_smallest_in_lexicographical_order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KThSmallestInLexicographicalOrderTests {
    @Test
    public void givenIntegers_whenFindKThSmallestInLexicographicOrder_thenCorrect() {
        assertAll(
                () -> test(13, 2, 10)
        );
    }

    private void test(int n, int k, int expected) {
        // when
        KThSmallestInLexicographicalOrder kThSmallestInLexicographicalOrder = new KThSmallestInLexicographicalOrder();
        int actual = kThSmallestInLexicographicalOrder.findKthNumber(n, k);

        // then
        assertEquals(expected, actual);
    }
}

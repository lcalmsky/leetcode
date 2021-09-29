package io.lcalmsky.leetcode.sort_array_by_parity_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void givenArray_whenSortByParity_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 2, 5, 7}, new int[]{4, 5, 2, 7}),
                () -> test(new int[]{2, 3}, new int[]{2, 3})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.sortArrayByParityII(given);

        // then
        for (int i = 0; i < actual.length; i++) {
            assertTrue((i & 1) == 0 ?
                    (actual[i] & 1) == 0 :
                    (actual[i] & 1) == 1);
        }
    }
}
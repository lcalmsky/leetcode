package io.lcalmsky.leetcode.remove_boxes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveBoxesTests {
    @Test
    public void givenNumbers_whenRemoveAndGetPoints_thenFindMaximumPoints() {
        assertAll(
                () -> test(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}, 23)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution removeBoxes = new Solution();
        int actual = removeBoxes.removeBoxes(given);

        // then
        assertEquals(expected, actual);
    }
}

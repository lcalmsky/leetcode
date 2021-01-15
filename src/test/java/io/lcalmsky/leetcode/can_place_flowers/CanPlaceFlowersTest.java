package io.lcalmsky.leetcode.can_place_flowers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {
    @Test
    public void givenFlowerbedAndNumberOfNewFlowers_whenPlaceNewFlowerWithoutAdjacent_thenCorrect() {
        // then
        assertAll(
                () -> assertTrue(test(new int[]{1, 0, 0, 0, 1}, 1)),
                () -> assertFalse(test(new int[]{1, 0, 0, 0, 1}, 2))
        );
    }

    private boolean test(int[] given, int n) {
        // when
        Solution canPlaceFlowers = new Solution();
        return canPlaceFlowers.canPlaceFlowers(given, n);
    }
}

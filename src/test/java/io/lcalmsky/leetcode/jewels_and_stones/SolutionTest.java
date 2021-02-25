package io.lcalmsky.leetcode.jewels_and_stones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenJewelsAndStones_whenFindJewelsInStones_thenCorrect() {
        assertAll(
                () -> test("aA", "aAAbbbb", 3),
                () -> test("z", "ZZ", 0)
        );
    }

    private void test(String jewels, String stones, int expected) {
        // when
        Solution2 solution = new Solution2();
        int actual = solution.numJewelsInStones(jewels, stones);

        // then
        assertEquals(expected, actual);
    }
}

package io.lcalmsky.leetcode.shortest_distance_to_a_character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void givenStringAndCharacter_whenGetDistanceArray_thenCorrect() {
        assertAll(
                () -> test("loveleetcode", 'e', new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}),
                () -> test("aaab", 'b', new int[]{3, 2, 1, 0})
        );
    }

    private void test(String s, char c, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.shortestToChar(s, c);

        // then
        assertArrayEquals(expected, actual);
    }
}

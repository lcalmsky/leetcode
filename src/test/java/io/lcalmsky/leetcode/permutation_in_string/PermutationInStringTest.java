package io.lcalmsky.leetcode.permutation_in_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationInStringTest {
    @Test
    public void givenString_whenFindPermutation_thenCorrect() {
        assertAll(
                () -> test("ab", "eidbaooo", true),
                () -> test("ab", "eidboaoo", false)
        );
    }

    private void test(String s1, String s2, boolean expected) {
        // when
        Solution permutationInString = new Solution();
        boolean actual = permutationInString.checkInclusion(s1, s2);

        // then
        assertEquals(expected, actual);
    }

}

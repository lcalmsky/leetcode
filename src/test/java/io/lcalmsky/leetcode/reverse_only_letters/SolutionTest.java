package io.lcalmsky.leetcode.reverse_only_letters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenLetters_whenReverseOnlyLetters_thenCorrect() {
        assertAll(
                () -> test("ab-cd", "dc-ba"),
                () -> test("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
                () -> test("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.reverseOnlyLetters(given);

        // then
        assertEquals(expected, actual);
    }
}
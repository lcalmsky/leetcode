package io.lcalmsky.leetcode.detect_capital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectCapitalTests {
    @Test
    public void givenWord_whenCheckItConsistsOnlyCapital_thenCorrect() {
        assertAll(
                () -> test("USA", true),
                () -> test("FlaG", false)
        );
    }

    private void test(String given, boolean expected) {
        // when
        Solution detectCapital = new Solution();
        boolean actual = detectCapital.detectCapitalUse(given);

        // then
        assertEquals(expected, actual);
    }
}

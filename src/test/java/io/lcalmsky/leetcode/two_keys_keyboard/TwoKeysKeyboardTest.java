package io.lcalmsky.leetcode.two_keys_keyboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoKeysKeyboardTest {
    @Test
    public void givenNumber_whenFindMinStep_thenCorrect() {
        assertAll(
                () -> test(3, 3)
        );
    }

    private void test(int given, int expected) {
        // when
        TwoKeysKeyboard twoKeysKeyboard = new TwoKeysKeyboard();
        int actual = twoKeysKeyboard.minSteps(given);

        // then
        assertEquals(expected, actual);
    }
}
package io.lcalmsky.leetcode.happy_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HappyNumberTests {
    @Test
    public void givenNumber_whenCheckWhetherNumberIsHappy_thenCorrect() {
        assertAll(
                () -> test(19, true)
        );
    }

    private void test(int given, boolean expected) {
        // when
        Solution happyNumber = new Solution();
        boolean actual = happyNumber.isHappy(given);

        // then
        assertEquals(expected, actual);
    }
}

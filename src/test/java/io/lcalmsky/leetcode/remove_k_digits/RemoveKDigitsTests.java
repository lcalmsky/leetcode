package io.lcalmsky.leetcode.remove_k_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveKDigitsTests {
    @Test
    public void givenNumber_whenRemoveKDigits_thenGetSmallest() {
        assertAll(
                () -> test("1432219", 3, "1219"),
                () -> test("10200", 1, "200"),
                () -> test("10", 2, "0")
        );

    }

    private void test(String num, int k, String expected) {
        // when
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String actual = removeKDigits.removeKDigits(num, k);

        // then
        assertEquals(expected, actual);
    }
}

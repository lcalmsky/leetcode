package io.lcalmsky.leetcode.add_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddStringsTests {
    @Test
    public void givenTwoStrings_whenAddThem_thenCorrect() {
        assertAll(
                () -> test("12", "34", "46")
        );
    }

    private void test(String num1, String num2, String expected) {
        // when
        AddStrings addStrings = new AddStrings();
        String actual = addStrings.addStrings(num1, num2);

        // then
        assertEquals(expected, actual);
    }
}

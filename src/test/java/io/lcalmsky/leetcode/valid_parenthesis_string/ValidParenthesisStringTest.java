package io.lcalmsky.leetcode.valid_parenthesis_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidParenthesisStringTest {
    @Test
    public void givenString_whenFindParenthesisValid_thenCorrect() {
        assertAll(
                () -> test("()", true),
                () -> test("(*)", true),
                () -> test("(*))", true)
        );
    }

    private void test(String given, boolean expected) {
        // when
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        boolean actual = validParenthesisString.checkValidString(given);

        // then
        assertEquals(expected, actual);
    }
}
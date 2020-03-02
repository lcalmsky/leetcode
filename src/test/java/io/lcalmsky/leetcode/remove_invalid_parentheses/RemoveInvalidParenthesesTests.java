package io.lcalmsky.leetcode.remove_invalid_parentheses;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveInvalidParenthesesTests {
    @Test
    public void givenInvalidParentheses_whenRemoveThem_thenRemoveCorrectly() {
        assertAll(
                () -> test("()())()", Arrays.asList("()()()", "(())()")),
                () -> test("(a)())()", Arrays.asList("(a)()()", "(a())()")),
                () -> test(")(", Collections.singletonList(""))
        );
    }

    private void test(String given, List<String> expected) {
        // when
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        List<String> actual = removeInvalidParentheses.removeInvalidParentheses(given);

        // then
        assertEquals(expected, actual);
    }
}

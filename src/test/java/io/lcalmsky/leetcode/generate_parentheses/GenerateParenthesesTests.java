package io.lcalmsky.leetcode.generate_parentheses;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateParenthesesTests {

    @Test
    public void givenNumber_whenGenerateParenthesis_thenCorrect() {
        assertAll(
                () -> test(1, Collections.singletonList("()")),
                () -> test(2, Arrays.asList("(())", "()()")),
                () -> test(3, Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"))
        );
    }

    private void test(int given, List<String> expected) {
        // when
        Solution generateParentheses = new Solution();
        List<String> actual = generateParentheses.generateParenthesis(given);

        // then
        assertEquals(expected, actual);
    }
}

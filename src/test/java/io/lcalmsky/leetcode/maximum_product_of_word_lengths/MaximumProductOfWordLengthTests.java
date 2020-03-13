package io.lcalmsky.leetcode.maximum_product_of_word_lengths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductOfWordLengthTests {
    @Test
    @DisplayName("단어들이 주어졌을 때 문자가 중복되지 않는 단어의 곱이 가장 높은 값을 구한다")
    public void givenWords_whenFindProductOfWordLengths_thenGetMaximumValue() {
        assertAll(
                () -> test(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16),
                () -> test(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4),
                () -> test(new String[]{"a", "aa", "aaa", "aaaa"}, 0)
        );
    }

    private void test(String[] given, int expected) {
        // when
        MaximumProductOfWordLength maximumProductOfWordLength = new MaximumProductOfWordLength();
        int actual = maximumProductOfWordLength.maxProduct(given);

        // then
        assertEquals(expected, actual);
    }
}

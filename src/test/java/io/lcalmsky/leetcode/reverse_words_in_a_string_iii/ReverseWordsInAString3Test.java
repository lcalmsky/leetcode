package io.lcalmsky.leetcode.reverse_words_in_a_string_iii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsInAString3Test {
    @Test
    public void givenWords_whenReverse_thenCorrect() {
        assertAll(
                () -> test("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution reverseWordsInAString3 = new Solution();
        String actual = reverseWordsInAString3.reverseWords(given);

        // then
        assertEquals(expected, actual);
    }

}

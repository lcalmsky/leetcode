package io.lcalmsky.leetcode.lexicographical_numbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexicographicalNumbersTests {
    @Test
    public void givenNumber_whenOrderLexicographically_thenCorrect() {
        assertAll(
                () -> test(13, Arrays.asList(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    private void test(int given, List<Integer> expected) {
        // given
        Solution lexicographicalNumbers = new Solution();
        List<Integer> actual = lexicographicalNumbers.lexicalOrder(given);

        // then
        assertEquals(expected, actual);
    }
}

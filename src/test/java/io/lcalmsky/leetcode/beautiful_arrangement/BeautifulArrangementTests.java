package io.lcalmsky.leetcode.beautiful_arrangement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeautifulArrangementTests {
    @Test
    public void givenNumber_whenCountArrangement_thenCorrect() {
        assertAll(
                () -> test(2, 2)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution beautifulArrangement = new Solution();
        int actual = beautifulArrangement.countArrangement(given);

        // then
        assertEquals(expected, actual);
    }
}

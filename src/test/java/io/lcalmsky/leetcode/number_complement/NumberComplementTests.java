package io.lcalmsky.leetcode.number_complement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComplementTests {
    @Test
    public void givenNumber_whenFindComplement_thenCorrect() {
        assertAll(
                () -> test(5, 2),
                () -> test(1, 0)
        );
    }

    private void test(int given, int expected) {
        // when
        NumberComplement numberComplement = new NumberComplement();
        int actual = numberComplement.findComplement(given);

        // then
        assertEquals(expected, actual);
    }
}

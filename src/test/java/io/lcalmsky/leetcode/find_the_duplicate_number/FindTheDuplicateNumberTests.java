package io.lcalmsky.leetcode.find_the_duplicate_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheDuplicateNumberTests {
    @Test
    public void givenArray_whenFindDuplicates_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 4, 2, 2}, 2),
                () -> test(new int[]{3, 1, 3, 4, 2}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution findTheDuplicateNumber = new Solution();
        int actual = findTheDuplicateNumber.findDuplicate(given);

        // then
        assertEquals(expected, actual);
    }
}

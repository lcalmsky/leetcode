package io.lcalmsky.leetcode.contains_duplicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsDuplicateTests {
    @Test
    public void givenNumbers_whenCheckContainDuplicate_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 1}, true),
                () -> test(new int[]{1, 2, 3, 4}, false),
                () -> test(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        Solution containsDuplicate = new Solution();
        boolean actual = containsDuplicate.containsDuplicate(given);

        // then
        assertEquals(expected, actual);
    }
}

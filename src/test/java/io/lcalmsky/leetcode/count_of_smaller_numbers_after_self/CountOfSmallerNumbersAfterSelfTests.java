package io.lcalmsky.leetcode.count_of_smaller_numbers_after_self;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfSmallerNumbersAfterSelfTests {
    @Test
    public void givenArray_whenCountSmallerNumbers_thenCorrect() {
        assertAll(
                () -> test(new int[]{5, 2, 6, 1}, Arrays.asList(2, 1, 1, 0))
        );
    }

    private void test(int[] given, List<Integer> expected) {
        // when
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        List<Integer> actual = countOfSmallerNumbersAfterSelf.countSmaller(given);

        // then
        assertEquals(expected, actual);
    }
}

package io.lcalmsky.leetcode.find_all_numbers_disappeared_in_an_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllNumbersDisappearedInAnArrayTests {
    @Test
    public void givenArray_findDisappearedNumbers_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(5, 6))
        );
    }

    private void test(int[] given, List<Integer> expected) {
        // when
        Solution findAllNumbersDisappearedInAnArray = new Solution();
        List<Integer> actual = findAllNumbersDisappearedInAnArray.findDisappearedNumbers(given);

        // then
        assertEquals(expected, actual);
    }
}

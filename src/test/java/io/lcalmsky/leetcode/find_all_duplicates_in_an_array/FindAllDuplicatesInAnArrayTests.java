package io.lcalmsky.leetcode.find_all_duplicates_in_an_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllDuplicatesInAnArrayTests {
    @Test
    public void givenArray_whenFindDuplicates_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(2, 3))
        );
    }

    private void test(int[] given, List<Integer> expected) {
        // when
        Solution findAllDuplicatesInAnArray = new Solution();
        List<Integer> actual = findAllDuplicatesInAnArray.findDuplicates(given);

        // then
        assertEquals(expected, actual);
    }
}

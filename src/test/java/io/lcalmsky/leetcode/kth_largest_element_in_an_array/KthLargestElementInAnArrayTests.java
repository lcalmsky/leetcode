package io.lcalmsky.leetcode.kth_largest_element_in_an_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementInAnArrayTests {
    @Test
    public void givenNumbers_whenFindKthNumber_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                () -> test(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }

    private void test(int[] nums, int k, int expected) {
        // when
        Solution kthLargestElementInAnArray = new Solution();
        int actual = kthLargestElementInAnArray.findKthLargest(nums, k);

        // then
        assertEquals(expected, actual);
    }
}

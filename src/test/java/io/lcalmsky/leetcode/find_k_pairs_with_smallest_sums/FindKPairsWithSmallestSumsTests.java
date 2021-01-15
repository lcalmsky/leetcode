package io.lcalmsky.leetcode.find_k_pairs_with_smallest_sums;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKPairsWithSmallestSumsTests {
    @Test
    public void givenTwoIntegerArray_whenFindKPairsWithSmallestSums_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3, Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 4),
                        Arrays.asList(1, 6)
                )),
                () -> test(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2, Arrays.asList(
                        Arrays.asList(1, 1),
                        Arrays.asList(1, 1)
                )),
                () -> test(new int[]{1, 2}, new int[]{3}, 3, Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(2, 3)
                ))
        );
    }

    private void test(int[] nums1, int[] nums2, int k, List<List<Integer>> expected) {
        // when
        Solution findKPairsWithSmallestSums = new Solution();
        List<List<Integer>> actual = findKPairsWithSmallestSums.kSmallestPairs(nums1, nums2, k);

        // then
        assertEquals(expected, actual);
    }
}

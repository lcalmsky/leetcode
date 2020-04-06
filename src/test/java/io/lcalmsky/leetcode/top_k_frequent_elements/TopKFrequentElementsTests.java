package io.lcalmsky.leetcode.top_k_frequent_elements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <pre>
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * </pre>
 */
public class TopKFrequentElementsTests {
    @Test
    public void givenNumbersAndK_whenKFrequentElements_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 1, 1, 2, 2, 3}, 2, Arrays.asList(1, 2)),
                () -> test(new int[]{1}, 1, Collections.singletonList(1))
        );
    }

    private void test(int[] given, int k, List<Integer> expected) {
        // when
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        List<Integer> actual = topKFrequentElements.topKFrequent(given, k);

        // then
        assertEquals(expected, actual);
    }
}

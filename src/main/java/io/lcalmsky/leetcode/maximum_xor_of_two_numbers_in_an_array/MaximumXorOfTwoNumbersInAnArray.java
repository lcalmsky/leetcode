package io.lcalmsky.leetcode.maximum_xor_of_two_numbers_in_an_array;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 *
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * Could you do this in O(n) runtime?
 *
 * Example:
 *
 * Input: [3, 10, 5, 25, 2, 8]
 *
 * Output: 28
 *
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * </pre>
 */
public class MaximumXorOfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int result = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            // Prepare prefixes
            mask = mask | (1 << i);
            final Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            // Validate result ^ B = C?
            int temp = result | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    result = temp;
                    break;
                }
            }
        }
        return result;
    }
}

package io.lcalmsky.leetcode.smallest_range_covering_elements_from_k_lists;

import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <pre>
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
 *
 * We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
 *
 * Example 1:
 *
 * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
 * Output: [20,24]
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 *
 * Example 2:
 *
 * Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
 * Output: [1,1]
 *
 * Example 3:
 *
 * Input: nums = [[10,10],[11,11]]
 * Output: [10,11]
 *
 * Example 4:
 *
 * Input: nums = [[10],[11]]
 * Output: [10,11]
 *
 * Example 5:
 *
 * Input: nums = [[1],[2],[3],[4],[5],[6],[7]]
 * Output: [1,7]
 * </pre>
 */
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = IntStream.range(0, nums.size())
                .mapToObj(i -> nums.get(i).stream().map(x -> new int[]{x, i}))
                .flatMap(y -> y)
                .sorted(Comparator.comparingInt(p -> p[0]))
                .collect(Collectors.toList());
        int[] counts = new int[nums.size()];
        BitSet set = new BitSet(nums.size());
        int start = -1;
        int[] result = new int[2];
        for (int i = 0; i < list.size(); i++) {
            int[] p = list.get(i);
            set.set(p[1]);
            counts[p[1]] += 1;
            if (start == -1) {
                start = 0;
            }
            while (start < i && counts[list.get(start)[1]] > 1) {
                counts[list.get(start)[1]]--;
                start++;
            }
            if (set.cardinality() == nums.size()) {
                if ((result[0] == 0 && result[1] == 0) || (list.get(i)[0] - list.get(start)[0]) < result[1] - result[0]) {
                    result[0] = list.get(start)[0];
                    result[1] = list.get(i)[0];
                }
            }
        }
        return result;
    }
}

package io.lcalmsky.leetcode.find_k_pairs_with_smallest_sums;

import java.util.*;

/**
 * <pre>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * </pre>
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> (a.get(0) + a.get(1))));
        for (int i = 0; i < k && i < nums1.length; i++) pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
        while (k-- > 0 && !pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            result.add(Arrays.asList(cur.get(0), cur.get(1)));
            if (cur.get(2) == nums2.length - 1) continue;
            pq.offer(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1));
        }

        return result;
    }
}

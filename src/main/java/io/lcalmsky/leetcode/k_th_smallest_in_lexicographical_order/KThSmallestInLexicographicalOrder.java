package io.lcalmsky.leetcode.k_th_smallest_in_lexicographical_order;

/**
 * <pre>
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 *
 * Note: 1 ≤ k ≤ n ≤ 109.
 *
 * Example:
 *
 * Input:
 * n: 13   k: 2
 *
 * Output:
 * 10
 *
 * Explanation:
 * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * </pre>
 */
public class KThSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int result = 1;
        k--;

        while (k > 0) {
            int count = countPrefixBy(n, result);

            if (k >= count) {
                result++;
                k -= count;
            } else {
                result *= 10;
                k--;
            }
        }

        return result;
    }

    private int countPrefixBy(int n, int prefix) {
        int count = 0;
        for (long first = prefix, last = prefix + 1; first <= n; first *= 10, last *= 10) {
            count += Math.min(n + 1, last) - first;
        }
        return count;
    }
}

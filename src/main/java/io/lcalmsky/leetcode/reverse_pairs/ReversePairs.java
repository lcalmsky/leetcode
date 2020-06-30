package io.lcalmsky.leetcode.reverse_pairs;

/**
 * <pre>
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 *
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 * </pre>
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];

        int i = 0, rst = 0;
        int p1 = left, p2 = mid + 1, p = mid + 1;
        while (p1 <= mid) {
            while (p <= right && nums[p1] / 2.0 > nums[p]) {
                p++;
            }
            rst += p - (mid + 1);

            while (p2 <= right && nums[p1] > nums[p2]) {
                helper[i++] = nums[p2++];
            }
            helper[i++] = nums[p1++];
        }
        while (p2 <= right) {
            helper[i++] = nums[p2++];
        }

        for (i = 0; i < helper.length; i++) {
            nums[left + i] = helper[i];
        }
        return rst;
    }
}

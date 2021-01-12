package io.lcalmsky.leetcode.next_permutation;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = new int[]{1, 2, 3};
        solution.nextPermutation(arr1);
        int[] arr2 = new int[]{1, 3, 2};
        solution.nextPermutation(arr2);
        int[] arr3 = new int[]{1, 1, 5};
        solution.nextPermutation(arr3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    public void nextPermutation(int[] nums) {
        int p = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                p = i - 1;
                break;
            }
        }

        if (p == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int q = nums.length - 1;
        for (int i = nums.length - 1; i >= p; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }

        swap(nums, p, q);
        reverse(nums, p + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int length) {
        while (i < length) {
            swap(nums, i++, length--);
        }
    }

    private void swap(int[] nums, int pIdx, int qIdx) {
        int tmp = nums[pIdx];
        nums[pIdx] = nums[qIdx];
        nums[qIdx] = tmp;
    }
}

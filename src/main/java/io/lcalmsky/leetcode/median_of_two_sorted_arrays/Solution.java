package io.lcalmsky.leetcode.median_of_two_sorted_arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; i < newArr.length; i++) {
            if (j == nums1.length) {
                newArr[i] = nums2[k++];
            } else if (k == nums2.length) {
                newArr[i] = nums1[j++];
            } else {
                newArr[i] = nums1[j] > nums2[k] ? nums2[k++] : nums1[j++];
            }
        }

        int mid = newArr.length / 2;
        if (mid == 0) return newArr[0];
        if (newArr.length % 2 == 0) return (newArr[mid - 1] + newArr[mid]) / 2.0;

        return newArr[mid];
    }
}
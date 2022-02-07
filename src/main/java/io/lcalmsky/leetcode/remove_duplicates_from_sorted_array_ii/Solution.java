package io.lcalmsky.leetcode.remove_duplicates_from_sorted_array_ii;

public class Solution {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }
    if (n <= 2) {
      return n;
    }
    int indexToBeInserted = 1;
    for (int i = 2; i < n; i++) {
      if (nums[i] != nums[indexToBeInserted - 1]) {
        nums[++indexToBeInserted] = nums[i];
      }
    }
    return indexToBeInserted + 1;
  }
}

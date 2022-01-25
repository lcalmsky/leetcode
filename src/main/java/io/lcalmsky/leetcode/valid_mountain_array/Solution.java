package io.lcalmsky.leetcode.valid_mountain_array;

public class Solution {

  public boolean validMountainArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int length = arr.length - 1;
    while (left + 1 < length && arr[left] < arr[left + 1]) {
      left++;
    }
    while (right > 0 && arr[right] < arr[right - 1]) {
      right--;
    }
    return (left > 0 && left == right && right < length);
  }
}

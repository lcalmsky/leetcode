package io.lcalmsky.leetcode.container_with_most_water;

public class Solution {

  public int maxArea(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int currentLeft = height[left];
      int currentRight = height[right];
      max = Math.max(max, (right - left) * Math.min(currentLeft, currentRight));
      if (currentLeft < currentRight) {
        while (left < right && height[left] <= currentLeft) {
          left++;
        }
      } else {
        while (left < right && height[right] <= currentRight) {
          right--;
        }
      }
    }
    return max;
  }
}

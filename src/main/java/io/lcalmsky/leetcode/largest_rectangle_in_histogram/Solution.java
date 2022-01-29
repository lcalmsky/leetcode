package io.lcalmsky.leetcode.largest_rectangle_in_histogram;

import java.util.Stack;

public class Solution {

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    int index = 0;
    while (index < heights.length) {
      if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
        stack.push(index++);
        continue;
      }
      max = getMaxArea(heights, stack, max, index);
    }
    while (!stack.isEmpty()) {
      max = getMaxArea(heights, stack, max, index);
    }
    return max;
  }

  private int getMaxArea(int[] heights, Stack<Integer> stack, int max, int index) {
    int pop = stack.pop();
    int height = heights[pop];
    int width = stack.isEmpty() ? index : index - stack.peek() - 1;
    return Math.max(height * width, max);
  }
}


class AnotherSolution {

  public int largestRectangleArea(int[] heights) {
    int[] lastSmallerIndexFromLeft = new int[heights.length];
    int max = 0, index;
    for (int i = 0; i < heights.length; i++) {
      index = i - 1;
      while (index > -1 && heights[index] >= heights[i]) {
        max = Math.max(max, heights[index] * (i - lastSmallerIndexFromLeft[index] - 1));
        index = lastSmallerIndexFromLeft[index];
      }
      lastSmallerIndexFromLeft[i] = index;
    }
    index = heights.length - 1;
    while (index > -1) {
      max = Math.max(max, heights[index] * (heights.length - lastSmallerIndexFromLeft[index] - 1));
      index = lastSmallerIndexFromLeft[index];
    }
    return max;
  }
}
package io.lcalmsky.leetcode.maximal_rectangle;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    int n = m == 0 ? 0 : matrix[0].length;
    int[][] height = new int[m][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '0') {
          height[i][j] = 0;
        } else {
          height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
        }
      }
    }
    for (int[] h : height) {
      System.out.println(Arrays.toString(h));
    }
    int maxArea = 0;
    for (int i = 0; i < m; i++) {
      int area = maxAreaBy(height[i]);
      if (area > maxArea) {
        maxArea = area;
      }
    }
    return maxArea;
  }

  private int maxAreaBy(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int max = 0;
    while (i < height.length) {
      if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
        stack.push(i++);
      } else {
        int t = stack.pop();
        max = Math.max(max, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
      }
    }
    return max;
  }
}

class AnotherSolution extends Solution {

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] height = new int[n];
    Arrays.fill(right, n);
    int maxArea = 0;
    for (char[] row : matrix) {
      int currentLeft = 0, currentRight = n;
      for (int i = 0; i < n; i++) {
        if (row[i] == '1') {
          height[i]++;
        } else {
          height[i] = 0;
        }
      }
      for (int i = 0; i < n; i++) {
        if (row[i] == '1') {
          left[i] = Math.max(left[i], currentLeft);
        } else {
          left[i] = 0;
          currentLeft = i + 1;
        }
      }
      for (int i = n - 1; i >= 0; i--) {
        if (row[i] == '1') {
          right[i] = Math.min(right[i], currentRight);
        } else {
          right[i] = n;
          currentRight = i;
        }
      }
      for (int i = 0; i < n; i++) {
        maxArea = Math.max(maxArea, (right[i] - left[i]) * height[i]);
      }
    }
    return maxArea;
  }
}
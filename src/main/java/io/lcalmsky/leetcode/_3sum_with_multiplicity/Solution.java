package io.lcalmsky.leetcode._3sum_with_multiplicity;

import java.util.Arrays;

public class Solution {

  private static final int MOD = 1_000_000_007;

  public int threeSumMulti(int[] array, int target) {
    long answer = 0;
    Arrays.sort(array);
    for (int i = 0; i < array.length; ++i) {
      int twoSum = target - array[i];
      int j = i + 1, k = array.length
          - 1;
      while (j < k) {
        if (array[j] + array[k] < twoSum) {
          j++;
        } else if (array[j] + array[k] > twoSum) {
          k--;
        } else if (array[j] != array[k]) {
          int left = 1, right = 1;
          while (j + 1 < k && array[j] == array[j + 1]) {
            left++;
            j++;
          }
          while (k - 1 > j && array[k] == array[k - 1]) {
            right++;
            k--;
          }
          answer += (long) left * right;
          answer %= MOD;
          j++;
          k--;
        } else {
          answer += (long) (k - j + 1) * (k - j) / 2;
          answer %= MOD;
          break;
        }
      }
    }
    return (int) answer;
  }
}
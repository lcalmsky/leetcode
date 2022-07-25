> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_first_and_last_position_of_element_in_sorted_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) 있습니다.

## Problem

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

**Example 1:**
```text
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```
**Example 2:**
```text
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```
**Example 3:**
```text
Input: nums = [], target = 0
Output: [-1,-1]
```

**Constraints:**

* 0 <= nums.length <= 10^5
* -10^9 <= nums[i] <= 10^9
* nums is a non-decreasing array.
* -10^9 <= target <= 10^9

## Solution

감소하지 않는 정수 배열이 주어질 때 타겟 정수의 시작과 끝 인덱스를 반환하는 문제입니다.

해당 정수가 없을 때는 [-1, -1]을 반환합니다.

이진탐색을 이용해 풀 수 있습니다.

```java
package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {

  public int[] searchRange(int[] nums, int target) {
    int[] targetRange = {-1, -1};
    int leftIndex = binarySearch(nums, 0, nums.length, target, true);
    if (leftIndex == nums.length || nums[leftIndex] != target) {
      return targetRange;
    }
    targetRange[0] = leftIndex;
    targetRange[1] = binarySearch(nums, 0, nums.length, target, false) - 1;
    return targetRange;
  }

  private int binarySearch(int[] nums, int low, int high, int target, boolean leftMost) {
    if (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > target || (leftMost && target == nums[mid])) {
        return binarySearch(nums, low, mid, target, leftMost);
      }
      return binarySearch(nums, mid + 1, high, target, leftMost);
    }
    return low;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
        () -> test(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
        () -> test(new int[]{}, 0, new int[]{-1, -1})
    );
  }

  private void test(int[] nums, int target, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.searchRange(nums, target);
    // then
    assertArrayEquals(expected, actual);
  }
}
```
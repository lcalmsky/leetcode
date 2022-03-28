> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/search_in_rotated_sorted_array_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) 있습니다.

## Problem

There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

**Example 1:**
```text
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```
**Example 2:**
```text
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
```

**Constraints:**

* 1 <= nums.length <= 5000
* -10^4 <= nums[i] <= 10^4
* nums is guaranteed to be rotated at some pivot.
* -10^4 <= target <= 10^4

## Solution

감소하지 않는 순서로 정렬된 정수배열이 있습니다. 그리고 이 배열은 k번만큼 rotate 되어있습니다.

rotate된 배열과 target 정수가 주어질 때 target 정수가 배열에 포함되어있는지 여부를 반환하는 문제입니다.

단순 반환만 하는 것은 매우 쉬운 일이기 때문에 연산을 최소한으로 줄여야한다는 조건이 붙어있습니다.

rotate 되어있는 것과 상관없이 이진 탐색을 통해 답을 찾아낼 수 있습니다.

```java
public class Solution {

  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    if (nums.length == 1) {
      return target == nums[0];
    }
    int left = 0, right = nums.length - 1, mid;
    while (left <= right) {
      mid = (left + right) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] < nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[left] > nums[mid]) {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        left++;
      }
    }
    return false;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.search_in_rotated_sorted_array_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenRotatedSortedArray_whenSearch_thenCorrect() {
    assertAll(
        () -> test(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true),
        () -> test(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false)
    );
  }

  private void test(int[] givenArray, int givenTarget, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.search(givenArray, givenTarget);
    // then
    assertEquals(expected, actual);
  }
}
```
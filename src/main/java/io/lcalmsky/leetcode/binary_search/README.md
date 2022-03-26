> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/binary_search/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/binary-search/) 있습니다.

## Problem

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

**Example 1:**
```text
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```
**Example 2:**
```text
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```


**Constraints:**

* 1 <= nums.length <= 10^4
* -10^4 < nums[i], target < 10^4
* All the integers in nums are unique.
* nums is sorted in ascending order.

## Solution

오름차순으로 정렬된 정수 배열이 주어지고 타겟 정수가 주어질 때, 타겟 정수의 인덱스를 반환하는 문제입니다.

존재하지 않을 경우 -1을 반환합니다.

```java
public class Solution {

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length);
  }

  private int search(int[] nums, int target, int left, int right) {
    if (left >= right) { // (1)
      return -1;
    }
    int mid = (left + right) / 2; // (2)
    if (nums[mid] == target) { // (3)
      return mid;
    }
    if (nums[mid] > target) { // (4)
      return search(nums, target, left, mid);
    }
    if (nums[mid] < target) { // (5)
      return search(nums, target, mid + 1, right);
    }
    return -1;
  }
}
```

1. 끝까지 탐색했는데 target을 찾지 못할 경우 -1을 반환합니다.
2. 이진 검색을 해야하므로 현재 범위의 중간 값을 구합니다.
3. target과 일치하는 경우 해당 인덱스를 반환합니다.
4. target보다 더 큰 경우 큰 쪽의 범위를 반으로 줄입니다.
5. target보다 작은 경우 작은 쪽의 범위를 반으로 줄입니다.

## Test

```java
package io.lcalmsky.leetcode.binary_search;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSortedArray_whenFindNumber_thenReturnsItsIndexCorrectly() {
    assertAll(
        () -> test(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
        () -> test(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
    );
  }

  private void test(int[] given, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.search(given, target);
    // then
    assertEquals(expected, actual);
  }
}

```
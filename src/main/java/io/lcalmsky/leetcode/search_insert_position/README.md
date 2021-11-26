> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/search_insert_position/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/search-insert-position/) 있습니다.

## Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

**Example 1:**

```text
Input: nums = [1,3,5,6], target = 5
Output: 2
```

**Example 2:**

```text
Input: nums = [1,3,5,6], target = 2
Output: 1
```

**Example 3:**

```text
Input: nums = [1,3,5,6], target = 7
Output: 4
```

**Example 4:**

```text
Input: nums = [1,3,5,6], target = 0
Output: 0
```

**Example 5:**

```text
Input: nums = [1], target = 0
Output: 0
```

**Constraints:**

* 1 <= nums.length <= 10^4
* -10^4 <= nums[i] <= 10^4
* nums contains distinct values sorted in ascending order.
* -10^4 <= target <= 10^4

## Solution

정렬된 고유 정수 배열이 주어질 때 target 정수가 발견되는 인덱스를 반환하는 문제인데 O(log n) 내에 찾아서 반환해야 합니다.

만약 존재하지 않는 target 정수가 주어진다면 그 정수가 삽입될 인덱스를 반환하면 됩니다.

정렬되어있으므로 이진탐색으로 간단히 해결할 수 있습니다.

```java
public class Solution {

  public int searchInsert(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }
    int left = 0, right = nums.length - 1, mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.search_insert_position;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 3, 5, 6}, 5, 2),
        () -> test(new int[]{1, 3, 5, 6}, 2, 1),
        () -> test(new int[]{1, 3, 5, 6}, 7, 4),
        () -> test(new int[]{1, 3, 5, 6}, 0, 0),
        () -> test(new int[]{1}, 0, 0)
    );
  }

  private void test(int[] given, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.searchInsert(given, target);
    // then
    assertEquals(expected, actual);
  }
}
```
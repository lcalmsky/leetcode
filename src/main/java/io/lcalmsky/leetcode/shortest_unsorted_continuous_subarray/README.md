> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/shortest_unsorted_continuous_subarray/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/) 있습니다.

## Problem

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

**Example 1:**
```text
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```

**Example 2:**
```text
Input: nums = [1,2,3,4]
Output: 0
```

**Example 3:**
```text
Input: nums = [1]
Output: 0
```

**Constraints:**

* 1 <= nums.length <= 10^4
* -10^5 <= nums[i] <= 10^5

**Follow up**: Can you solve it in O(n) time complexity?

## Solution

정수 배열이 주어질 때 연속된 부분 배열 중 **오름차순으로 정렬했을 때 전체가 오름차순이 되게 하는 부분 배열**을 구하는 문제입니다.

부분 배열 중 가장 짧은 부분배열의 길이를 반환해야 합니다.

```java
import java.util.Stack;

public class Solution {

  public int findUnsortedSubarray(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int left = nums.length, right = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        left = Math.min(left, stack.pop());
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        right = Math.max(right, stack.pop());
      }
      stack.push(i);
    }
    return right - left > 0 ? right - left + 1 : 0;
  }
}
```

스택을 이용하여 오른쪽부터 최솟값을, 왼쪽부터 최댓값을 구해 두 인덱스의 차이를 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.shortest_unsorted_continuous_subarray;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenFindTheShortestSubarrayLength_thenCorrect() {
    assertAll(
        () -> test(new int[]{2, 6, 4, 8, 10, 9, 15}, 5),
        () -> test(new int[]{1, 2, 3, 4}, 0)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution shortestUnsortedContinuousSubarray = new Solution();
    int actual = shortestUnsortedContinuousSubarray.findUnsortedSubarray(given);

    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_sub_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-subarray/) 있습니다.

## Problem

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

**Example 1:**

```text
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Example 2:**

```text
Input: nums = [1]
Output: 1
```

**Example 3:**

```text
Input: nums = [5,4,-1,7,8]
Output: 23
```

**Constraints:**

* 1 <= nums.length <= 10^5
* -10^4 <= nums[i] <= 10^4

## Solution

정수 배열이 주어졌을 때 최소 하나 이상을 포함하는 연속된 부분 배열의 합이 최대가 되는 값을 구하는 문제입니다.

DP를 이용하여 해결할 수 있습니다.

```java
public class Solution {

  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    int max = dp[1]; // (1)
    for (int i = 1; i < nums.length + 1; i++) {
      dp[i] = Math.max(dp[i - 1], 0) + nums[i - 1]; // (2)
      max = Math.max(dp[i], max); // (3)
    }
    return max;
  }
}
```

1. 최댓값을 계속 기록하고 있어야 하므로 최댓값을 저장할 변수를 선언 및 초기화합니다.
2. dp 배열에 누적값을 계산하는데, 이전값이 마이너스이면 더할 필요가 없으므로 0과 비교하여 더 큰 값과 nums 배열의 값을 더해줍니다.
3. 최댓값과 dp 배열의 누적값 중 더 높은 값으로 최댓값을 갱신합니다.

## Test

```java
package io.lcalmsky.leetcode.maximum_subarray;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
        () -> test(new int[]{1}, 1),
        () -> test(new int[]{5, 4, -1, 7, 8}, 23)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxSubArray(given);
    // then
    assertEquals(expected, actual);
  }
}
```
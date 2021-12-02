> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/house_robber/Solution.java) 있습니다.  
> 문제는 [여기](https://github.com/lcalmsky/leetcode/issues/49) 있습니다.

## Problem

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

**Example 1:**

```text
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
```

**Example 2:**

```text
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
```

**Constraints:**

* 1 <= nums.length <= 100
* 0 <= nums[i] <= 400

## Solution

강도질(?)을 하는데 인접한 두 집을 털었을 경우 경찰이 출동합니다.

주어진 배열이 각 집의 재산을 의미할 때 최대로 털 수 있는 금액을 구하는 문제입니다.

DP를 이용해 풀면 아주 간단히 해결할 수 있습니다.

두 집을 연속으로 털 수 없으므로 전전집을 턴 후 현재 집을 털었을 때 최대가 되는 값을 점화식으로 구하면 됩니다.

```java
public class Solution {

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[nums.length - 1];
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.house_robber;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenRobbing_thenDetermineMaximumAmount() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 1}, 4),
        () -> test(new int[]{2, 7, 9, 3, 1}, 12),
        () -> test(new int[]{2, 1, 1, 2}, 4)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution houseRobber = new Solution();
    int actual = houseRobber.rob(given);

    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/min_cost_climbing_stairs/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/min-cost-climbing-stairs/) 있습니다.

## Problem

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

**Example 1:**
```text
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
  The total cost is 15.
```

**Example 2:**
```text
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
  The total cost is 6.
```

**Constraints:**

* 2 <= cost.length <= 1000
* 0 <= cost[i] <= 999

## Solution

i번째 계단을 오르는데 필요한 비용으로 구성된 cost 배열이 주어질 때 계단을 모두 오르기 위한 최소 비용을 구하는 문제입니다.

0번째 또는 1번째 인덱스에서 시작할 수 있고 계단을 하나 또는 두 개씩 올라갈 수 있습니다.

DP를 이용해 풀 수 있는데 두 개의 변수를 갱신하는 방법이 메모리 측면에서 유리합니다.

```java
package io.lcalmsky.leetcode.min_cost_climbing_stairs;

public class Solution {

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int first = cost[0];
    int second = cost[1];
    for (int i = 2; i < n; i++) {
      int current = cost[i] + Math.min(first, second);
      first = second;
      second = current;
    }
    return Math.min(first, second);
  }
}
```

첫 번째 계단으로 시작하는 경우와 두 번째 계단으로 시작하는 경우 두 개의 변수에 초기값을 설정한 뒤, 세 번째 계단부터(i = 2) 현재 계단에 오르기까지의 최소값을 갱신해 나가면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.min_cost_climbing_stairs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenCosts_whenClimbStairs_thenGetMinimumCost() {
    assertAll(
        () -> test(new int[]{10, 15, 20}, 15),
        () -> test(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minCostClimbingStairs(given);

    // then
    assertEquals(expected, actual);
  }
}

```
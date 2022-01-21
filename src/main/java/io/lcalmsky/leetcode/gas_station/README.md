> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/gas_station/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/gas_station/) 있습니다.

## Problem

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

**Example 1:**
```text
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
```

**Example 2:**
```text
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
```

**Constraints:**

* gas.length == n
* cost.length == n
* 1 <= n <= 10^5
* 0 <= gas[i], cost[i] <= 10^4

## Solution

순환 경로를 따라 n개의 가스 충전소가 있고, i번째 가스 충전소의 가스량은 gas[i]입니다.

연료 탱크가 무제한인 차가 있고 i번째 가스 충전소에서 다음 (i + 1)번째 가스 충전소까지 이동하는데 가스비용 cost[i]가 듭니다. 가스 충전소 중 한 곳에서 빈 탱크로 여행을 시작합니다.

두 개의 정수 배열(gas, cost)이 주어질 때, 시계 방향으로 순환할 수 있으면 시작 위치를, 그렇지 않으면 -1을 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.gas_station;

public class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, start = 0, remaining = 0;
    for (int i = 0; i < gas.length; i++) {
      int diff = gas[i] - cost[i];
      remaining += diff; // (1)
      total += diff; // (2)
      if (remaining < 0) { // (3)
        remaining = 0;
        start = i + 1;
      }
    }
    return total >= 0 ? start : -1; // (4)
  }
}

```

1. 주유 및 이동 후 남은 가스량을 계산합니다.
2. 남은 가스량을 더해 총 가스량을 구합니다.
3. 남은 가스량을 더해 합을 구합니다.
4. 총 가스량이 양수일 경우 시작지점을 반환하고 그렇지 않을 경우는 순환할 수 없으므로 -1을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.gas_station;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenGasAndCostArrays_whenFindStartIndex_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
        () -> test(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1),
        () -> test(new int[]{4, 5, 2, 6, 5, 3}, new int[]{3, 2, 7, 3, 2, 9}, -1)
    );
  }

  private void test(int[] gas, int[] cost, int expected) {
    // when
    Solution gasStation = new Solution();
    int actual = gasStation.canCompleteCircuit(gas, cost);
    // then
    assertEquals(expected, actual);
  }
}
```
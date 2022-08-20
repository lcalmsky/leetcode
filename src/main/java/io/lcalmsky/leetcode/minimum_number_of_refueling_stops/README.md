> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_number_of_refueling_stops/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-number-of-refueling-stops/) 있습니다.

## Problem

A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.



Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can not reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.


Constraints:

1 <= target, startFuel <= 10^9
0 <= stations.length <= 500
0 <= positioni <= positioni+1 < target
1 <= fueli < 10^9

## Solution

자동차의 초기 기름양과 목적지까지의 마일이 주어졌을 때 최소 주유 횟수를 구하는 문제입니다.

목적지까지 도달할 수 없을 때는 -1을 반환합니다.

```java
public class Solution {

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    int length = stations.length;
    int[] dp = new int[length + 1];
    dp[0] = startFuel;
    for (int i = 0; i < length; i++) {
      for (int j = i; j >= 0; j--) {
        if (dp[j] >= stations[i][0]) {
          dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
        }
      }
    }
    for (int i = 0; i <= length; i++) {
      if (dp[i] >= target) {
        return i;
      }
    }
    return -1;
  }
}

```

DP를 이용해 풀 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.minimum_number_of_refueling_stops;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, 1, new int[][]{}, 0),
        () -> test(100, 1, new int[][]{{10, 100}}, -1),
        () -> test(1, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}, 2)
    );
  }

  private void test(int target, int startFuel, int[][] stations, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minRefuelStops(target, startFuel, stations);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/two_city_scheduling/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/two-city-scheduling/) 있습니다.

## Problem

A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.

**Example 1:**
```text
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
```
**Example 2:**
```text
Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
```
**Example 3:**
```text
Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086
```

**Constraints:**

* 2 * n == costs.length
* 2 <= costs.length <= 100
* costs.length is even.
* 1 <= aCosti, bCosti <= 1000

## Solution

한 회사에서 2n명을 인터뷰할 계획입니다. 비용 배열이 주어지는데 cost[i] = [aCosti, bCosti]는 i번째 사람을 도시 a로 보내는 비용과 b로 보내는 비용을 나타냅니다.

정확히 n명이 각 도시에 도착하도록 모든 사람을 도시로 보내는 데 드는 최소 비용을 반환하는 문제입니다.

```java
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int twoCitySchedCost(int[][] costs) {
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> (x[1] - x[0]))); // (1)
    int sum = 0;
    for (int[] cost : costs) { // (2)
      sum += cost[0];
      queue.add(cost);
    }
    for (int i = 0; i < costs.length / 2; ++i) { // (3)
      int[] poll = queue.poll();
      sum += (poll[1] -poll[0]);
    }
    return sum;
  }
}
```

1. cost의 차이를 기준으로 오름차순으로 정렬되는 우선순위 큐를 생성합니다.
2. 모두 도시 A로 간다고 가정하고 cost를 계산합니다.
3. 큐는 cost의 차이로 정렬되어있으므로 가작 작은 cost가 큐의 top에 위치하게 됩니다. 따라서 큐의 처음 반 부분에 해당하는 사람들이 B 도시로 가면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.two_city_scheduling;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}, 110),
        () -> test(
            new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}},
            1859),
        () -> test(
            new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60},
                {650, 359},
                {631, 42}}, 3086)
    );
  }

  private void test(int[][] costs, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.twoCitySchedCost(costs);
    // then
    assertEquals(expected, actual);
  }
}
```
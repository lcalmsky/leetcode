> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/car_pooling/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/car-pooling/) 있습니다.

## Problem

There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

**Example 1:**

```text
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
```

**Example 2:**

```text
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
```

**Constraints:**

* 1 <= trips.length <= 1000
* trips[i].length == 3
* 1 <= numPassengersi <= 100
* 0 <= fromi < toi <= 1000
* 1 <= capacity <= 10^5

## Solution

여행 정보를 나타내는 배열과 차에 태울 수 있는 capacity가 주어질 때 모든 승객을 태울 수 있는지 여부를 반환하는 문제입니다.

각 trip은 [n, from, to] n명이 from에서 to까지 이동하는 것을 나타냅니다.

예제 1번을 보면 2명이 1번에서 승차해서 5번에서 하차해야하는데 3명이 3번에서 추가로 승차하려고합니다. 차의 용량은 4명이 한계이기 때문에 false를 반환하게 됩니다.

```java
import java.util.Arrays;

public class Solution {

  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o2[2] - o1[2]);
    for (int i = 0; i < trips.length; i++) {
      int current = trips[i][0];
      for (int j = i - 1; j >= 0; j--) {
        if (trips[j][2] > trips[i][1]) {
          current += trips[j][0];
        }
      }
      if (current > capacity) {
        return false;
      }
    }
    return true;
  }
}
```

trips 배열을 시작 위치, 끝 위치 순으로 정렬한뒤 각 배열을 탐색하며 겹치는 부분이 있을 경우에 현재 탑승객이 capacity 보다 큰지 검사하면 됩니다.

---

더 간단한 방법을 소개합니다.

미리 승객이 탑승하는 곳과 하차하는 곳을 계산해놓고 최종으로 하차하는 구간까지만 반복하면서 승객의 수를 더해 capacity가 넘지 않는지만 확인해주면 됩니다.

```java
class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    int last = 0;
    int[] arr = new int[1001];
    for (int[] trip : trips) {
      int from = trip[1];
      int to = trip[2];
      int passengers = trip[0];
      arr[from] += passengers;
      arr[to] -= passengers;
      last = Math.max(last, to);
    }
    int passengers = 0;
    for (int i = 0; i < last; i++) {
      passengers += arr[i];
      if (passengers > capacity) {
        return false;
      }
    }
    return true;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.car_pooling;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4, false),
        () -> test(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5, true)
    );
  }

  private void test(int[][] trips, int capacity, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.carPooling(trips, capacity);
    // then
    assertEquals(expected, actual);
  }
}
```
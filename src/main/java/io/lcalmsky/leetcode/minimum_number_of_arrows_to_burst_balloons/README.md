> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_number_of_arrows_to_burst_balloons/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) 있습니다.

## Problem

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

**Example 1:**

```text
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
```

**Example 2:**

```text
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
```

**Example 3:**

```text
Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
```

**Constraints:**

* 1 <= points.length <= 10^5
* points[i].length == 2
* -2^31 <= xstart < xend <= 2^31 - 1

## Solution

XY 평면을 나타내는 평평한 벽에 몇 개의 풍선이 붙어 있습니다. 풍선은 2D 정수 배열 점으로 표시됩니다. 여기서 점을 나타내는 points[i] = [xstart, xend]는 수평 지름이 xstart에서 xend까지인 풍선을 나타내고 풍선의 y좌표는 알 수 없습니다.

화살은 x 좌표 어딘가에서 발사하여 세로 방향으로 진행하고 진행하는 동안 마주치는 풍선을 모두 터뜨립니다.

이 때 풍선을 모두 터트리기 위해 필요한 최소한의 화살 갯수를 구하는 문제입니다.

```java
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // (1)
    int arrowPosition = points[0][1]; // (2)
    int arrowCount = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= arrowPosition) { // (3)  
        continue;
      }
      arrowCount++; // (4)
      arrowPosition = points[i][1]; // (5)
    }
    return arrowCount;
  }
}
```

1. 지름의 끝 점을 기준으로 정렬합니다.
2. 첫 번째 화살의 위치를 첫 번째 풍선의 끝 부분으로 설정합니다.
3. 화살의 위치가 다음 풍선의 시작점 보다 크면 이전 화살에 의해 같이 터지게 되므로 아무 것도 하지 않습니다.
4. 화살의 위치보다 풍선의 지름 시작점이 더 큰 경우 이전 화살은 맞지 않으므로 새로운 화살을 쏩니다.
5. 새로운 화살을 기준으로 설정합니다.

## Test

```java
package io.lcalmsky.leetcode.minimum_number_of_arrows_to_burst_balloons;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  void givenBalloons_whenShotArrows_thenBurstsWithMinimumNumber() {
    assertAll(
        () -> test(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2),
        () -> test(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4),
        () -> test(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.findMinArrowShots(given);
    // then
    assertEquals(expected, actual);
  }
}
```

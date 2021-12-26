> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/k_closest_points_to_origin/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/k-closest-points-to-origin/) 있습니다.

## Problem

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)^2 + (y1 - y2)^2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/03/closestplane1.jpg)

```text
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
```

**Example 2:**

```text
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
```

**Constraints:**

* 1 <= k <= points.length <= 10^4
* -10^4 < xi, yi < 10^4

## Solution

x, y 좌표를 나타내는 배열과 정수 k가 주어질 때 0, 0 부터 가까운 k개의 좌표를 구해 반환하는 문제입니다.

먼저 0, 0부터 x, y까지 길이를 구하는 공식이 문제에 주어지고 이를 활용하면 좌표 배열의 각각의 값을 제곱했을 때 작은 값일 수록 원점에 가까운 점이라고 생각할 수 있습니다.

아주 단순히 풀어보자면 아래처럼 정렬을 이용해 풀 수 있습니다.

```java
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int[][] kClosest(int[][] points, int k) {
    int[][] result = new int[k][2];
    Arrays.sort(points, Comparator.comparingDouble(o -> Math.pow(o[0], 2) + Math.pow(o[1], 2))); // (1)
    System.arraycopy(points, 0, result, 0, result.length); // (2)
    return result;
  }
}
```

1. 배열의 원소 각각을 제곱한 값을 기준으로 오름차순으로 정렬합니다.
2. k개의 원소만 copy 합니다.

## Test

```java
package io.lcalmsky.leetcode.k_closest_points_to_origin;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
        () -> test(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}})
    );
  }

  private void test(int[][] points, int k, int[][] expected) {
    // when
    Solution solution = new Solution();
    int[][] actual = solution.kClosest(points, k);
    // then
    assertArrayEquals(expected, actual);
  }
}
```
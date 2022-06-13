> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/triangle/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/triangle/) 있습니다.

## Problem

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

**Example 1:**
```text
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
2
3 4
6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
```
**Example 2:**
```text
Input: triangle = [[-10]]
Output: -10
```

**Constraints:**

* 1 <= triangle.length <= 200
* triangle[0].length == 1
* triangle[i].length == triangle[i - 1].length + 1
* -10^4 <= triangle[i][j] <= 10^4

## Solution

삼각형 모양의 배열이 주어질 때 맨 위부터 맨 아래까지 경로의 합의 최솟값을 구하는 문제입니다.

인접한 아래 행으로 이동할 수 있습니다.

DP를 이용해 아래서부터 위로 올라오면서 최소의 합을 구해 풀 수 있습니다.

```java
package io.lcalmsky.leetcode.triangle;

import java.util.List;

public class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    int[] total = new int[triangle.size()];
    int height = triangle.size() - 1;
    for (int i = 0; i < triangle.get(height).size(); i++) { // (1)
      total[i] = triangle.get(height).get(i);
    }
    for (int i = triangle.size() - 2; i >= 0; i--) { // (2)
      for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) { // (3)
        total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]); // (4)  
      }
    }
    return total[0];
  }
}
```

1. 계산을 위한 배열에 기존 값을 동일하게 할당합니다.
2. 맨 아래서 두 번째 행부터
3. 각 열을 탐색하면서
4. 현재 값과 인접한 위치에 있는 값들 중 최솟값을 더합니다.

## Test

```java
package io.lcalmsky.leetcode.triangle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTriangle_whenFindMinimumSum_thenCorrect() {
    assertAll(
        () -> test(
            List.of(
                Collections.singletonList(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
            ), 11),
        () -> test(
            List.of(
                Collections.singletonList(-10)
            ), -10)
    );
  }

  private void test(List<List<Integer>> given, int expected) {
    // when
    Solution triangle = new Solution();
    int actual = triangle.minimumTotal(given);

    // then
    assertEquals(expected, actual);
  }
}
```
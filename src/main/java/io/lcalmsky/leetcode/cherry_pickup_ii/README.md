> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/cherry_pickup_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/cherry-pickup-ii/) 있습니다.

## Problem

You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.


**Example 1:**

![](https://assets.leetcode.com/uploads/2020/04/29/sample_1_1802.png)

```text
Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/04/23/sample_2_1802.png)

```text
Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
```

**Constraints:**

* rows == grid.length
* cols == grid[i].length
* 2 <= rows, cols <= 70
* 0 <= grid[i][j] <= 100

## Solution

체리 밭을 나타내는 rows * cols 그리드가 주어지고 각 셀은 수확할 수 있는 체리의 갯수를 의미합니다.

두 개의 로봇이 각각 왼쪽 위, 오른쪽 위에 위치해있고, 각 로봇은 아래, 대각선 아래 방향으로만 이동 가능하며 중복으로 체리를 수확할 수 없을 때 체리를 가장 많이 수확할 수 있는 경우의 체리 숫자를 반환하는 문제입니다.

문제를 보자마자 DP (Dynamic Programming)가 떠오르는 데 두 개의 로봇이 움직이는 만큼 예외 상황에 대한 처리가 필요할 거 같습니다.

두 로봇이 움직이기 때문에 동시에 움직이더라도 어떤 로봇이 먼저 체리를 수집하는지에 대한 방문처리가 필요하고 각 로봇이 상호배타적으로 움직여야하기 때문에 이 부분을 예외처리하는 것이 중요합니다.

```java
package io.lcalmsky.leetcode.cherry_pickup_ii;

public class Solution {

  public int cherryPickup(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[][][] dpCache = new int[height][width][width];
    initialize(height, width, dpCache);
    return dp(0, 0, width - 1, grid, dpCache);
  }

  private void initialize(int height, int width, int[][][] dpCache) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < width; k++) {
          dpCache[i][j][k] = -1;
        }
      }
    }
  }

  private int dp(int row, int col1, int col2, int[][] grid, int[][][] dpCache) {
    // (1)
    if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
      return 0;
    }
    // (2)
    if (dpCache[row][col1][col2] != -1) {
      return dpCache[row][col1][col2];
    }
    // (3) 
    int result = grid[row][col1];
    // (4)
    if (col1 != col2) {
      result += grid[row][col2];
    }
    // (5)
    if (row != grid.length - 1) {
      int max = 0;
      // (6)
      for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
        for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
          // (7)
          max = Math.max(max, dp(row + 1, newCol1, newCol2, grid, dpCache));
        }
      }
      // (8)
      result += max;
    }
    // (9)
    dpCache[row][col1][col2] = result;
    // (10
    return result;
  }
}
```

1. 열이 grid의 범위를 벗어났을 때 체리를 수확할 수 없으므로 0을 반환합니다.
2. 캐시가 -1이 아니면 이미 수확했다는 뜻이므로 기존 체리 갯수를 반환합니다.
3. 현재 셀에 대해 계산합니다. col1과 col2는 robot1이나 robot2가 이전에 방문했던 열입니다.
4. 이전에 방문했던 열이 같지 않을 때 결과에 더해줍니다.
5. grid의 끝에 다다라지 않았다면 추가로 방문해야 합니다.
6. 새로 방문할 열의 기준은 이전에 방문한 열 기준 -1 ~ +1 까지 입니다.
7. 행을 증가시키고 새로운 열을 탐색하여 더 높은 값으로 max 값을 갱신합니다.
8. 결과에 max 값을 더해줍니다.
9. 가장 높은 값을 캐시에 저장합니다.
10. 현재 계산된 가장 높은 값을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.cherry_pickup_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}, 24),
        () -> test(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0},
            {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}, 28)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.cherryPickup(given);
    // then
    assertEquals(expected, actual);
  }
}
```
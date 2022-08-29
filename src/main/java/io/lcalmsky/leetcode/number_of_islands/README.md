> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/number_of_islands/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/number-of-islands/) 있습니다.

## Problem

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

**Example 1:**
```text
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```
**Example 2:**
```text
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

**Constraints:**

* m == grid.length
* n == grid[i].length
* 1 <= m, n <= 300
* grid[i][j] is '0' or '1'.

## Solution

M * N 행렬이 주어지는데 1이 땅을, 0이 물을 의미합니다. 1로 이어진 부분을 섬이라고 부를 때 모든 섬의 개수를 구하는 문제입니다.

DFS를 이용해 풀 수 있습니다.

```java
public class Solution {

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          merge(grid, i, j);
        }
      }
    }
    return count;
  }

  public void merge(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = 'X';
    merge(grid, i - 1, j);
    merge(grid, i + 1, j);
    merge(grid, i, j - 1);
    merge(grid, i, j + 1);
  }
}
```

땅을 방문했을 때 방문처리하고 땅 주변을 다시 방문하도록 처리하면서 각각의 상황에서 범위를 벗어나지 않았는지, 물이 아닌지 체크하여 모든 행렬을 탐색하면서 섬의 개수를 카운트 해주면 됩니다. 

## Test

```java
package io.lcalmsky.leetcode.number_of_islands;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenGrid_whenFindIslands_thenCountThemExactly() {
    assertAll(
        () -> test(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        }, 1),
        () -> test(new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
        }, 3)
    );
  }

  private void test(char[][] given, int expected) {
    // when
    Solution numberOfIslands = new Solution();
    int actual = numberOfIslands.numIslands(given);

    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/shortest_path_in_binary_matrix/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/shortest-path-in-binary-matrix/) 있습니다.

## Problem

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no **_clear path_**, return -1.

A **clear path** in a binary matrix is a path from the **top-left** cell (i.e., (0, 0)) to the **bottom-right** cell (i.e., (n - 1, n - 1)) such that:

* All the visited cells of the path are 0.
* All the adjacent cells of the path are **8-directionally** connected (i.e., they are different and they share an edge or a corner).

The **length of a clear path** is the number of visited cells of this path.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/18/example1_1.png)
```text
Input: grid = [[0,1],[1,0]]
Output: 2
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/18/example2_1.png)

```text
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
```

**Example 3:**

```text
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
```

**Constraints:**

* n == grid.length
* n == grid[i].length
* 1 <= n <= 100
* grid[i][j] is 0 or 1

## Solution

n * n 이진 행렬이 주어질 때 가장 짧은 `clear path`를 구하는 문제입니다.

`clear path`는 왼쪽 위부터 오른쪽 아래까지 이동하는데 0만 방문해야합니다.

이동은 각 셀에서 8방향으로 진행할 수 있습니다.

```java
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private final static int[][] DIRECTIONS = new int[][]{
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}
  };

  public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
      return -1;
    }
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true; // 시작 지점을 방문처리 합니다.
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0}); // 큐에 시작 지점의 좌표를 추가합니다.
    int length = 1;
    while (!queue.isEmpty()) { // 큐가 비어있지 않은 동안
      int size = queue.size();
      for (int i = 0; i < size; i++) { // 큐의 사이즈만큼 반복하면서
        int[] pop = queue.poll(); // 큐의 head에 있는 원소를 꺼내 
        if (pop[0] == m - 1 && pop[1] == n - 1) { // 도착 지점일 경우 길이를 반환하고
          return length;
        }
        for (int j = 0; j < 8; j++) { // 그렇지 않을 경우 해당 좌표에 대해 8방향을 모두 조사하면서 방문처리 합니다.
          int nextX = DIRECTIONS[j][0] + pop[0];
          int nextY = DIRECTIONS[j][1] + pop[1];
          if (isInRange(m, n, nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
            queue.add(new int[]{nextX, nextY});
            visited[nextX][nextY] = true;
          }
        }
      }
      length++; // 길이를 증가시킵니다.
    }
    return -1;
  }

  private boolean isInRange(int m, int n, int nextX, int nextY) {
    return nextX >= 0 && nextX < m && nextY >= 0 && nextY < n;
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.shortest_path_in_binary_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{
            {0, 1}, {1, 0}
        }, 2),
        () -> test(new int[][]{
            {0, 0, 0}, {1, 1, 0}, {1, 1, 0}
        }, 4),
        () -> test(new int[][]{
            {1, 0, 0}, {1, 1, 0}, {1, 1, 0}
        }, -1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.shortestPathBinaryMatrix(given);
    // then
    assertEquals(expected, actual);
  }
}
```
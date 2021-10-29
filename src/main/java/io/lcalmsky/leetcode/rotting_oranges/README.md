> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/rotting_oranges/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/rotting-oranges/) 있습니다.

## Problem

You are given an m x n grid where each cell can have one of three values:

* 0 representing an empty cell,
* 1 representing a fresh orange, or
* 2 representing a rotten orange.

* Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/02/16/oranges.png)

```text
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
```

**Example 2:**

```text
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
```

**Example 3:**

```text
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
```

**Constraints:**

* m == grid.length
* n == grid[i].length
* 1 <= m, n <= 10
* grid[i][j] is 0, 1, or 2.

## Solution

그리드에 빈 셀과 싱싱한 오렌지가 있는 셀, 썩은 오렌지가 있는 셀이 주어지고 한 타임당 썩은 오렌지 주변(상하좌우) 셀에 존재하는 싱싱한 오렌지가 썩는다고 가정했을 때 오렌지가 모두 썩을 때까지 걸리는 시간을 계산하는 문제입니다.

먼저 썩은 오렌지의 위치를 `Queue`에 넣고 `Queue`가 완전히 빌 때까지 반복하면서 주변 오렌지를 썩게(?)하고, 그 때 걸리는 시간을 계산해 반환하면 됩니다.

이 때 떨어져있어 썩지 않은 오렌지가 존재할 경우 -1를 반환하면 됩니다.

```java
package io.lcalmsky.leetcode.rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static final int[][] directions = new int[][]{
        {1, -1, 0, 0},
        {0, 0, 1, -1}
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottens = findRottenOranges(grid); // (1)
        int times = calculateRottingTimes(grid, rottens); // (2)
        if (!areAllRotten(grid)) { // (3)
            return -1;
        }
        return times;
    }

    private Queue<int[]> findRottenOranges(int[][] grid) {
        Queue<int[]> rottens = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottens.add(new int[]{i, j});
                }
            }
        }
        return rottens;
    }

    private int calculateRottingTimes(int[][] grid, Queue<int[]> rottens) {
        int times = 0;
        while (!rottens.isEmpty()) {
            int size = rottens.size();
            boolean counted = false;
            for (int k = 0; k < size; k++) {
                int[] rotten = rottens.poll();
                for (int i = 0; i < 4; i++) {
                    int x = rotten[0] + directions[0][i];
                    int y = rotten[1] + directions[1][i];
                    if (x >= 0 && x < grid.length && y >= 0
                        && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        if (!counted) {
                            times++;
                            counted = true;
                        }
                        rottens.add(new int[]{x, y});
                    }
                }
            }
        }
        return times;
    }

    private boolean areAllRotten(int[][] grid) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

```

1. 그리드를 탐색하며 썩은 오렌지(2)를 찾아 해당 오렌지의 좌표를 `Queue`에 넣습니다.
2. `Queue`에서 썩은 오렌지의 좌표를 꺼내 상하좌우를 검사해 싱싱한 오렌지(1)일 경우 썩은 오렌지로 바꿔주고, 중복으로 카운팅하지 않게 counted 값을 변경시켜 썩은 오렌지 기준 한 번만 카운팅 되도록 합니다. 그리고 해당 타임에 썩은 오렌지를 다시 큐에 넣어주고 동일한 작업을 반복합니다.
3. 2번 작업이 끝난 후 아직 썩지 않은 오렌지가 있는지 확인합니다.

## Test

```java
package io.lcalmsky.leetcode.rotting_oranges;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("그리드가 주어졌을 때 오렌지가 모두 썩는 시간을 구함")
    void test() {
        assertAll(
            () -> test(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4),
            () -> test(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}, -1),
            () -> test(new int[][]{{0, 2}}, 0)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.orangesRotting(given);
        // then
        assertEquals(expected, actual);
    }
}
```
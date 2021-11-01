> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/surrounded_regions/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/surrounded-regions/) 있습니다.

## Problem

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

**Example 1:**

```text
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
```

**Example 2:**

```text
Input: board = [["X"]]
Output: [["X"]]
```

**Constraints:**

* m == board.length
* n == board[i].length
* 1 <= m, n <= 200
* board[i][j] is 'X' or 'O'.

## Solution

'X'와 'O'로 이루어진 m * n 행렬이 주어졌을 때 4면이 모두 'X'로 둘러쌓인 영역을 모두 'X'로 바꾼 행렬을 완성하는 문제입니다.

4면이 X로 둘러쌓이지 않으려면 행렬의 가장자리에 위치하거나 가장자리에 위치한 O와 연결되어있어야 합니다.

풀이는 네 가지 step으로 진행됩니다.

1. 행을 순차적으로 탐색하면서 각 행의 첫 번 째, 마지막 값이 `O`인지 확인합니다. 즉 첫 번 째, 마지막 열의 O를 확인하여 변환되지 않을 임시 값(*)으로 바꿔줍니다. 
2. 열을 순차적으로 탐색하면서 각 열의 첫 번 째, 마지막 값이 `O`인지 확인합니다. 즉 첫 번 째, 마지막 행의 O를 확인하여 변환되지 않을 임시 값(*)으로 바꿔줍니다.
3. 1, 2번에서 체크한 `*`와 인접한 값을 마찬가지로 `*`로 바꿔줍니다. 절대 `X`로 상하좌우 네 면이 둘러쌓일 수 없기 때문입니다.
4. 3번까지 진행한 board를 전체적으로 탐색하면서 `O`를 `X`로 바꿔주고 `*`를 다시 `O`로 바꿔줍니다.

```java
package io.lcalmsky.leetcode.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {0, 0, 1, -1}, {1, -1, 0, 0}
    };


    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        checkFirstAndLastRows(board, m, n, queue);
        checkFirstAndLastColumns(board, m, n, queue);
        checkNeighbor(board, m, n, queue);
        updateBoard(board, m, n);
    }

    private void checkFirstAndLastRows(char[][] board, int m, int n, Queue<int[]> queue) {
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '*';
                queue.offer(new int[]{0, i});
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = '*';
                queue.offer(new int[]{m - 1, i});
            }
        }
    }

    private void checkFirstAndLastColumns(char[][] board, int m, int n, Queue<int[]> queue) {
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '*';
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '*';
                queue.offer(new int[]{i, n - 1});
            }
        }
    }

    private void checkNeighbor(char[][] board, int m, int n, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current[0] + DIRECTIONS[0][i];
                int y = current[1] + DIRECTIONS[1][i];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                    board[x][y] = '*';
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    private void updateBoard(char[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.surrounded_regions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("주어진 행렬의 X로 둘러쌓인 O를 모두 X로 바꿔라")
    void testAll() {
        assertAll(
            () -> test(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
            }, new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}})
        );
    }

    private void test(char[][] given, char[][] expected) {
        // when
        Solution solution = new Solution();
        solution.solve(given);
        // then
        assertArrayEquals(expected, given);
    }
}
```
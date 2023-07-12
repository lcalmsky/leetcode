> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_all_duplicates_in_an_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-all-duplicates-in-an-array/) 있습니다.

## Problem

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/04/word2.jpg)

```text
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg)

```text
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2020/10/15/word3.jpg)

```text
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```

**Constraints:**

* m == board.length
* n = board[i].length
* 1 <= m, n <= 6
* 1 <= word.length <= 15
* board and word consists of only lowercase and uppercase English letters.

**Follow up:** Could you use search pruning to make your solution faster with a larger board?

## Solution

m * n 그리드와 단어가 주어질 때 그리드 안에 단어가 존재하는지 확인하는 문제입니다.

단어는 인접한 셀을 이어서 완성해야하고 같은 셀을 두 번 이상 방문할 수 없습니다.

DFS 알고리즘을 사용해 간단히 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.word_search;

public class Solution {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int n, int i, int j, boolean[][] visited) {
        if (n == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (word.charAt(n) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean result = search(board, word, n + 1, i - 1, j, visited)
                || search(board, word, n + 1, i + 1, j, visited)
                || search(board, word, n + 1, i, j - 1, visited)
                || search(board, word, n + 1, i, j + 1, visited);
        visited[i][j] = false;
        return result;
    }
}
```

1. count가 word의 길이와 동일한 경우, 즉, 모든 문자를 찾은 경우 true를 반환합니다.
1. 현재 검사 중인 board의 인덱스가 범위를 벗어난 경우 (i < 0 || i >= m || j < 0 || j >= n), 즉, 유효하지 않은 인덱스인 경우 false를 반환합니다.
1. 이미 방문한 위치인 경우 (visited[i][j]가 true인 경우), 이전에 이미 검사를 한 위치이므로 false를 반환합니다.
1. board[i][j]의 문자가 word의 count 위치에 해당하는 문자와 다른 경우, 즉, 일치하지 않는 경우 false를 반환합니다.
1. 현재 위치를 방문 처리하고 (visited[i][j]를 true로 설정) 다음 위치를 검사하기 위해 재귀적으로 exist 메소드를 호출합니다. 여기서 다음 위치는 현재 위치의 오른쪽, 왼쪽, 아래, 위를 의미합니다.
1. 재귀 호출 결과를 exist에 저장하고, 방문 처리를 취소한 뒤 (visited[i][j]를 false로 설정), exist 값을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.word_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenCharacters_whenSearchWord_thenCorrect() {
        char[][] givenArray = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertAll(
                () -> test(givenArray, "ABCCED", true),
                () -> test(givenArray, "SEE", true),
                () -> test(givenArray, "ABCB", false),
                () -> test(new char[][]{
                        {'a'}
                }, "a", true),
                () -> test(new char[][]{
                        {'a', 'b'},
                        {'c', 'd'}
                }, "abcd", false)
        );

    }

    private void test(char[][] givenArray, String givenWord, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.exist(givenArray, givenWord);

        // then
        assertEquals(expected, actual);
    }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/dungeon_game/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/dungeon-game/) 있습니다.

## Problem

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/13/dungeon-grid-1.jpg)

```text
Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
```

**Example 2:**

```text
Input: dungeon = [[0]]
Output: 1
```

**Constraints:**

* m == dungeon.length
* n == dungeon[i].length
* 1 <= m, n <= 200
* -1000 <= dungeon[i][j] <= 1000

## Solution

행렬로 표현되는 던전이 주어지는데 이 때 행렬의 각 원소는 던전을 지날 때 소모되는 HP를 의미합니다.

던전 내에서는 오른쪽과 아래로만 움직일 수 있고 마지막 원소에 다다랐을 때 공주를 구할 수 있습니다.

던전을 클리어하기 위한 최소한의 HP를 구하는 문제입니다.

일반적인 DP 문제처럼 풀게되면 중간에 HP가 마이너스가 될 수 있고 이는 곧 죽음을 의미하므로 던전을 클리어할 수 없게 됩니다.

따라서 도착지점에서 최소한의 HP를 가지는 상태를 초기 상태로 두고 출발 위치까지 역으로 계산하여 답을 구할 수 있습니다.

최소 HP는 1이므로 각각의 스텝을 계산할 때 1이하로 가지 않게 기존 HP를 관리해줘야 합니다.

```java
public class Solution {
    public int calculateMinimumHp(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1); // (1)

        for (int i = m - 2; i >= 0; i--) { // (2)
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) { // (3)
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) { // (4)
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0];
    }
}
```

(1) 도착했을 때 최소 HP를 구합니다. 1에서 해당 던전의 HP 소모량을 빠주어 이전 HP의 최솟값을 구할 수 있습니다. 마이너스가 되는 경우 HP 최솟값인 1로 설정합니다. 예를 들어 마지막 던전의 HP 소모량이 3인 경우 계산한 값이 -2가 되는데 이는 이전 HP의 값이 -2여도 HP를 소모하는 것이 아닌 3만큼 더해지는 것이기 때문에 최종 던전에서 1로 통과할 수 있음을 의미하지만 실제로 -2의 HP를 가지게되면 사망하여 던전을 클리어할 수 없으므로 최솟값인 1로 설정해주는 것입니다. 반대로 마지막 던전의 HP 소모량이 -2라고 한다면 이전 단계에서 필요한 HP는 1 - (-2) 인 3 입니다.  
(2, 3) DP 알고리즘을 사용하기 위해 마지막 행과 열을 초기화해 줍니다. 계산하는 방법은 (1)과 동일합니다. 이전 값(실제로는 다음 던전의 값)과 현재 값의 차를 구해 최댓값을 구하는데 음수가 될 경우 HP 최솟값인 1로 설정합니다.  
(4) 초기값 설정이 완료되었으므로 다음 행과 열부터 탐색을 하며 오른쪽으로 움직였을 때와 아래쪽으로 움직였을 때의 HP 최댓값을 구하고 그 중 최솟값으로 DP 행렬의 값을 설정합니다.

마지막에 DP 행렬의 첫 번 째 값을 반환하게 되면 던전을 클리어하는데 필요한 HP의 최솟값을 구할 수 있습니다.

---

추가 메모리 없이도 풀 수 있습니다. 

```java
class AnotherSolution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        dungeon[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 2; i >= 0; i--) {
            dungeon[i][n - 1] = Math.max(1, dungeon[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dungeon[m - 1][i] = Math.max(1, dungeon[m - 1][i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dungeon[0][0];
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.dungeon_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenArray_whenFindMinimumHp_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                }, 7)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.calculateMinimumHp(given);

        // then
        assertEquals(expected, actual);
    }
}
```
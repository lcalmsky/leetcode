> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/stone_game_iv/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/stone_game_iv/) 있습니다.

## Problem

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.

**Example 1:**
```text
Input: n = 1
Output: true
Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.
```
**Example 2:**
```text
Input: n = 2
Output: false
Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -> 1 -> 0).
```
**Example 3:**
```text
Input: n = 4
Output: true
Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).
```

**Constraints:**

* 1 <= n <= 10^5

## Solution

앨리스와 밥이 돌을 제거하는 게임을 하는데, n개의 돌이 주어지고 0이 아닌 제곱수 만큼 번갈아가면서 제거할 수 있고 마지막으로 돌을 제거하는 사람이 승리합니다.

앨리스가 먼저 시작하고 두 사람 모두 최적의 플레이를 한다고 가정할 때 앨리스가 이기면 true를, 그렇지 않으면 false를 반환하는 문제입니다.

dp[i]가 true이면 돌이 i개 일 때 현재 플레이어가 승리하는 경우를, false이면 패배하는 경우를 나타냅니다.

0부터 n까지 모든 경우에 대해 앨리스가 이기는 경우만 체크해나가면 됩니다.

0에서 n사이 i개의 돌이 남았을 때 앨리스가 이기기 위해서는 제곱수를 뺐을 때 상대가 마지막으로 돌을 제거할 수 없을만큼의 돌을 남기면 됩니다.

```java
class Solution {

  public boolean winnerSquareGame(int n) {
    boolean[] dp = new boolean[n + 1];
    for (int i = 0; i < n + 1; i++) {
      for (int k = 1; k * k <= i; k++) {
        if (!dp[i - k * k]) { 
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }
}
```

위의 알고리즘을 조금 더 최적화하면 아래와 같습니다.

이기는 경우는 계속해서 체크할 필요 없으므로 continue로 생략해주고, i에서 시작해서 제곱수만큼 더했을 때 n보다 작을 경우에 대해 미리 계산해주면 반복을 줄일 수 있습니다.

```java
package io.lcalmsky.leetcode.stone_game_iv;

public class Solution {

  public boolean winnerSquareGame(int n) {
    boolean[] dp = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      if (dp[i]) {
        continue;
      }
      for (int k = 1; i + k * k <= n; k++) {
        dp[i + k * k] = true;
      }
    }
    return dp[n];
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.stone_game_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, true),
        () -> test(2, false),
        () -> test(4, true),
        () -> test(8, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.winnerSquareGame(given);
    // then
    assertEquals(expected, actual);
  }
}
```
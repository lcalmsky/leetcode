> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/domino_and_tromino_tiling/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/domino-and-tromino-tiling/) 있습니다.

## Problem

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

![](https://assets.leetcode.com/uploads/2021/07/15/lc-domino.jpg)

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/07/15/lc-domino1.jpg)

```text
Input: n = 3
Output: 5
Explanation: The five different ways are show above.
```

**Example 2:**

```text
Input: n = 1
Output: 1
```

**Constraints:**

* 1 <= n <= 1000

## Solution

두 개의 타일 모양이 존재할 때 2 * n 보드를 채울 수 있는 경우의 수를 반환하는 문제입니다.

전형적인 DP 문제로 점화식을 잘 세우면 간단히 풀 수 있습니다.

점화식을 세울 때 주의할 점은 서로 영향을 주는 두 가지 경우에 대해 생각해야 한다는 점인데요, n이 1씩 늘어날 때 상황을 생각해보면, 특정 순간부터는 이전 결과값을 응용할 수 있게 됩니다.

예를 들어,

```text
n = 1: 1
|
|
```

```text
n = 2: 2
|| --
|| --
```

```text
n = 3: 5
||| |-- --| --| |--
||| |-- --| |-- --|
```

> 그림을 그리기 귀찮아서 문자열로 표기했는데 보기가 어렵네요. example1의 그림을 참고하시면 됩니다.

이렇게 n이 3일 때 부터는 n이 1인 경우, n이 2인 경우와 조합되어 경우의 수를 계산하게 됩니다.

여기서 규칙을 찾아보면 n이 2인 경우에서 앞뒤로 세로 domino 타일을 붙인 경우(dp[n-1] + 2)와 n이 1인 경우에서 가로 domino 타일 두 개를 붙인 경우(dp[n - 2])에 기존 타일을 활용하지 않고 새로 만든 경우 2가지가 포함됩니다.

기존 타일을 활용하지 않는 경우도 따로 계산을 해줘야 하는데 기존 타일을 활용하면서 추가한 경우와 기존타일을 활용하지 않은 상태에서 추가한 경우를 계산해주면 됩니다.

이를 점화식으로 나타내면 다음과 같습니다.

```text
dp[i][0] = dp[i - 2][0] + dp[i - 1][0] + 2 * dp[i - 1][1]
dp[i][1] = dp[i - 2][0] + dp[i - 1][1]
```

```java
public class Solution {

  private static final int MODULO = 1000000007;

  public int numTilings(int n) {
    long[][] dp = new long[n + 1][2];
    dp[0][0] = 1;
    dp[1][0] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i][0] = (dp[i - 2][0] + dp[i - 1][0] + 2 * dp[i - 1][1]) % MODULO;
      dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % MODULO;
    }
    return (int) dp[n][0];
  }
}
```

---

문제 제출하는 것을 깜빡했다가 뒤늦게 제출하고 다른 사람들의 답을 확인해봤는데 훨씬 더 간단히 해결한 게 있어서 추가로 첨부합니다.

```java
class Solution {

  private static final int MOD = (int) (1e9 + 7);

  public int numTilings(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 5;
    }
    int a = 1;
    int b = 2;
    int c = 5;
    for (int i = 4; i <= n; i++) {
      int tmp = (2 * c) % MOD + a;
      a = b;
      b = c;
      c = tmp;
      a %= MOD;
      b %= MOD;
      c %= MOD;
    }
    return c;
  }
}
```

설명도 더 알기 쉽게 되어있네요.

dp[i]는 2 * (i + 1) 보드에 타일링하는 방법의 수를 나타내고, dpa[i]는 2 * i 보드에 하나의 정사각형이 추가된 경우 타일링하는 방법의 수를 나타낸다고 하면 아래와 같이 점화식을 세울 수 있습니다.

```text
             i-1
⬜⬜⬜⬜ ⬜⬜⬜⬛
⬜⬜⬜⬜ ⬜⬜⬜⬛
           i-2
⬜⬜⬜⬜ ⬜⬜⬛⬛
⬜⬜⬜⬜ ⬜⬜⬛⬛
           i-1
⬜⬜⬜⬜ ⬜⬜⬜⬛
⬜⬜⬜⬜ ⬜⬜⬛⬛
           i-1
⬜⬜⬜⬜ ⬜⬜⬛⬛
⬜⬜⬜⬜ ⬜⬜⬜⬛
```

```text
               i-1
            ⬜⬜⬜   dpa[i-1]
dpa[i]      ⬜⬜⬛⬛
⬜⬜⬜    /
⬜⬜⬜⬜  \      i-2
            ⬜⬜⬛   dpa[i-2]
            ⬜⬜⬛⬛
```

```text
dpa[i] = dpa[i-1] + dp[i-2] => dpa[i] - dpa[i-1] = dp[i - 2] => dpa[i-1] - dpa[i-2] = dp[i-3]
dp[i] = dp[i-1] + dp[i-2] + 2dpa[i-1]   // (1)
dp[i-1] = dp[i-2] + dp[i-3] + 2dpa[i-2] // (2)

위의 (1)번 식에서 (2)번 식을 빼주면,
dp[i] - dp[i-1] = dp[i-1] + dp[i-2] - dp[i-2] - dp[i-3] + 2(dpa[i-1] - dpa[i-2])
                = dp[i-1] - dp[i-3] + 2dp[i-3]
이 되고 다시 dp[i]를 기준으로 식을 정리하면,
dp[i] = 2dp[i-1] + dp[i-3]
가 됩니다.
```

## Test

```java
package io.lcalmsky.leetcode.domino_and_tromino_tiling;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(3, 5),
        () -> test(1, 1),
        () -> test(30, 312342182)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numTilings(given);
    // then
    assertEquals(expected, actual);
  }
}
```
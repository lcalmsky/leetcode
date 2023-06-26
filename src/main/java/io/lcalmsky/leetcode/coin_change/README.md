> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/coin_change/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/coin-change/) 있습니다.

## Problem

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

**Example 1:**
```text
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

**Example 2:**

```text
Input: coins = [2], amount = 3
Output: -1
```

**Example 3:**

```text
Input: coins = [1], amount = 0
Output: 0
```

**Constraints:**

* 1 <= coins.length <= 12
* 1 <= coins[i] <= 2^31 - 1
* 0 <= amount <= 10^4

## Solution

서로 다른 액면가의 동전을 나타내는 정수 배열과 총 금액을 나타내는 정수가 주어집니다.

해당 금액을 구성하는 데 필요한 가장 적은 수의 동전을 반환하십시오. 동전의 조합으로 그 금액을 만들 수 없는 경우 -1을 반환합니다.

각 종류의 동전이 무한한 수라고 가정합니다.

```java
package io.lcalmsky.leetcode.coin_change;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.coin_change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 5}, 11, 3),
                () -> test(new int[]{2}, 3, -1),
                () -> test(new int[]{1}, 0, 0)
        );
    }

    private void test(int[] coins, int amount, int expected) {
        Solution solution = new Solution();
        int actual = solution.coinChange(coins, amount);
        assertEquals(expected, actual);
    }
}
```
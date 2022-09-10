> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/best_time_to_buy_and_sell_stock_iv/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) 있습니다.

## Problem

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

**Example 1:**
```text
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
```

**Example 2:**
```text
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
```

**Constraints:**

* 0 <= k <= 100
* 0 <= prices.length <= 1000
* 0 <= prices[i] <= 1000

## Solution

주식의 가격 배열과 최대 거래 횟수가 주어질 때 최대 이익을 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_iv;

public class Solution {

  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    if (k >= n / 2) {
      int maxProfit = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          maxProfit += prices[i] - prices[i - 1];
        }
      }
      return maxProfit;
    }
    int[][] dp = new int[k + 1][prices.length];
    for (int i = 1; i <= k; i++) {
      int localMax = -prices[0];
      for (int j = 1; j < prices.length; j++) {
        dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
        localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
      }
    }
    return dp[k][prices.length - 1];
  }
}

```

k가 배열의 길이의 반 이상일 때는 이전 값보다 이후 값이 클 경우 무조건 거래를 했다고 가정하고 그 차이를 모두 더하면 간단히 풀 수 있습니다.

그렇지 않을 때는 dp를 이용해 풀이할 수 있습니다. 

## Test

```java
package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, new int[]{2, 4, 1}, 2),
        () -> test(2, new int[]{3, 2, 6, 5, 0, 3}, 7)
    );
  }

  private void test(int k, int[] prices, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxProfit(k, prices);
    // then
    assertEquals(expected, actual);
  }
}
```
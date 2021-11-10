> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/best_time_to_buy_and_sell_stock_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://github.com/Grace1003/LeetCode/blob/master/122%20Best%20Time%20to%20Buy%20and%20Sell%20Stock%20II.java) 있습니다.

## Problem

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

**Example 1:**

```text
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
```

**Example 2:**

```text
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
```

**Example 3:**

```text
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
```

**Constraints:**

* 1 <= prices.length <= 3 * 10^4
* 0 <= prices[i] <= 10^4

## Solution

주식의 가격이 배열로 주어질 때 언제 사서 언제 팔아야 최대의 이익을 낼 수 있는지 방법을 찾아 그 때 낼 수 있는 최대 이익을 반환하는 문제입니다.

배열을 순차적으로 탐색하면서 이전 값 보다 현재 값이 큰 경우 판매했다고 가정하고 수익을 올려주면 됩니다.

즉, 값이 떨어졌을 때 사고 오르는 순간마다 팔면 된다는 뜻인데 기다렸다가 더 오른 뒤 파는 것과 그 시점에 팔았다가 다시 산 뒤 다시 파는 것과 동일하게 취급되기 때문입니다. (실제로는 수수료가 들겠지요!)

```java
public class Solution {

  public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{7, 1, 5, 3, 6, 4}, 7),
        () -> test(new int[]{1, 2, 3, 4, 5}, 4),
        () -> test(new int[]{7, 6, 4, 3, 1}, 0)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxProfit(given);
    // then
    assertEquals(expected, actual);
  }
}
```
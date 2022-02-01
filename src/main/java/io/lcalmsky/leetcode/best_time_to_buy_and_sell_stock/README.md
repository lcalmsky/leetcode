> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/best_time_to_buy_and_sell_stock/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) 있습니다.

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

**Example 1:**
```text
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```
**Example 2:**
```text
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

**Constraints:**

* 1 <= prices.length <= 10^5
* 0 <= prices[i] <= 10^4

## Solution

주식의 i번 째 날의 가격이 배열로 주어지고, 딱 한 번 사고 팔 수 있을 때 최대 수익을 구하는 문재입니다.

```java
public class Solution {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int min = prices[0]; // (1) 
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      max = Math.max(max, prices[i] - min); // (2)
      min = Math.min(min, prices[i]); // (3)
    }
    return max;
  }
}
```

1. 최솟 값의 기준을 첫 번째 값으로 설정합니다.
2. 다음 값부터 비교하면서 현재 값에서 최솟값을 뺀 값의 최대 값을 구합니다.
3. 순차적으로 비교하며 최솟값을 갱신합니다.

## Test

```java
package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindMaxProfit_thenCorrect() {
    assertAll(
        () -> test(new int[]{7, 1, 5, 3, 6, 4}, 5),
        () -> test(new int[]{7, 6, 4, 3, 1}, 0),
        () -> test(new int[]{2, 1, 4}, 3),
        () -> test(new int[]{1, 4, 2}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution bestTimeToBuyAndSellStock = new Solution();
    int actual = bestTimeToBuyAndSellStock.maxProfit(given);
    // then
    assertEquals(expected, actual);
  }
}
```
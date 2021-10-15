> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/best_time_to_buy_and_sell_stock_with_cooldown/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) 있습니다.

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one
share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day). Note: You may not engage in
multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

**Example 1:**

```text
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
```

**Example 2:**

```text
Input: prices = [1]
Output: 0
```

**Constraints:**

* 1 <= prices.length <= 5000
* 0 <= prices[i] <= 1000

## Solution

주식의 날짜별 가격이 배열ㄹ로 주어질 때 최대 이윤을 반환하는 문제입니다.

주식을 사고, 팔고, 휴식을 할 수 있는데 팔았을 경우 다음 날은 주식을 구매할 수 없습니다.

주식을 샀을 때와 팔았을 때의 변수와, 그 변수들의 이전 값들을 각각 선언하여 DP 방식으로 풀 수 있습니다.

```java
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0, previousSell = 0, buy = Integer.MIN_VALUE, previousBuy;
        for (int price : prices) {
            previousBuy = buy; // (1)
            buy = Math.max(previousSell - price, previousBuy); // (2) 
            previousSell = sell; // (3)
            sell = Math.max(previousBuy + price, previousSell); // (4)
        }
        return sell;
    }
}
```

1. 이전 구매 내역에 마지막 구매 내역을 저장합니다.
2. 이전에 팔고 현재 구매한 경우와, 이전에 구매한 경우를 비교해 더 높은 값을 저장합니다.
3. 이전 판매 내역에 마지막 판매 내역을 저장합니다.
4. 이전에 사고 현재 판 경우와 이전에 팔고 휴식한 경우를 비교해 더 높은 값을 저장합니다.

## Test

```java
package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenArray_whenBuyAndSellStockWithCooldown_thenGetMaximumProfit() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 0, 2}, 3),
                () -> test(new int[]{1}, 0)
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
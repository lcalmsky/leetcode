> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/richest_customer_wealth/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/richest-customer-wealth/) 있습니다.

## Problem

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.


**Example 1:**
```text
Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
```

**Example 2:**
```text
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation:
1st customer has wealth = 6
2nd customer has wealth = 10
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
```

**Example 3:**
```text
Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17
```

**Constraints:**

* m == accounts.length
* n == accounts[i].length
* 1 <= m, n <= 50
* 1 <= accounts[i][j] <= 100

## Solution

고객의 계좌정보가 이중 배열로 주어질 때 가장 부유한 고객의 자산을 반환하는 문제입니다.

```java
public class Solution {
  public int maximumWealth(int[][] accounts) {
    int max = -1, sum;
    for (int[] account : accounts) {
      sum = 0;
      for (int wealth : account) {
        sum += wealth;
      }
      max = Math.max(max, sum);
    }
    return max;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.richest_customer_wealth;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 2, 3}, {3, 2, 1}}, 6),
        () -> test(new int[][]{{1, 5}, {7, 3}, {3, 5}}, 10),
        () -> test(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maximumWealth(given);
    // then
    assertEquals(expected, actual);
  }
}
```
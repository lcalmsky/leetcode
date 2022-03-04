> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/champagne_tower/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/champagne-tower/) 있습니다.

## Problem

We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.

Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)

For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/09/tower.png)

Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)


**Example 1:**
```text
Input: poured = 1, query_row = 1, query_glass = 1
Output: 0.00000
Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
```
**Example 2:**
```text
Input: poured = 2, query_row = 1, query_glass = 1
Output: 0.50000
Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
```
**Example 3:**
```text
Input: poured = 100000009, query_row = 33, query_glass = 17
Output: 1.00000
```

Constraints:

* 0 <= poured <= 10^9
* 0 <= query_glass <= query_row < 100

## Solution

유리잔을 피라미드 모양으로 쌓는데 첫 번째 행은 한 개, 두 번째 행은 두 개 이런식으로 100번째 행까지 쌓고 각 유리잔은 샴페인을 담을 수 있습니다.

샴페인은 맨 윗 잔부터 따르고 첫 잔이 가득 차면 첫 잔에 샴페인이 넘치면서 아래있는 잔이 차게되는데 윗 잔을 기준으로 양쪽에 있는 아랫잔이 동일하게 채워집니다. 맨 아랫잔이 가득 찼을 경우 샴페인은 바닥에 떨어지게 됩니다.

부을 샴페인의 잔 수와 유리잔이 위치하는 행과 열이 주어질 때 해당 잔에 존재하는 샴페인의 양을 구하는 문제입니다.

DP를 이용해 문제를 해결할 수 있습니다.

```java
public class Solution {

  public double champagneTower(int poured, int queryRow, int queryGlass) {
    double[][] dp = new double[101][101]; // (1)
    dp[0][0] = poured; // (2)
    for (int i = 0; i < 100; i++) { // (3)
      for (int j = 0; j <= i; j++) { // (4)
        if (dp[i][j] > 1) { // (5)
          double spilledOver = dp[i][j] - 1; // (6)
          dp[i][j] = 1; // (7)
          dp[i + 1][j] += 0.5 * spilledOver; // (8)
          dp[i + 1][j + 1] += 0.5 * spilledOver; // (9)
        }
      }
    }
    return dp[queryRow][queryGlass]; // (10)
  }
}
```

1. 100개의 행으로 구성되고 초기값을 제외하고 인덱스 1부터 계산을 시작하기위해 100+1 배열을 선언하였습니다.
2. 초기값을 설정합니다.
3. 100개의 행을 순차적으로 탐색합니다.
4. 각 행의 잔의 개수는 행과 동일하므로 잔을 탐색하기 위해선 행보다 작거나 같아야 합니다.
5. 현재 잔이 꽉 차서 넘치는 경우
6. 넘친 양을 계산하고
7. 현재 잔은 꽉 차있다고 표기합니다.
8. 현재 잔 기준 아래 행의 왼쪽 잔을 계산합니다.
9. 현재 잔 기준 아래 행의 오른쪽 잔을 계산합니다.
10. 문제에 주어진 행의 잔에 담긴 샴페인 양을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.champagne_tower;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, 1, 1, 0d),
        () -> test(2, 1, 1, 0.5d),
        () -> test(100000009, 33, 17, 1d)
    );
  }

  private void test(int poured, int queryRow, int queryGlass, double expected) {
    // when
    Solution solution = new Solution();
    double actual = solution.champagneTower(poured, queryRow, queryGlass);
    // then
    assertEquals(expected, actual);
  }
}
```
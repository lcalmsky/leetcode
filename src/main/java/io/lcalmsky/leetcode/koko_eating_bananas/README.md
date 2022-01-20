> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/koko_eating_bananas/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/koko-eating-bananas/) 있습니다.

## Problem

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

**Example 1:**
```text
Input: piles = [3,6,7,11], h = 8
Output: 4
```
**Example 2:**
```text
Input: piles = [30,11,23,4,20], h = 5
Output: 30
```
**Example 3:**
```text
Input: piles = [30,11,23,4,20], h = 6
Output: 23
```

**Constraints:**

* 1 <= piles.length <= 10^4
* piles.length <= h <= 10^9
* 1 <= piles[i] <= 10^9

## Solution

n개의 바나나 더미를 나타내는 배열이 주어지고 i번째 해당하는 수는 바나나 더미의 갯수를 의미합니다.

코코는 시간당 바나나 먹는 속도 k를 가지고, 매시간 바나나 더미를 선택한 뒤 k개의 바나나를 먹습니다.

더미에 k개 미만의 바나나가 존재할 경우 바나나를 다 먹고 더 이상 먹을 수 없습니다.

경비원이 돌아오기 전에 바나나를 먹어야 할 때 h시간 내에 모든 바나나를 먹을 수 있는 최소 정수 k를 반환하는 문제입니다.

```java
public class Solution {

  public int minEatingSpeed(int[] piles, int h) {
    int low = 1;
    int max = 1;
    for (int pile : piles) { // (1)
      max = Math.max(pile, max);
    }
    while (low < max) {
      int mid = (max - low) / 2 + low; // (2)
      int current = 0;
      for (int pile : piles) { // (3)
        current += (pile % mid == 0) ? pile / mid : pile / mid + 1;
      }
      if (current > h) { // (4)
        low = mid + 1;
      } else { // (5)
        max = mid;
      }
    }
    return low; // (6)
  }
}
```

1. 더미 갯수중 최댓값을 구합니다.
2. 최소 갯수와 최대 갯수의 중간 값을 구합니다.
3. 중간 값이 한 시간당 먹을 수 있는 바나나 갯수라고 가정하고 각 더미의 바나나를 다 먹는데 걸리는 시간을 계산합니다.
4. 다 먹는데 걸리는 시간이 주어진 h보다 크다면 중간값 보다 1 큰 값을 최소 갯수로 설정합니다.
5. 다 먹는데 걸리는 시간이 주어진 h보다 작다면 중간값을 최대 갯수로 설정합니다.
6. 2~5 과정을 반복했을 때 구해지는 값이 구하고자 하는 k의 최솟값입니다.

## Test

```java
package io.lcalmsky.leetcode.koko_eating_bananas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 6, 7, 11}, 8, 4),
        () -> test(new int[]{30, 11, 23, 4, 20}, 5, 30),
        () -> test(new int[]{30, 11, 23, 4, 20}, 6, 23)
    );
  }

  private void test(int[] piles, int h, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minEatingSpeed(piles, h);
    // then
    assertEquals(expected, actual);
  }
}
```
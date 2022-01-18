> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/can_place_flowers/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/can-place-flowers/) 있습니다.

## Problem

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

**Example 1:**
```text
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
```
**Example 2:**
```text
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
```

**Constraints:**

* 1 <= flowerbed.length <= 2 * 10^4
* flowerbed[i] is 0 or 1.
* There are no two adjacent flowers in flowerbed.
* 0 <= n <= flowerbed.length

## Solution

심어야 할 꽃의 수 n과 긴 화분이 0과 1로 구성된 정수 배열로 주어지는데 0은 비어있음을 나타내고 1은 꽃이 심어져있음을 나타냅니다.

빈 곳에만 꽃을 심을 수 있는데 다른 꽃과 인접해서 심을 수 없을 때 꽃을 심을 수 있는지 여부를 반환하는 문제입니다.

```java
public class Solution {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed == null || flowerbed.length == 0) {
      return false;
    }
    int count = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0 && // (1)
          (i == 0 || flowerbed[i - 1] == 0) &&
          (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        count++; // (2)
      }
      if (count >= n) { // (3)
        return true;
      }
    }

    return false;
  }
}

```

1. 화분의 현재 위치와 바로 앞, 바로 뒤에 꽃이 심어져있지 않을 때 꽃을 심습니다.
2. 꽃을 심은 갯수를 증가시킵니다.
3. 꽃을 n송이 이상 심었을 때 true를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.can_place_flowers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenFlowerbedAndNumberOfNewFlowers_whenPlaceNewFlowerWithoutAdjacent_thenCorrect() {
    // then
    assertAll(
        () -> assertTrue(test(new int[]{1, 0, 0, 0, 1}, 1)),
        () -> assertFalse(test(new int[]{1, 0, 0, 0, 1}, 2))
    );
  }

  private boolean test(int[] given, int n) {
    // when
    Solution solution = new Solution();
    return solution.canPlaceFlowers(given, n);
  }
}
```
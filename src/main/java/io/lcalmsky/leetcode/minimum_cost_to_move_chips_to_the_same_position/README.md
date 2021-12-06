> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_cost_to_move_chips_to_the_same_position/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/) 있습니다.

## Problem

We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

* position[i] + 2 or position[i] - 2 with cost = 0.
* position[i] + 1 or position[i] - 1 with cost = 1.

* Return the minimum cost needed to move all the chips to the same position.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/08/15/chips_e1.jpg)

```text
Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/08/15/chip_e2.jpg)

```text
Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
```

**Example 3:**

```text
Input: position = [1,1000000000]
Output: 1
```

**Constraints:**

* 1 <= position.length <= 100
* 1 <= position[i] <= 10^9

## Solution

각 위치에 칩들이 주어지고 칩들을 한 곳으로 모아야 하는데, 이 때 좌우로 두 칸을 이동시키는데는 cost가 소모되지 않고 한 칸을 이동시킬 때는 cost가 1이 소모됩니다.

모든 칩들을 한 곳에 위치시킬 때 소모되는 최소 cost 값을 구하는 문제입니다.

문제를 보자마자 DP를 떠올릴 수 있는데요, 이 문제는 그냥 머리로 푸는 게 훨씬 쉽습니다.

짝수와 홀수에 각각 위치한 칩들의 갯수를 샌 뒤 둘 중 더 적은 값을 반환하면 됩니다.

그 이유는 두 칸을 움직일 때는 cost가 소모되지 않으므로 홀, 짝 한 칸에 모든 수를 모을 수 있고, 그 이후 더 적은 쪽이 더 많은 쪽으로 한 칸 이동하면 되기 때문입니다.

```java
public class Solution {

  public int minCostToMoveChips(int[] position) {
    int numberOfEven = 0, numberOfOdd = 0;
    for (int value : position) {
      if (value % 2 == 0) {
        numberOfEven++;
      } else {
        numberOfOdd++;
      }
    }
    return Math.min(numberOfEven, numberOfOdd);
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.minimum_cost_to_move_chips_to_the_same_position;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, 1),
        () -> test(new int[]{2, 2, 2, 3, 3}, 2),
        () -> test(new int[]{1, 100000000}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minCostToMoveChips(given);
    // then
    assertEquals(expected, actual);
  }
}
```
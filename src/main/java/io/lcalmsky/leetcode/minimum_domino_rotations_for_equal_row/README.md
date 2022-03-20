> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_domino_rotations_for_equal_row/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/) 있습니다.

## Problem

In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.


**Example 1:**
```text
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation:
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
```
**Example 2:**
```text
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation:
In this case, it is not possible to rotate the dominoes to make one row of values equal.
```

**Constraints:**

* 2 <= tops.length <= 2 * 10^4
* bottoms.length == tops.length
* 1 <= tops[i], bottoms[i] <= 6

## Solution

한 줄의 도미노가 위쪽과 아래쪽으로 나타낼 수 있는데 각각이 6개이고 1~6사이의 숫자로 구성되어있습니다.

위, 아래 도미노를 swap하여 위쪽 도미노가 모두 같은 수가 되도록 swap하는 횟수를 반환하는 문제입니다.

불가능하다면 -1을 반환해야 합니다.

```java
public class Solution {

  public int minDominoRotations(int[] tops, int[] bottoms) {
    for (int i = 1; i <= 6; i++) {
      int result = check(tops, bottoms, i);
      if (result != -1) {
        return result;
      }
    }
    return -1;
  }

  private int check(int[] tops, int[] bottoms, int number) {
    int countTop = 0, countBottom = 0;
    for (int i = 0; i < tops.length; i++) {
      if (tops[i] != number && bottoms[i] != number) {
        return -1;
      }
      if (tops[i] != number) {
        countTop++;
      } else if (bottoms[i] != number) {
        countBottom++;
      }
    }
    return Math.min(countTop, countBottom);
  }
}

```

1부터 6까지 수로 이루어져있으므로 각각의 수에 대해 tops와 bottoms에 하나도 일치하는 것이 없을 경우엔 그 수로 한 쪽을 채울 수 없다는 뜻이므로 -1을 반환합니다.

순차적으로 탐색하면서 swap이 필요한 횟수를 각각 카운팅하여 더 적은 수를 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.minimum_domino_rotations_for_equal_row;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}, 2),
        () -> test(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}, -1)
    );
  }

  private void test(int[] tops, int[] bottoms, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minDominoRotations(tops, bottoms);
    // then
    assertEquals(expected, actual);
  }
}
```
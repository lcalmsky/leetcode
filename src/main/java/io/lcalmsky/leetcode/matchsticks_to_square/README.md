> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/matchsticks_to_square/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/matchsticks-to-square/) 있습니다.

## Problem

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/04/09/matchsticks1-grid.jpg)

```text
Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
```

**Example 2:**

```text
Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
```

**Constraints:**

* 1 <= matchsticks.length <= 15
* 1 <= matchsticks[i] <= 10^8

## Solution

성냥개비의 길이가 배열로 주어지는데 주어진 성냥개비로 정사각형을 만들 수 있는지 여부를 반환하는 문제입니다.

일단 총 합이 4로 나누어 떨어져야 하고, 4로 나눈 몫이 한 변의 길이가 되며, 배열의 숫자들을 이용해 한 변의 길이를 각각 만들어가야 합니다.

앞에서 예외 케이스들을 걸러낸 뒤 dfs를 이용해 풀이할 수 있습니다.

```java
package io.lcalmsky.leetcode.matchsticks_to_square;

import java.util.Arrays;

public class Solution {

  public boolean makesquare(int[] nums) {
    if (nums.length == 0) {
      return false;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 4 != 0) {
      return false;
    }
    Arrays.sort(nums);
    return dfs(nums, nums.length - 1, sum / 4, new int[4]);
  }

  private boolean dfs(int[] nums, int index, int side, int[] sides) {
    if (index < 0) {
      return sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side;
    }
    for (int i = 0; i < sides.length; i++) {
      if (sides[i] + nums[index] > side) {
        continue;
      }
      sides[i] += nums[index];
      if (dfs(nums, index - 1, side, sides)) {
        return true;
      }
      sides[i] -= nums[index];
    }
    return false;
  }
}

```

dfs 메서드에서 

## Test

```java
package io.lcalmsky.leetcode.matchsticks_to_square;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 2, 2, 2}, Assertions::assertTrue),
        () -> test(new int[]{3, 3, 3, 3, 4}, Assertions::assertFalse)
    );
  }

  private void test(int[] given, Consumer<Boolean> consumer) {
    Solution solution = new Solution();
    boolean actual = solution.makesquare(given);
    consumer.accept(actual);
  }
}
```
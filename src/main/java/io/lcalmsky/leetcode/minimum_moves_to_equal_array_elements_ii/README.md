> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_moves_to_equal_array_elements_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/) 있습니다.

## Problem

Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer.

**Example 1:**
```text
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
```

**Example 2:**
```text
Input: nums = [1,10,2,9]
Output: 16
```

**Constraints:**

* n == nums.length
* 1 <= nums.length <= 10^5
* -10^9 <= nums[i] <= 10^9

## Solution

n개의 정수로 이루어진 배열 nums가 주어질 때 모든 배열이 동일한 값이 되게 하는 최소한의 moves를 구하는 문제입니다.

한 move당 배열의 한 원소의 값을 1 더하거나 1 뺄 수 있습니다.

단순하게 생각하면 평균 값을 구한 뒤 모든 배열의 숫자를 평균 값에 맞게 이동시키는 것을 생각할 수 있는데요, 배열의 원소들 중 중간값으로 이동시키는 것이 최소 이동을 보장합니다.

예를 들어 배열이 [1, 1, 100] 일 때 평균을 내면 34.xxx가 나오는데 1을 34로 이동시키는데 33 moves가 소모되므로, 33 + 33 + 67의 moves가 소모되는데 반해, 중간 값인 1을 기준으로 이동시킨다면 100만 1로 이동시켜서 99의 moves만 소모됩니다.

중간 값이 평균인 경우는 어차피 moves가 동일할 것이기 때문에 고려할 필요가 없습니다.

```java
package io.lcalmsky.leetcode.minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;

public class Solution {

  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int mid = nums[nums.length / 2]; // 중간 값을 구함
    int sum = 0;
    for (int i : nums) {
      sum += Math.abs(i - mid); // 중간 값과의 차이를 구해서 더함
    }
    return sum;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.minimum_moves_to_equal_array_elements_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenFindMinimumMovesToEqualsArrayElements_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, 2),
        () -> test(new int[]{1, 10, 2, 9}, 16)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution minimumMovesToEqualsArrayElements2 = new Solution();
    int actual = minimumMovesToEqualsArrayElements2.minMoves2(given);

    // then
    assertEquals(expected, actual);
  }
}
```
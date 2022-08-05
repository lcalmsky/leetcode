> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/combination_sum_iv/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/combination-sum-iv/) 있습니다.

## Problem

Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

**Example 1:**
```text
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
```

**Example 2:**
```text
Input: nums = [9], target = 3
Output: 0
```

**Constraints:**

* 1 <= nums.length <= 200
* 1 <= nums[i] <= 1000
* All the elements of nums are unique.
* 1 <= target <= 1000

**Follow up**: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?

## Solution

중복되지 않은 정수 배열과 타겟 정수가 주어질 때 더해서 타겟 정수가 되는 모든 조합의 개수를 구하는 문제입니다.

```java
public class Solution {

  public int combinationSum4(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 0; i < dp.length; i++) {
      for (int num : nums) {
        if (i + num <= target) {
          dp[i + num] += dp[i];
        }
      }
    }
    return dp[target];
  }
}
```

dp를 이용해 간단히 풀이할 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.combination_sum_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNumbers_whenFindCombination_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, 4, 7)
    );
  }

  private void test(int[] given, int target, int expected) {
    // when
    Solution combinationSum4 = new Solution();
    int actual = combinationSum4.combinationSum4(given, target);

    // then
    assertEquals(expected, actual);
  }
}
```
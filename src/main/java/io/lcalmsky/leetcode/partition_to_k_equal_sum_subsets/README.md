> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/partition_to_k_equal_sum_subsets/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3993/) 있습니다.

## Problem

Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

**Example 1:**

```text
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
```

**Example 2:**

```text
Input: nums = [1,2,3,4], k = 3
Output: false
```

**Constraints:**

* 1 <= k <= nums.length <= 16
* 1 <= nums[i] <= 10^4
* The frequency of each element is in the range [1, 4].

## Solution

주어진 배열을 비어있지 않은 K개의 부분 배열로 나눌 때 각 부분 배열의 합이 동일하게 나눌 수 있는지 확인하는 문제입니다.

먼저 동일하게 나눌 수 없는 조건을 확인하려면 배열의 원소들을 모두 합한 값이 K로 나누어 떨어져야 합니다.

K로 나누어 떨어지는 경우 값이 모두 같아야 하기 때문에 합 / K가 목표하는 값이 됩니다.

이 목표하는 값을 부분 배열의 원소들을 더해서 만족시킬 수 있는지, 그리고 그 부분 배열의 갯수가 K개가 나오는지는 DFS (Depth First Search) 알고리즘을 이용해 구할 수 있습니다.

```java
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        return dfs(nums, 0, 0, 0, sum / k, k, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int index, int sum, int count, int target, int k, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (sum == target && count > 0) {
            return dfs(nums, 0, 0, 0, target, k - 1, visited);
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, i + 1, sum + nums[i], count + 1, target, k, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
```

> DFS 관련해서는 저도 매번 헷갈려서 하루 날잡고 정리할 예정입니다.

## Test

```java
package io.lcalmsky.leetcode.partition_to_k_equal_sum_subsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPositiveNumbersAndK_whenCheckWhetherItsPossibleToDivideIntoSubsetsWithEqualSum_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 3, 5, 2, 1}, 4, true),
                () -> test(new int[]{1, 2, 3, 4}, 3, false)
        );
    }

    private void test(int[] nums, int k, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.canPartitionKSubsets(nums, k);

        // then
        assertEquals(expected, actual);
    }
}
```
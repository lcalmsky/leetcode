> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_arithmetic_subsequence/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-arithmetic-subsequence/) 있습니다.

## Problem

Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Note that:

* A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
* A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

**Example 1:**

```text
Input: nums = [3,6,9,12]
Output: 4
Explanation:  The whole array is an arithmetic sequence with steps of length = 3.
```

**Example 2:**

```text
Input: nums = [9,4,7,2,10]
Output: 3
Explanation:  The longest arithmetic subsequence is [4,7,10].
```

**Example 3:**

```text
Input: nums = [20,1,15,3,10,5,8]
Output: 4
Explanation:  The longest arithmetic subsequence is [20,15,10,5].
```

**Constraints:**

* 2 <= nums.length <= 1000
* 0 <= nums[i] <= 500

## Solution

정수 배열이 주어질 때, 가장 긴 등차 수열의 길이를 반환합니다.

* 서브시퀀스는 다른 배열에서 일부를 삭제하거나 또는 남은 요소의 순서를 변경하지 않고 파생될 수 있는 배열입니다.
* 시퀀스 seq는 등차 수열이라면 seq[i + 1] - seq[i]가 모두 동일한 값을 갖습니다 (0 <= i < seq.length - 1).

```java
package io.lcalmsky.leetcode.longest_arithmetic_subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        int maxLength = 0;

        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int length = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, length);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}

```

단순히 정렬 후 인접한 수의 차이를 구해 길이를 구하게되면 문제의 함정에 빠지게 됩니다.

subsequence의 특징을 잘 고려해 인접하지 않은 원소간의 차이끼리도 등차수열일 수 있기 때문에 하나의 원소와 나머지 원소간의 차이를 카운트하고, 다음 원소와 나머지 원소간의 차이를 반복하여 구해야 합니다.

## Test

```java
package io.lcalmsky.leetcode.longest_arithmetic_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        assertAll(
                () -> test(new int[]{3, 6, 9, 12}, 4),
                () -> test(new int[]{9, 4, 7, 2, 10}, 3),
                () -> test(new int[]{20, 1, 15, 3, 10, 5, 8}, 4)
        );
    }

    private void test(int[] nums, int expected) {
        Solution solution = new Solution();
        int actual = solution.longestArithSeqLength(nums);
        assertEquals(expected, actual);
    }
}
```
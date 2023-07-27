> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_average_subarray_i/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-average-subarray-i/) 있습니다.

## Problem

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

**Example 1:**
```text
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
```

**Example 2:**
```text
Input: nums = [5], k = 1
Output: 5.00000
```

**Constraints:**

* n == nums.length
* 1 <= k <= n <= 10^5
* -10^4 <= nums[i] <= 10^4

## Solution

```java
package io.lcalmsky.leetcode.maximum_average_subarray_i;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -10001;
        double localMax = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax += nums[i];
            if (i - k >= -1) {
                maxAverage = Math.max(maxAverage, localMax / k);
                localMax -= nums[i - k + 1];
            }
        }
        return maxAverage;
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.maximum_average_subarray_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75000),
                () -> test(new int[]{5}, 1, 5.00000)
        );
    }

    private void test(int[] nums, int k, double expected) {
        // when
        Solution solution = new Solution();
        double actual = solution.findMaxAverage(nums, k);
        // then
        assertEquals(expected, actual);
    }

}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/increasing_triplet_subsequence/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/increasing-triplet-subsequence/) 있습니다.

## Problem

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

**Example 1:**
```text
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
```

**Example 2:**
```text
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
```

**Example 3:**
```text
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
```

**Constraints:**

* 1 <= nums.length <= 5 * 10^5
* -2^31 <= nums[i] <= 2^31 - 1

**Follow up:** Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?

## Solution

정수 배열 nums가 주어질 때, nums[i] < nums[j] < nums[k]를 만족하는 세 개의 인덱스 i, j, k가 존재하면 true, 그렇지 않으면 false를 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.increasing_triplet_subsequence;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
```

배열을 순차적으로 탐색하면서 가장 작은 수를 min, 가장 작은 수 보다 큰 수를 mid에 저장하고나면 그 수보다 큰 수가 존재할 때 true, 존재하지 않으면 false를 반환하게 됩니다.

## Test

```java
package io.lcalmsky.leetcode.increasing_triplet_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4, 5}, true),
                () -> test(new int[]{5, 4, 3, 2, 1}, false),
                () -> test(new int[]{2, 1, 5, 0, 4, 6}, true)
        );
    }

    private void test(int[] nums, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.increasingTriplet(nums);
        assertEquals(expected, actual);
    }

}
```
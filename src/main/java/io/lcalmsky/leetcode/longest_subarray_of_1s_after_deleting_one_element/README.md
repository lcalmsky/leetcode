> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_subarray_of_1s_after_deleting_one_element/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/) 있습니다.

## Problem

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

**Example 1:**

```text
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
```

**Example 2:**

```text
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
```

**Example 3:**

```text
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
```

**Constraints:**

* 1 <= nums.length <= 10^5
* nums[i] is either 0 or 1.

## Solution

0과 1로 이루어진 배열에서 하나를 제거해 가장 긴 1로 된 부분 배열의 길이를 구하는 문제입니다.

```java
public class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, zeroes = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroes++;
            }
            end++;
            if (zeroes > 1) {
                if (nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
        }
        return end - start - 1;
    }
}
```

[이전에 다뤘던 문제](https://jaime-note.tistory.com/494)와 매우 유사합니다.

다른 점이 있다면 이전 문제는 k개의 0을 1로 치환할 수 있었던 반면, 이 문제는 1개의 원소를 반드시 삭제해야 합니다.

반대로 얘기하면 0 1개를 치환할 수 있다고 가정하고 결과에서 1을 빼주면(원소를 삭제하기 때문) 원하는 결과를 얻을 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.longest_subarray_of_1s_after_deleting_one_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 1, 0, 1}, 3),
                () -> test(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                () -> test(new int[]{1, 1, 1}, 2)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestSubarray(nums);
        // then
        assertEquals(expected, actual);
    }
}
```
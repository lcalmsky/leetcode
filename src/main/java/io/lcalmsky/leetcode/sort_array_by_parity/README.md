> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sort_array_by_parity/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/sort-array-by-parity/) 있습니다.

## Problem

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

**Example 1:**
```text
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
```
**Example 2:**
```text
Input: nums = [0]
Output: [0]
```

**Constraints:**

* 1 <= nums.length <= 5000
* 0 <= nums[i] <= 5000

## Solution

정수 배열이 주어지면 모든 짝수를 앞으로 이동시키는 문제입니다.

```java
package io.lcalmsky.leetcode.sort_array_by_parity;

public class Solution {

  public int[] sortArrayByParity(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) { // (1)
      if (nums[left] % 2 > nums[right] % 2) { // (2)
        swap(nums, left, right);
      }
      if (nums[left] % 2 == 0) { // (3)
        left++;
      }
      if (nums[right] % 2 == 1) { // (4)
        right--;
      }
    }
    return nums;
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}
```

1. 배열의 양 끝에 두 개의 포인터를 이동시키면서
2. 앞쪽이 홀수인 경우 두 개를 swap 합니다.
3. swap 후에 앞쪽이 짝수인 경우 포인터를 이동시킵니다.
4. swap 후에 뒷쪽이 홀수인 경우 포인터를 이동시킵니다.

## Test

```java
package io.lcalmsky.leetcode.sort_array_by_parity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 1, 2, 4}, new int[]{4, 2, 1, 3}),
        () -> test(new int[]{0}, new int[]{0})
    );
  }

  private void test(int[] given, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.sortArrayByParity(given);
    // then
    assertArrayEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/arithmetic_slices/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/arithmetic-slices/) 있습니다.

## Problem

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

**Example 1:**
```text
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
```

**Example 2:**
```text
Input: nums = [1]
Output: 0
```

**Constraints:**

* 1 <= nums.length <= 5000
* -1000 <= nums[i] <= 1000

## Solution

정수 배열이 3개 이상의 요소로 구성되고 연속되는 두 요소의 차이가 동일한 경우 `arithmetic` 이라고 부릅니다.

정수 배열이 주어질 때 arithmetic 부분 배열의 개수를 구하는 문제입니다.

부분 배열은 주어진 배열의 연속된 시퀀스로 구성됩니다.

부분 배열의 개수를 구하는 원리를 생각하면 매우 간단히 해결되는 문제입니다.

[1, 2, 3, 4, 5]로 구성된 배열이 있다고 가정하면,

```text
[1, 2, 3]
[2, 3, 4]
[3, 4, 5]
[1, 2, 3, 4]
[2, 3, 4, 5]
[1, 2, 3, 4, 5]
```

이렇게 원소가 세 개일 때 3개, 네 개일 때 2개, 다섯 개일 때 1개 총 6개의 arithmetic 부분 배열을 구할 수 있고, 연속된 부분 배열이 존재한다면 부분 배열의 개수가 1씩 증가하는 것을 의미합니다.

```java
public class Solution {

  public int numberOfArithmeticSlices(int[] A) {
    int current = 0, sum = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        current += 1;
        sum += current;
      } else {
        current = 0;
      }
    }
    return sum;
  }
}
```



## Test

```java
package io.lcalmsky.leetcode.arithmetic_slices;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenSplit_thenArithmeticSlices() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numberOfArithmeticSlices(given);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/missing_number/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/missing-number/) 있습니다.

## Problem

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

**Example 1:**
```text
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```
**Example 2:**
```text
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
```
**Example 3:**
```text
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
```

**Constraints:**

* n == nums.length
* 1 <= n <= 10^4
* 0 <= nums[i] <= n
* All the numbers of nums are unique.


**Follow up**: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

## Solution

n개의 숫자로 이루어진 배열이 주어질 때 0부터 n까지 범위 중 빠진 숫자를 구하는 문제입니다.

너무 간단한 문제라 여러 가지 방법이 있을 수 있는데 저는 먼저 n까지의 합을 구한 뒤 배열의 숫자들을 빼주는 방식으로 구현하였습니다.

```java
public class Solution {

  public int missingNumber(int[] nums) {
    int numbers = nums.length;
    int sum = numbers * (numbers + 1) / 2;
    for (int num : nums) {
      sum -= num;
    }
    return sum;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.missing_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 0, 1}, 2),
        () -> test(new int[]{0, 1}, 2),
        () -> test(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.missingNumber(given);
    // then
    assertEquals(expected, actual);
  }
}
```
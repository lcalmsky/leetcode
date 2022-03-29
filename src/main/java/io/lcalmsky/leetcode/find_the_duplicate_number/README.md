> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_the_duplicate_number/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-the-duplicate-number/) 있습니다.

## Problem

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

**Example 1:**
```text
Input: nums = [1,3,4,2,2]
Output: 2
```
**Example 2:**
```text
Input: nums = [3,1,3,4,2]
Output: 3
```

**Constraints:**

* 1 <= n <= 10^5
* nums.length == n + 1
* 1 <= nums[i] <= n
* All the integers in nums appear only once except for precisely one integer which appears two or more times.


**Follow up:**

* How can we prove that at least one duplicate number must exist in nums?
* Can you solve the problem in linear runtime complexity?

## Solution

n + 1개의 정수 배열이 주어지고 정수의 범위는 1~n까지 입니다.

하나의 중복 원소가 존재할 때 해당 원소를 반환하는 문제입니다.

[플로이드의 토끼와 거북이 알고리즘(순환 알고리즘)](https://fierycoding.tistory.com/45)을 이용하면 됩니다.

이 방법은 배열을 해시맵 형태로 사용하는 것과 동일합니다.

해시맵에 값을 저장해나가는데 동일한 값이 저장되는 시점이 중복된 원소를 발견하는 시점이 됩니다.

```java
package io.lcalmsky.leetcode.find_the_duplicate_number;

public class Solution {

  public int findDuplicate(int[] nums) {
    while (nums[0] != nums[nums[0]]) {
      int next = nums[nums[0]];
      nums[nums[0]] = nums[0];
      nums[0] = next;
    }
    return nums[0];
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.find_the_duplicate_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindDuplicates_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 3, 4, 2, 2}, 2),
        () -> test(new int[]{3, 1, 3, 4, 2}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.findDuplicate(given);
    // then
    assertEquals(expected, actual);
  }
}
```
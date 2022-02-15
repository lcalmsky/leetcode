> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/single_number/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/single-number/) 있습니다.

## Problem

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

**Example 1:**
```text
Input: nums = [2,2,1]
Output: 1
```

**Example 2:**
```text
Input: nums = [4,1,2,1,2]
Output: 4
```

**Example 3:**
```text
Input: nums = [1]
Output: 1
```

**Constraints:**

* 1 <= nums.length <= 3 * 10^4
* -3 * 10^4 <= nums[i] <= 3 * 10^4
* Each element in the array appears twice except for one element which appears only once.

## Solution

비어있지 않은 정수배열이 주어지는데 이 배열에서 하나의 원소를 제외하고는 모두 두 번씩 나타날 때 한 번만 나타나는 원소를 구하는 문제입니다.

비트 연산 중 XOR를 이용해 풀 수 있습니다.

```java
public class Solution {

  public int singleNumber(int[] nums) {
    int x = 0;
    for (int num : nums) {
      x ^= num;
    }
    return x;
  }
}
```

초기 값을 0으로 두고 배열의 원소들을 순차적으로 XOR 연산을 취하게 되면 처음엔 배열의 첫 번째 수가 되고 그 이후로는 이진수를 취했을 때 서로 다른 비트일 때만 각 자리의 수가 1이 되므로 아래 처럼 됩니다.

```text
init:
  x = 0
i = 0:
  x = 0 ^ 4
      0000
      0100
      ----
      0100 = 4
i = 1:
  x = 4 ^ 1
      0100
      0001
      ----
      0101 = 5
i = 2:
  x = 5 ^ 2
      0101
      0010
      ----
      0111 = 7
i = 3:
  x = 7 ^ 1
      0111
      0001
      ----
      0110 = 6
i = 4:
  x = 6 ^ 2
      0110
      0010
      ----
      0100 = 4
```

같은 수를 XOR 연산 취하게되면 0이되고, 0과 하나 남은 수를 XOR 연산하게되면 그 수가 되는 원리입니다.

## Test

```java
package io.lcalmsky.leetcode.single_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindUniqueNumber_thenCorrect() {
    assertAll(
        () -> test(new int[]{2, 2, 1}, 1),
        () -> test(new int[]{4, 1, 2, 1, 2}, 4)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution singleNumber = new Solution();
    int actual = singleNumber.singleNumber(given);
    // then
    assertEquals(expected, actual);
  }
}
```
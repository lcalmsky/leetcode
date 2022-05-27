> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/number_of_steps_to_reduce_a_number_to_zero/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/) 있습니다.

## Problem

Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

**Example 1:**
```text
Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.
```

**Example 2:**
```text
Input: num = 8
Output: 4
Explanation:
Step 1) 8 is even; divide by 2 and obtain 4.
Step 2) 4 is even; divide by 2 and obtain 2.
Step 3) 2 is even; divide by 2 and obtain 1.
Step 4) 1 is odd; subtract 1 and obtain 0.
```

**Example 3:**
```text
Input: num = 123
Output: 12
```

**Constraints:**

* 0 <= num <= 10^6

## Solution

정수가 주어질 때 0이 될때까지의 연산 횟수를 반환하는 문제입니다.

2로 나누거나 1을 빼는 것을 한 연산으로 간주합니다.

`easy` 난이도 답게 매우 쉬우므로 소스 코드로 풀이를 대체합니다.

```java
public class Solution {

  public int numberOfSteps(int num) {
    int count = 0;
    while (num != 0) {
      if (num % 2 == 0) {
        num /= 2; // 짝수일 때 2로 나눔
      } else {
        num--; // 홀수일 때 1을 뺌
      }
      count++;
    }
    return count;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.number_of_steps_to_reduce_a_number_to_zero;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(14, 6),
        () -> test(8, 4),
        () -> test(123, 12)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numberOfSteps(given);
    // then
    assertEquals(expected, actual);
  }
}
```
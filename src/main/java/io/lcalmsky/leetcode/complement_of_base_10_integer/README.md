> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/complement_of_base_10_integer/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/complement-of-base-10-integer/) 있습니다.

## Problem

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer n, return its complement.

**Example 1:**

```text
Input: n = 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
```

**Example 2:**

```text
Input: n = 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
```

**Example 3:**

```text
Input: n = 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
```

**Constraints:**

* 0 <= n < 10^9

## Solution

정수 n이 주어졌을 때 그 보수(complement)를 구하는 문제입니다.

워낙 간단한 문제라서 풀이 방법 또한 다양한데 그 중 재밌는 방법을 발견하여 소개합니다.

n과 n의 보수의 합은 반드시 2^x - 1이 된다는 점을 이용한 풀이 입니다.

```java
package io.lcalmsky.leetcode.complement_of_base_10_integer;

public class Solution {

  public int bitwiseComplement(int n) {
    if (n == 0) {
      return 1;
    }
    int scope = 1;
    while (scope <= n) { // n보다 크거나 같아지는 순간의 2의 n 제곱을 구한 뒤
      scope *= 2;
    }
    return scope - n - 1; // n과 1일 빼줍니다.
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.complement_of_base_10_integer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void bitwiseComplement() {
    assertAll(
        () -> test(5, 2),
        () -> test(7, 0),
        () -> test(10, 5)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.bitwiseComplement(given);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/power_of_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/power-of-tree/) 있습니다.

## Problem

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3^x.

**Example 1:**
```text
Input: n = 27
Output: true
```
**Example 2:**
```text
Input: n = 0
Output: false
```
**Example 3:**
```text
Input: n = 9
Output: true
```

## Solution

3의 n제곱인 경우 true를 반환하는 문제입니다.

```java
public class Solution {
  public boolean isPowerOfThree(int n) {
    if (n == 0) {
      return false;
    }
    int r = 0;

    while (n > 1) {
      r = n % 3;
      if (r != 0) {
        return false;
      }
      n = n / 3;
    }
    return n == 1;
  }
}
```

n이 1보다 클 때 3으로 계속 나눠서 n이 1인지 검사합니다.

중간중간 3으로 나눴을 때 나머지가 존재해선 안 됩니다.

## Test

```java
package io.lcalmsky.leetcode.power_of_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(27, true),
        () -> test(0, false),
        () -> test(9, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.isPowerOfThree(given);
    // then
    assertEquals(expected, actual);
  }
}
```
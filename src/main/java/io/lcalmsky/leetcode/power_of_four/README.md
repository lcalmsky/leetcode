> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/power_of_four/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/power-of-four/) 있습니다.

## Problem

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

**Example 1:**
```text
Input: n = 16
Output: true
```
**Example 2:**
```text
Input: n = 5
Output: false
```
**Example 3:**
```text
Input: n = 1
Output: true
```


**Constraints:**

-2^31 <= n <= 2^31 - 1


## Solution

정수 n이 주어졌을 때 4의 제곱이면 true를 반환하는 문제입니다.

4의 제곱을 2진수로 표현하면 아래와 같습니다.

```text
1   = 1
4   = 100
16  = 10000
64  = 1000000
256 = 10000000
...
```

1 이후 0이 두 개씩 증가하는 것을 확인할 수 있습니다.

따라서 1이 맨 앞에 한 개 존재하고 나머지가 0이며 0의 개수가 2의 배수이면 4의 제곱입니다.

```java
public class Solution {

  public boolean isPowerOfFour(int num) {
    int numberOfZeros = 0;
    int numberOfOnes = 0;
    while (num > 0) {
      if ((num & 1) == 1) { // 마지막 자리 수가 1이면
        numberOfOnes++;
      } else { // 마지막 자리 수가 0이면
        numberOfZeros++;
      }
      num >>= 1; // 오른쪽으로 한 칸 bit shift
    }
    return numberOfOnes == 1 && (numberOfZeros % 2 == 0);
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.power_of_four;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(16, true),
        () -> test(5, false),
        () -> test(1, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.isPowerOfFour(given);
    // then
    assertEquals(expected, actual);
  }
}
```
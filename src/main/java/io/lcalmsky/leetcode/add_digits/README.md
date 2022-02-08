> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/add_digits/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/add-digits/) 있습니다.

## Problem

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

**Example 1:**
```text
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
```
**Example 2:**
```text
Input: num = 0
Output: 0
```

**Constraints:**

* 0 <= num <= 2^31 - 1

## Solution

정수가 주어질 때 반복적으로 각 자리 수를 한 자리 수가 될 때까지 더해 결과를 반환하는 문제입니다.

여러 가지 방법이 있겠지만 수학적으로 접근해야 가장 좋은 성능의 답을 얻을 수 있습니다.

```java
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
```

1. n이 0일 땐 답이 0입니다.
2. n이 9의 배수일 땐 답이 9입니다.
3. n이 9의 배수가 아닐 땐 n을 9로 나눈 나머지 값입니다.

2번과 3번 케이스를 합치면

4. n이 0이 아닐 때 1 + (n-1) % 9가 됩니다.

```java
class Solution {
  public int addDigits(int num) {
    return num == 0 ? 0 : 1 + (num - 1) % 9;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.add_digits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenDigit_whenAddUntilOneDigit_thenCorrect() {
    assertAll(
        () -> test(38, 2),
        () -> test(0, 0)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution addDigits = new Solution();
    int actual = addDigits.addDigits(given);
    // then
    assertEquals(expected, actual);
  }
}
```
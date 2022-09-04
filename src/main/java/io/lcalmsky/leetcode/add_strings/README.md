> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/add_strings/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/add-strings/) 있습니다.

## Problem

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

**Example 1:**
```text
Input: num1 = "11", num2 = "123"
Output: "134"
```

**Example 2:**
```text
Input: num1 = "456", num2 = "77"
Output: "533"
```

**Example 3:**
```text
Input: num1 = "0", num2 = "0"
Output: "0"
```

**Constraints:**

* 1 <= num1.length, num2.length <= 104
* num1 and num2 consist of only digits.
* num1 and num2 don't have any leading zeros except for the zero itself.

## Solution

두 개의 음수가 아닌 정수 문자열이 주어질 때 두 수의 합을 구하는 문제입니다.

```java
public class Solution {

  public String addStrings(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();
    StringBuilder result = new StringBuilder();
    int carry = 0;
    for (int i = 0; i < Math.max(n, m); i++) {
      int c1 = n - 1 - i >= 0 ? num1.charAt(n - 1 - i) - '0' : 0;
      int c2 = m - 1 - i >= 0 ? num2.charAt(m - 1 - i) - '0' : 0;
      int c = c1 + c2 + carry;
      if (c >= 10) {
        c -= 10;
        carry = 1;
      } else {
        carry = 0;
      }
      result.append(c);
    }
    if (carry != 0) {
      result.append(carry);
    }
    return result.reverse().toString();
  }
}

```

숫자의 길이가 10^4까지이기 때문에 단순히 숫자로 파싱한 다음 더하는 게 아니라 각 자리 수를 더해주는 방법을 사용해야 합니다.

두 수의 자리수 차이가 있을 수 있어 그 부분에 대한 예외처리만 추가하면 간단하게 해결할 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.add_strings;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTwoStrings_whenAddThem_thenCorrect() {
    assertAll(
        () -> test("11", "123", "134"),
        () -> test("456", "77", "533"),
        () -> test("0", "0", "0")
    );
  }

  private void test(String num1, String num2, String expected) {
    // when
    Solution addStrings = new Solution();
    String actual = addStrings.addStrings(num1, num2);

    // then
    assertEquals(expected, actual);
  }

}
```
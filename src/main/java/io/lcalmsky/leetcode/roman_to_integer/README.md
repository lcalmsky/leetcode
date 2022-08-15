> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/roman_to_integer/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/roman-to-integer/) 있습니다.

## Problem

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

```text
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

* I can be placed before V (5) and X (10) to make 4 and 9.
* X can be placed before L (50) and C (100) to make 40 and 90.
* C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

**Example 1:**
```text
Input: s = "III"
Output: 3
Explanation: III = 3.
```
**Example 2:**
```text
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
```
**Example 3:**
```text
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```


**Constraints:**

* 1 <= s.length <= 15
* s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
* It is guaranteed that s is a valid roman numeral in the range [1, 3999].

## Solution

로마 숫자를 정수로 변환하는 문제입니다.

```java
public class Solution {

  private static final String[] ROMANS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL",
      "X", "IX", "V", "IV", "I"};
  private static final int[] VALUES = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
      1};

  public int romanToInt(String roman) {
    int result = 0;
    int offset = 0;
    for (int i = 0; i < ROMANS.length; i++) {
      while (roman.startsWith(ROMANS[i], offset)) {
        result += VALUES[i];
        offset += ROMANS[i].length();
      }
    }
    return result;
  }
}
```

쉬운 난이도의 문제라 풀 수 있는 방법도 엄청 다양한데 배열을 이용해 값을 매핑해놓고, 문자열의 offset을 계산하여 현재 해당하는 문자열의 값을 더해나가는 방식으로 구현하였습니다.

## Test

```java
package io.lcalmsky.leetcode.roman_to_integer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("III", 3),
        () -> test("LVIII", 58),
        () -> test("MCMXCIV", 1994)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.romanToInt(given);
    // then
    assertEquals(expected, actual);
  }
}
```
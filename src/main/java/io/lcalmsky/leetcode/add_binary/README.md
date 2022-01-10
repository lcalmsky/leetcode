> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/add_binary/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/add-binary/) 있습니다.

## Problem

Given two binary strings a and b, return their sum as a binary string.

**Example 1:**

```text
Input: a = "11", b = "1"
Output: "100"
```

**Example 2:**

```text
Input: a = "1010", b = "1011"
Output: "10101"
```

**Constraints:**

* 1 <= a.length, b.length <= 10^4
* a and b consist only of '0' or '1' characters.
* Each string does not contain leading zeros except for the zero itself.

## Solution

두 이진수 문자열이 주어졌을 때 두 수를 더하는 문제입니다.

제약사항에 이진수 문자열의 길이가 10^4까지 가능하다고 나와있으므로 숫자로 변환한 뒤 계산하는 방법으로 진행하는 것보단 각 자릿수에 대해 계산하여 문자열을 더해가는 방식으로 풀이해야 합니다.

```java
public class Solution {

  public String addBinary(String a, String b) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0, sum;
    while (i >= 0 || j >= 0) {
      sum = 0;
      if (i >= 0 && a.charAt(i--) == '1') { // (1)
        sum++;
      }
      if (j >= 0 && b.charAt(j--) == '1') { // (2)
        sum++;
      }
      sum += carry; // (3)
      carry = sum >= 2 ? 1 : 0; // (4)
      stringBuilder.insert(0, sum % 2); // (5)
    }
    if (carry == 1) { // (6)
      stringBuilder.insert(0, '1');
    }
    return stringBuilder.toString();
  }
}
```

1. a 문자열의 해당 문자가 나타내는 수만큼 더해줍니다.
2. b 문자열의 해당 문자가 나타내는 수만큼 더해줍니다.
3. 이전에 계산한 올림 수를 더해줍니다.
4. 합이 2가 넘는다면 올림 수를 1로 설정해주고 그렇지 않다면 0으로 초기화합니다.
5. 합을 2로 나눈 나머지를 문자열에 추가하는데 앞쪽에 추가하여 기존 문자열이 뒤로 밀려날 수 있게 해줍니다.
6. 올림 수가 남아있으면 앞에 1을 추가해줍니다.

## Test

```java
package io.lcalmsky.leetcode.add_binary;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenBinaryNumbers_whenAdd_thenCorrect() {
    assertAll(
        () -> test("11", "1", "100"),
        () -> test("1010", "1011", "10101"),
        () -> test(
            "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
            "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011",
            "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000")
    );
  }

  private void test(String givenA, String givenB, String expected) {
    // when
    Solution addBinary = new Solution();
    String actual = addBinary.addBinary(givenA, givenB);
    // then
    assertEquals(expected, actual);
  }
}
```
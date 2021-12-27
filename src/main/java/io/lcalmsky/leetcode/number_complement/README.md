> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/number_complement/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/number-complement/) 있습니다.

## Problem

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

**Example 1:**

```text
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
```

**Example 2:**

```text
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
```

**Constraints:**

* 1 <= num < 2^31

## Solution

정수가 주어졌을 때 해당 정수의 보수를 구하는 문제입니다.

> 보수란 이진수로 변환하여 1과 0을 바꿔준 숫자를 의미합니다. 문제에서는 부호에 대한 설명이 따로 없기 때문에 그냥 바꿔주기만 하면 됩니다.

```java
public class Solution {
    public int findComplement(int num) {
        return (1 - num % 2) + 2 * (num <= 1 ? 0 : findComplement(num / 2));
    }
}
```

보수를 취하기 위해 1에서 num을 2로 나눈 나머지를 빼주고 그 뒤로는 num을 2로 나눈 뒤 반복하여 게산하되 자리 수에 대한 계산이 필요하기 때문에 2를 곱해주면 됩니다.

문자열에서 숫자를 파싱할 때 각 자리수 별로 10을 곱해주는 것과 같은 원리입니다.

## Test

```java
package io.lcalmsky.leetcode.number_complement;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenNumber_whenFindComplement_thenCorrect() {
    assertAll(
        () -> test(5, 2),
        () -> test(1, 0)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution numberComplement = new Solution();
    int actual = numberComplement.findComplement(given);

    // then
    assertEquals(expected, actual);
  }
}
```
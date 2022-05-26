> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/number_of_1_bits/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/number-of-1-bits/) 있습니다.

## Problem

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

**Note:**

* Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
* In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.


**Example 1:**
```text
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
```
**Example 2:**
```text
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
```
**Example 3:**
```text
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
```


**Constraints:**

* The input must be a binary string of length 32.


**Follow up:** If this function is called many times, how would you optimize it?

## Solution

unsinged integer를 그 정수가 가진 1의 갯수로 반환하는 기능을 구현하는 문제입니다.

bit shift를 이용해 간단히 해결할 수 있습니다.

```java
public class Solution {

  public int hammingWeight(int n) {
    int num = 0;

    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) {
        num++;
      }
      n = n >> 1;
    }

    return num;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.number_of_1_bits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(521, 3),
        () -> test(2097152, 1),
        () -> test(-3, 31)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.hammingWeight(given);
    // then
    assertEquals(expected, actual);
  }
}
```

문제에 자바 컴파일러 때문에 n을 정확히 표현할 수 없다고 나와있으므로 2진수를 정수로 변환해서 테스트해야 합니다.

그리고 예제 3번의 경우 실제로는 -3을 나타내므로 마찬가지로 -3을 넣어서 테스트 해야 합니다.

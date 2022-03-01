> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/counting_bits/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/counting-bits/) 있습니다.

## Problem

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

**Example 1:**
```text
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
```
**Example 2:**
```text
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```

**Constraints:**

* 0 <= n <= 10^5

**Follow** up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

## Solution

정수 n이 주어졌을 때 0부터 n까지 2진수로 나타냈을 때 1의 개수를 배열로 반환하는 문제입니다.

```java
public class Solution {

  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    int p = 1;
    int pow = 1;
    for (int i = 1; i <= num; i++) {
      if (i == pow) { // (1)
        result[i] = 1;
        pow *= 2;
        p = 1;
      } else { // (2)
        result[i] = result[p++] + 1;
      }
    }
    return result;
  }
}

```

1. 2의 제곱일 떄 1의 개수는 항상 1입니다. 2의 제곱을 저장하는 변수를 2로 곱해주고 2의 제곱 이후 얼마나 떨어져있는지를 나타내는 변수 p를 초기화시켜 줍니다.
2. 2의 제곱이 아닐 때 p에 저장된 값보다 1의 개수가 한 개 더 많습니다. 결과에 저장한 뒤 p의 위치를 1만큼 앞으로 이동시킵니다.

## Test

```java
package io.lcalmsky.leetcode.counting_bits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenNumber_whenFindNumberOfOnesInBinary_thenCorrect() {
    assertAll(
        () -> test(2, new int[]{0, 1, 1}),
        () -> test(5, new int[]{0, 1, 1, 2, 1, 2})
    );
  }

  private void test(int given, int[] expected) {
    // when
    Solution countingBits = new Solution();
    int[] actual = countingBits.countBits(given);
    // expected
    assertArrayEquals(expected, actual);
  }
}
```
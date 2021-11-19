> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/hamming-distance/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/hamming-distance/) 있습니다.

## Problem

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

**Example 1:**

```text
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
↑   ↑
The above arrows point to positions where the corresponding bits are different.
```

**Example 2:**

```text
Input: x = 3, y = 1
Output: 1
```

**Constraints:**

* 0 <= x, y <= 2^31 - 1

## Solution

두 정수 사이의 ![해밍 거리](https://en.wikipedia.org/wiki/Hamming_distance)는 해당 정수의 비트가 다른 위치의 갯수로 표현할 수 있는데, 두 정수가 주어질 때 해밍 거리를 구하는 문제입니다.

두 정수의 서로 다른 비트를 구하려면 exclusive or를 사용하면 되는데요, 예제 1번을 예로 들면, 1과 4를 exclusive or 연산을 취하게 되면

```text
 1 (0 0 0 1)
 4 (0 1 0 0)
-------------
 5 (0 1 0 1)
```

이렇게 5가 되므로 바로 답이 도출되진 않습니다.

이 때 각 비트가 1인 갯수만 세게되면 답을 구할 수 있습니다.

비트를 세는 방법은 비트 시프트를 이용해 1비트씩 우측으로 이동시킨 뒤 1과 and 연산을 취하면 됩니다.

```java
public class Solution {

  public int hammingDistance(int x, int y) {
    int count = 0;
    int exclusiveOr = x ^ y;
    while (exclusiveOr != 0) {
      if ((exclusiveOr & 1) == 1) {
        count++;
      }
      exclusiveOr >>= 1;
    }
    return count;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.hamming_distance;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenNumbers_whenFindHammingDistance_thenCorrect() {
    assertAll(
        () -> test(1, 4, 2)
    );
  }

  private void test(int x, int y, int expected) {
    // when
    Solution hammingDistance = new Solution();
    int actual = hammingDistance.hammingDistance(x, y);

    // then
    assertEquals(expected, actual);
  }
}
```
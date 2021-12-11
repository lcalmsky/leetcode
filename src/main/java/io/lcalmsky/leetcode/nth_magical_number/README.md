> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/nth_magical_number/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/nth-magical-number/) 있습니다.

## Problem

A positive integer is magical if it is divisible by either a or b.

Given the three integers n, a, and b, return the nth magical number. Since the answer may be very large, return it modulo 109 + 7.

**Example 1:**

```text
Input: n = 1, a = 2, b = 3
Output: 2
```

**Example 2:**

```text
Input: n = 4, a = 2, b = 3
Output: 6
```

**Example 3:**

```text
Input: n = 5, a = 2, b = 4
Output: 10
```

**Example 4:**

```text
Input: n = 3, a = 6, b = 4
Output: 8
```

**Constraints:**

* 1 <= n <= 10*9
* 2 <= a, b <= 4 * 10*4

## Solution

a 또는 b로 나누어 떨어지는 양의 정수를 magical number라고 할 때 n 번째 magical number를 구하는 문제입니다.

a = 2, b = 3 일 때

```text
n=1: 2 (2)
n=2: 3 (2, 3)
n=3: 4 (2, 3, 4)
n=4: 6 (2, 3, 4, 6)
n=5: 8 (2, 3, 4, 6, 8)
...
```

이런식으로 magical number를 계산할 수 있습니다.

a와 b 둘 중 하나가 서로의 약수일 때는 더 작은 수에 n번 곱해주면 magical number를 구할 수 있고, 둘이 서로소일 경우에도 n * a * b 보다 무조건 작을 수 밖에 없습니다.

특정 기준 값 x를 a로 나눈 몫과 b로 나눈 몫을 합하고 a와 b의 최소공배수로 나눈 만큼을 빼주면 a와 b의 x번째 magical number가 됩니다.

하지만 우린 n번째 magical number를 구해야 하는데 순차적으로 찾을 경우 시간을 초과할 가능성이 매우 높으므로  이진탐색으로 찾아 속도를 향상시킬 수 있습니다.

```java
public class Solution {
  
  private static final int MODULO = 1000000007;

  public int nthMagicalNumber(int n, int a, int b) {
    long lcm = (long) a * b / gcd(a, b); // 최소 공배수를 구합니다.
    long left = 0, right = (long) n * a * b; // magical number를 탐색할 최소, 최대 범위를 구합니다.
    while (left + 1 < right) { // 두 수가 같아질 때 n번째 magical number를 구할 수 있습니다.
      long mid = (left + right) / 2; // 이진 탐색을 위해 중간값을 구하고
      long magicalNumber = mid / a + mid / b - mid / lcm; // 중간값을 x번째 magical number를 구하는 공식에 대입합니다.
      if (magicalNumber >= n) { // 구한 x가 n과 같은지 비교하여 범위를 조절합니다.
        right = mid;
      } else {
        left = mid;
      }
    }
    return (int) (right % MODULO); // 결과를 문제에서 주어진 Modulo로 나눠 반환합니다.
  }

  private int gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.nth_magical_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, 2, 3, 2),
        () -> test(4, 2, 3, 6),
        () -> test(5, 2, 4, 10),
        () -> test(3, 6, 4, 8)
    );
  }

  private void test(int n, int a, int b, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.nthMagicalNumber(n, a, b);
    // then
    assertEquals(expected, actual);
  }
}
```
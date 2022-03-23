> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/broken_calculator/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/broken-calculator/) 있습니다.

## Problem

There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

* multiply the number on display by 2, or
* subtract 1 from the number on display.

Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

**Example 1:**
```text
Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
```
**Example 2:**
```text
Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
```
**Example 3:**
```text
Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
```

**Constraints:**

* 1 <= x, y <= 10^9

## Solution

고장난 계산기가 있는데 처음 값에서 곱하기 2나 빼기 1만 동작합니다.

시작 값과 타겟 값이 주어질 때 타겟 값을 만들 수 있는 최소 연산 횟수를 구하는 문제입니다.

재귀호출을 이용해 해결할 수 있습니다.

```java
public class Solution {

  public int brokenCalc(int startValue, int target) {
    if (startValue == target) { // (1)
      return 0;
    }
    if (startValue > target) { // (2)
      return startValue - target;
    }
    if (target % 2 == 0) { // (3)
      return 1 + brokenCalc(startValue, target / 2);
    }
    return 1 + brokenCalc(startValue, target + 1); // (4)
  }
}

```

1. 두 수가 같을 땐 0을 반환합니다.
2. `startValue`가 더 클 땐 -1로만 `target`을 만들 수 있으므로 `startValue`에서 `target` 값을 빼서 반환합니다.
3. `target`이 2의 배수인 경우 `target`을 2로 나눠 재귀호출 합니다. 1회 연산이 수행되었기 때문에 1을 더해 반환합니다.
4. `target`이 2의 배수가 아닌 경우 `target`에 1을 더해 재귀호출합니다. 1회 연산이 수행되었기 때문에 1을 더해 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.broken_calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, 3, 2),
        () -> test(5, 8, 2),
        () -> test(3, 10, 3)
    );
  }

  private void test(int startValue, int `target`, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.brokenCalc(startValue, target);
    // then
    assertEquals(expected, actual);
  }
}
```
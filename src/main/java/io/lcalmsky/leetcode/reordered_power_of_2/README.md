> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reordered_power_of_2/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/reordered-power-of-2/) 있습니다.

## Problem

You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

**Example 1:**
```text
Input: n = 1
Output: true
```

**Example 2:**
```text
Input: n = 10
Output: false
```

**Constraints**:

* 1 <= n <= 10^9

## Solution

정수 n이 주어졌을 때 n을 재배열하여 2의 k제곱이 될 수 있는지 여부를 반환하는 문제입니다.

2의 k제곱이 되기위해선 2진수로 표현했을 때 값이

```text
1     = 2 ^ 0
10    = 2 ^ 1
100   = 2 ^ 2
1000  = 2 ^ 3
...
```

이렇게 1로 시작하고 뒤에가 모두 0이 되어야합니다.

따라서 주어진 정수를 정렬한 뒤 1부터 2배씩 곱한 수를 정렬한 것과 비교하여 같은 게 존재하면 true, 그렇지 않으면 false를 반환하면 됩니다.

```java
package io.lcalmsky.leetcode.reordered_power_of_2;

import java.util.Arrays;

public class Solution {

  public boolean reorderedPowerOf2(int n) {
    String sortedInteger = sort(n);
    for (int i = 0; i < 31; ++i) {
      String sorted = sort(1 << i);
      if (sortedInteger.equals(sorted)) {
        return true;
      }
      if (sorted.length() > sortedInteger.length()) {
        break;
      }
    }
    return false;
  }

  private String sort(int n) {
    char[] num = String.valueOf(n).toCharArray();
    Arrays.sort(num);
    return String.valueOf(num);
  }
}
```



## Test

```java
package io.lcalmsky.leetcode.reordered_power_of_2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, true),
        () -> test(10, false)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.reorderedPowerOf2(given);
    // then
    assertEquals(expected, actual);
  }
}
```
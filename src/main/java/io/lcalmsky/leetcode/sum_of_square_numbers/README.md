> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sum_of_square_numbers/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3918/) 있습니다.

## Problem

Given a non-negative integer c, decide whether there are two integers a and b such that a^2 + b^2 = c.

**Example 1:**

```text
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
```

**Example 2:**

```text
Input: c = 3
Output: false
```

**Example 3:**

```text
Input: c = 4
Output: true
```

**Example 4:**

```text
Input: c = 2
Output: true
```

**Example 5:**

```text
Input: c = 1
Output: true
```

**Constraints:**

0 <= c <= 2^31 - 1

## Solution

정수 c가 주어졌을 때 c가 두 수의 제곱의 합으로 이루어져있는지 판단하는 문제입니다.

c에 루트를 씌운 뒤 소숫점을 버린 정수는 c를 구성할 수 있는 가장 큰 수의 제곱근이 됩니다.

예를 들어, c가 20이라면 20의 제곱근의 값은 4.xx가 되고, 이 때 소숫점을 버린 4가 c를 구성할 수 있는 가장 큰 제곱근 입니다. (5부터는 제곱하면 20을 벗어나기 때문)

따라서 0부터 c의 제곱근까지 범위를 탐색하면서 각 수를 제곱해 합을 구하면 되는데 앞에서부터 하면 비효율적이므로 포인터를 양 끝에 두고 탐색하여 합이 c가 되면 true를, 모든 조합을 다 찾았는데 합이 c가 되지 않으면 false를 반환하면 됩니다.

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.sum_of_square_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenNonNegativeInteger_whenDecideSumOfSquareNumbers_thenCorrect() {
        assertAll(
                () -> test(5, true),
                () -> test(3, false),
                () -> test(14, false)
        );
    }

    private void test(int given, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.judgeSquareSum(given);

        // then
        assertEquals(expected, actual);
    }
}
```
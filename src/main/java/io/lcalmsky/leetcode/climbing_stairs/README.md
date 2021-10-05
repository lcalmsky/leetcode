> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/climbing_stairs/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/climbing-stairs/) 있습니다.

## Problem

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*Example 1:*

```text
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

*Example 2:*

```text
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## Solution

DP 문제중 가장 기본이 되는 문제입니다.

계단을 오르는데 하나 또는 두 개씩 오를 수 있을 때 N개의 계단을 오를 수 있는 경우의 수를 구하는 문제입니다.

DP 문제는 점화식만 잘 세우면 끝나는데 이 문제는 점화식을 세우기 매우 쉬운 문제입니다.

처음 한 계단을 오르는 경우의 수는 1, 두 계단을 오르는 경우의 수는 첫 번째 계단에서 한 계단 오른 경우 + 두 계단을 한 번에 오른 경우 총, 두 가지 입니다.

N 번째 계단에 올라갔을 때의 경우의 수는 N-1번째 계단에서 한 계단을 오르는 경우의 수 + N-2번째 계단에서 두 계단을 오르는 경우의 수 이므로 점화식은 다음과 같습니다.

> f[n] = f[n-1] + f[n-2]  
> f[1] = 1  
> f[2] = 2

이 내용을 소스 코드로 표현하면 다음과 같습니다.

```java
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

---

메모리를 아끼기 위해 두 개의 변수를 사용하여 누적값을 계산할 수 있습니다.

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 0, a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.climbing_stairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenInteger_whenClimbStairs_thenCorrect() {
        assertAll(
                () -> test(2, 2),
                () -> test(3, 3)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.climbStairs(given);

        // then
        assertEquals(expected, actual);
    }
}
```
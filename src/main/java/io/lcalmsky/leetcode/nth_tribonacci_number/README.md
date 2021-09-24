> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/nth_tribonacci-number/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3986/) 있습니다.

## Problem

The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

**Example 1:**

```
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
```

**Example 2:**

```
Input: n = 25
Output: 1389537
```

**Constraints:**

* 0 <= n <= 37
* The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

## Solution

전형적인 DP (Dynamic Programming) 문제로 피보나치 수열을 구하는 문제에 숟가락만 살포시 얹으면 간단히 풀 수 있는 문제입니다.

피보나치 수열은 앞의 두 값을 더해 다음 값을 구하는데, 이 문제에서는 앞의 세 값을 더해서 다음 값을 구하라고 하고있습니다.

입력 값 n이 0부터 시작할 수 있기 때문에 종료조건에 신경을 써야하고 그 이후에는 초기 조건 이후에 값을 순차적으로 계산해 배열에 저장한 뒤 배열의 n 번 째 값을 반환해주면 됩니다.

```java
public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.nth_tribonacci_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void givenNumber_whenFindTribonacci_thenCorrect() {
        assertAll(
                () -> test(4, 4),
                () -> test(25, 1389537)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.tribonacci(given);

        // then
        assertEquals(expected, actual);
    }
}
```
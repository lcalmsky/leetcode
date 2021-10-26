> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/perfect_squares/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/perfect-squares/) 있습니다.

## Problem

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

**Example 1:**

```text
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
```

**Example 2:**

```text
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

**Constraints:**

* 1 <= n <= 10^4

## Solution

정수 n이 주어졌을 때 완전제곱수의 합으로 n을 이룰 수 있는 가장 작은 경우의 수를 구하는 문제입니다.

DP를 이용해 간단히 풀 수 있습니다.

```java
import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10001);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(n); j++) {
                if (i == j * j) {
                    dp[i] = 1;
                } else if (i > j * j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }
}
```

다른 방법에 비해 시간, 공간 복잡도가 많이 들지만 풀이 자체는 가장 깔끔한 방법이라고 생각합니다.

[라그랑주 네 제곱수 정리](https://ko.wikipedia.org/wiki/%EB%9D%BC%EA%B7%B8%EB%9E%91%EC%A3%BC_%EB%84%A4_%EC%A0%9C%EA%B3%B1%EC%88%98_%EC%A0%95%EB%A6%AC)를 이용하면 시간, 공간 복잡도를 훨씬 더 아낄 수 있습니다.

> **💡 라그랑주 네 제곱수 정리:** 모든 양의 정수는 많아야 4개의 제곱수의 합이다. 

```java
class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) { // (1)
            n /= 4;
        }

        if (n % 8 == 7) { // (1)
            return 4;
        }

        if (isSquares(n)) { // (2)
            return 1;
        }

        for (int i = 1; i * i < n; i++) { // (3)
            if (isSquares(n - i * i)) {
                return 2;
            }
        }

        return 3; // (4)
    }

    private boolean isSquares(int n) {
        int rootN = (int) Math.sqrt(n);
        return n == rootN * rootN;
    }
}
```

1. 4^n(8k + 7)은 반드시 4개의 제곱수로 나타낼 수 있음
2. 제곱수인 경우 1을 반환
3. 제곱수를 뺀 이후 제곱수인 경우 2를 반환(제곱수 + 제곱수로 나타내지는 경우)
4. 1, 2, 3의 경우가 아니면 무조건 3개로 나타낼 수 있음

## Test

```java
package io.lcalmsky.leetcode.perfect_squares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenNumber_whenFindLeastNumber_thenCorrect() {
        assertAll(
                () -> test(12, 3),
                () -> test(13, 2)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.numSquares(given);

        // then
        assertEquals(actual, expected);
    }
}
```
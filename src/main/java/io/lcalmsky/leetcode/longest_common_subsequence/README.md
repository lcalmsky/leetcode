> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_common_subsequence/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-common-subsequence/) 있습니다.

## Problem

Given two strings `text1` and `text2`, return the length of their longest _**common subsequence**_. If there is no _**common subsequence**_, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

* For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

**Example 1:**
```text
Input: text1 = "abcde", text2 = "ace"
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
```

**Example 2:**

```text
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
```

**Example 3:**

```text
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
```

**Constraints:**

* 1 <= text1.length, text2.length <= 1000
* text1 and text2 consist of only lowercase English characters.

## Solution

주어진 두 개의 문자열 `text1`과 `text2`의 최장 공통 부분 수열(longest common subsequence)의 길이를 반환하는 문제입니다. 만약 공통 부분 수열이 존재하지 않으면 0을 반환해야 합니다.

여기서 부분 수열(subsequence)란 원래 문자열에서 일부 문자를 제거하고 남은 문자들의 상대적인 순서를 유지한 새로운 문자열을 말합니다.

예를 들어, "ace"는 "abcde"의 부분 수열입니다. 두 개의 문자열에 공통으로 존재하는 부분 수열을 최장 공통 부분 수열이라고 합니다.

```java
package io.lcalmsky.leetcode.longest_common_subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

```


1. 두 개의 문자열 text1과 text2의 길이를 각각 m과 n이라고 합니다.
2. 길이가 m+1인 배열 dp를 생성합니다. dp[i][j]는 text1의 처음 i개 문자와 text2의 처음 j개 문자까지 고려했을 때의 최장 공통 부분 수열의 길이를 저장합니다.
3. dp 배열을 아래 방식으로 채웁니다:
   4. i=0 또는 j=0인 경우, 즉 text1 또는 text2가 빈 문자열인 경우, dp[i][j]는 0입니다. 
   5. i>0이고 j>0인 경우:
      6. 만약 text1[i-1]과 text2[j-1]이 동일한 문자라면, 즉 text1의 현재 문자와 text2의 현재 문자가 같다면, dp[i][j]는 dp[i-1][j-1] + 1입니다. 이전 문자까지의 최장 공통 부분 수열의 길이에 현재 문자를 추가하는 것을 의미합니다. 
      7. 그렇지 않다면, dp[i][j]는 dp[i-1][j]와 dp[i][j-1] 중에서 더 큰 값이 됩니다. 이전 문자까지의 최장 공통 부분 수열의 길이를 그대로 가져오는 것을 의미합니다.
4. dp[m][n] 값이 최장 공통 부분 수열의 길이가 됩니다.

## Test

```java
package io.lcalmsky.leetcode.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("abcde", "ace", 3),
                () -> test("abc", "abc", 3),
                () -> test("abc", "def", 0)
        );
    }

    private void test(String text1, String text2, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestCommonSubsequence(text1, text2);
        // then
        assertEquals(expected, actual);
    }
}
```
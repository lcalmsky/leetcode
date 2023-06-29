> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/edit_distance/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/edit-distance/) 있습니다.

## Problem

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

* Insert a character
* Delete a character
* Replace a character


**Example 1:**

```text
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

**Example 2:**

```text
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

**Constraints:**

* 0 <= word1.length, word2.length <= 500
* word1 and word2 consist of lowercase English letters.

## Solution

두 단어가 주어졌을 때 두 단어가 같아질 수 있게 하는 최소 연산 횟수를 구하는 문제입니다.

세 가지 연산을 사용할 수 있습니다.
* 문자 추가
* 문자 제거
* 문자 대체

DP를 이용해 풀 수 있습니다.

먼저 word1을 만들기 위해 필요한 연산 수를 각 row의 0번째 인덱스에 추가하고, 다음으로 word2를 만들기 위해 필요한 연산 수를 컬럼의 i번째 인덱스에 추가합니다.

이후 dp 배열을 순차적으로 탐색하면서 각 위치에 해당하는 문자가 같을 때는 이전과 같은 연산 수(연산이 발생하지 않기 때문에)를, 문자가 같지 않을 때는 이전 연산수와 현재 문자에 대해 각각의 단어가 필요한 연산수 중 최소 연산수에 1을 더해줍니다. 최소 연산 횟수를 구해야하기 때문에 세 가지 경우 중 최소 연산 값을 구해 가장 가까운 단어를 찾고, 그 이후 추가, 변경, 삭제 등의 연산이 필요하기 때문에 연산 횟수가 1회 추가되게 됩니다.

이렇게 끝까지 탐색한 뒤 dp 배열의 마지막 원소를 반환하면 필요한 최소 연산 횟수를 얻을 수 있습니다.

```java
package io.lcalmsky.leetcode.edit_distance;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            if (word2 == null || word2.length() == 0) {
                return 0;
            }
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int rows = word1.length() + 1;
        int cols = word2.length() + 1;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }

            }
        }
        return dp[rows - 1][cols - 1];
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.edit_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("horse", "ros", 3),
                () -> test("intention", "execution", 5)
        );
    }

    private void test(String word1, String word2, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minDistance(word1, word2);
        // then
        assertEquals(expected, actual);
    }
}
```
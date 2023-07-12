> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/generate_parentheses/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/generate-parentheses/) 있습니다.

## Problem

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

**Example 1:**
```text
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

**Example 2:**
```text
Input: n = 1
Output: ["()"]
```

**Constraints:**

* 1 <= n <= 8

## Solution

주어진 숫자 n에 대해 올바른 괄호 조합을 생성하는 문제입니다.

```java
package io.lcalmsky.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }

    private void backtrack(List<String> result, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            backtrack(result, s + "(", left - 1, right);
        }
        if (right > 0) {
            backtrack(result, s + ")", left, right - 1);
        }
    }
}

```

backtrack 함수는 재귀적으로 호출되며, 현재 괄호 조합 s와 남은 왼쪽 괄호 개수 left, 오른쪽 괄호 개수 right를 매개변수로 받습니다. 함수는 다음과 같은 작업을 수행합니다.

1. left가 right보다 큰 경우, 현재 괄호 조합이 유효하지 않으므로 함수를 종료합니다.
1. left와 right가 모두 0인 경우, 즉, 모든 괄호를 사용한 경우, 현재 괄호 조합을 result 리스트에 추가합니다.
1. 왼쪽 괄호를 추가할 수 있는 경우, s + "("로 재귀 호출을 수행하고, left를 1 감소시킵니다.
1. 오른쪽 괄호를 추가할 수 있는 경우, s + ")"로 재귀 호출을 수행하고, right를 1 감소시킵니다.

이러한 재귀 호출을 통해 모든 가능한 괄호 조합을 생성하고, 유효한 괄호 조합만 result 리스트에 추가됩니다. 마지막으로, result 리스트가 반환됩니다.

## Test

```java
package io.lcalmsky.leetcode.generate_parentheses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                () -> test(1, List.of("()"))
        );
    }

    private void test(int n, List<String> expected) {
        // when
        Solution solution = new Solution();
        List<String> actual = solution.generateParenthesis(n);
        // then
        assertEquals(expected, actual);
    }
}
```
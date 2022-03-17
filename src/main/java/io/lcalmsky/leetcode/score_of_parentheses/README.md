> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/score_of_parentheses/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/score_of_parentheses/) 있습니다.

## Problem

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

**Example 1:**
```text
Input: s = "()"
Output: 1
```
**Example 2:**
```text
Input: s = "(())"
Output: 2
```
**Example 3:**
```text
Input: s = "()()"
Output: 2
```


**Constraints:**

* 2 <= s.length <= 50
* s consists of only '(' and ')'.
* s is a balanced parentheses string.

## Solution

괄호가 주어질 때 점수를 매기는데 일반 괄호는 1점을, 중첩된 괄호는 2배의 점수를 얻을 수 있을 때 점수를 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.score_of_parentheses;

public class Solution {

  public int scoreOfParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(0);
      } else {
        int x = stack.pop();
        int y = stack.pop();
        stack.push(y + Math.max(2 * x, 1));
      }
    }
    return stack.pop();
  }
}
```

스택으로 점수를 계산하는데 처음에 초기 값인 0을 먼저 push하고, 괄호가 열릴 때마다 0을 push 합니다.

괄호가 닫힐 때마다 스택에서 두 개의 원소를 pop 해준 뒤 가장 최근 값에 두 배를 한 것과 1중 더 높은 값과 그 다음 최근 값을 반복해서 더해주면 괄호의 점수를 계산할 수 있습니다.

위 방법이 이해하기는 쉬운데 성능은 매우 저조하게 나와서 다른 답을 찾아보았습니다.

```java
class Solution {

  public int scoreOfParentheses(String s) {
    int score = 0;
    int depth = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        depth++;
      } else {
        depth--;
      }
      if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
        score += Math.pow(2, depth);
      }
    }
    return score;
  }
}
```

여기선 depth로 괄호의 중첩 정도를 계산하였습니다.

depth가 0일 때 중첩된 괄호가 없으므로 2^0인 1이 되고, 중첩된 괄호가 많을 수록 2^n이 더해지게 됩니다.

## Test

```java
package io.lcalmsky.leetcode.score_of_parentheses;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenParentheses_whenCompute_thenCorrect() {
    assertAll(
        () -> test("()", 1),
        () -> test("(())", 2),
        () -> test("()()", 2),
        () -> test("(()(()))", 6)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.scoreOfParentheses(given);

    // then
    assertEquals(expected, actual);
  }
}
```
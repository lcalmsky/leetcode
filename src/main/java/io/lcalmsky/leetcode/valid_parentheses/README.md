> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/valid_parentheses/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/valid-parentheses/) 있습니다.

## Problem

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

**Example 1:**
```text
Input: s = "()"
Output: true
```
**Example 2:**
```text
Input: s = "()[]{}"
Output: true
```
**Example 3:**
```text
Input: s = "(]"
Output: false
```

**Constraints:**

* 1 <= s.length <= 10^4
* s consists of parentheses only '()[]{}'.

## Solution

대괄호, 중괄호, 소괄호로 구성된 문자열이 주어졌을 때 괄호가 valid인지 판별하는 문제입니다.

```java
public class Solution {

  public boolean isValid(String s) {
    char[] ch = new char[s.length()];
    int index = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        ch[++index] = c;
      } else {
        if (index < 0) {
          return false;
        }
        if (c == ')' && ch[index] != '(') {
          return false;
        }
        if (c == '}' && ch[index] != '{') {
          return false;
        }
        if (c == ']' && ch[index] != '[') {
          return false;
        }
        index--;
      }
    }
    return index < 0;
  }
}
```

valid한 괄호가 되려면 반드시 여는 괄호가 먼저 등장하고 여는 괄호가 등장한 역순으로 닫는 괄호가 등장해야 합니다.

여는 괄호일 때 배열에 문자를 저장하고, 닫는 괄호일 때 괄호가 일치하지 않으면 false를 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.valid_parentheses;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("()", Assertions::assertTrue),
        () -> test("()[]{}", Assertions::assertTrue),
        () -> test("(]", Assertions::assertFalse)
    );
  }

  private void test(String given, Consumer<Boolean> consumer) {
    // when
    Solution solution = new Solution();
    // then
    consumer.accept(solution.isValid(given));
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/removing_stars_from_a_string/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/removing-stars-from-a-string/) 있습니다.

## Problem

You are given a string s, which contains stars *.

In one operation, you can:

* Choose a star in s.
* Remove the closest non-star character to its left, as well as remove the star itself.

Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.


**Example 1:**

```text
Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
  There are no more stars, so we return "lecoe".
```

**Example 2:**

```text
Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
```

**Constraints:**

* 1 <= s.length <= 105
* s consists of lowercase English letters and stars *.
* The operation above can be performed on s.

## Solution

문자열 s가 주어질 때 *와 가장 가까운 왼쪽 문자를 제거하는 작업을 모두 완료했을 때의 문자를 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.removing_stars_from_a_string;

import java.util.Stack;

public class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            stringBuilder.append(pop);
        }
        return stringBuilder.reverse().toString();
    }
}

```

저는 stack을 이용해 문제를 해결했습니다.

stack에 문자를 하나씩 추가하면서 *일 경우에 기존 문자를 스택에서 제거하게되면 기존 문자열 기준 왼쪽 문자가 제거되게 됩니다.

그리고 stack에 남은 문자열은 역순이 되므로 마지막에 reverse를 이용해 뒤집어주었습니다.

## Test

```java
package io.lcalmsky.leetcode.removing_stars_from_a_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test("leet**cod*e", "lecoe"),
                () -> test("erase*****", "")
        );
    }

    private void test(String s, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.removeStars(s);
        // then
        assertEquals(expected, actual);
    }
}
```
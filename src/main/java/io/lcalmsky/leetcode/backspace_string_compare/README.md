> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/backspace_string_compare/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/backspace-string-compare/) 있습니다.

## Problem

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

**Example 1:**
```text
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
```
**Example 2:**
```text
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
```
**Example 3:**
```text
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
```

**Constraints:**

* 1 <= s.length, t.length <= 200
* s and t only contain lowercase letters and '#' characters.

**Follow up**: Can you solve it in O(n) time and O(1) space?

## Solution

두 개의 문자열이 주어지는데 #은 백스페이스를 의미합니다.

두 문자열을 텍스트 에디터에 입력했을 때 같은지 여부를 반환하는 문제입니다.

각 문자의 #이 위치한 인덱스를 찾아 #과 앞의 문자를 제거해 준 뒤 비교하는 방식으로 풀이하였습니다.

```java
package io.lcalmsky.leetcode.backspace_string_compare;

public class Solution {

  public boolean backspaceCompare(String s, String t) {
    return remove(s).equals(remove(t));
  }

  private String remove(String origin) {
    StringBuilder sb = new StringBuilder(origin);
    while (true) {
      int index = sb.indexOf("#");
      if (index == -1) {
        break;
      }
      sb.deleteCharAt(index);
      if (index > 0) {
        sb.deleteCharAt(index - 1);
      }
    }
    return sb.toString();
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.backspace_string_compare;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTwoStrings_whenBackspace_thenCorrect() {
    assertAll(
        () -> test("ab#c", "ad#c", true),
        () -> test("ab##", "c#d#", true),
        () -> test("a##c", "#a#c", true),
        () -> test("a#c", "b", false)
    );
  }

  private void test(String s, String t, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.backspaceCompare(s, t);

    // then
    assertEquals(expected, actual);
  }
}

```
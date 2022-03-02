> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/is_subsequence/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/is-subsequence/) 있습니다.

## Problem

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

**Example 1:**
```text
Input: s = "abc", t = "ahbgdc"
Output: true
```
**Example 2:**
```text
Input: s = "axc", t = "ahbgdc"
Output: false
```

**Constraints:**

* 0 <= s.length <= 100
* 0 <= t.length <= 10^4
* s and t consist only of lowercase English letters.

**Follow up:** Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

## Solution

문자열 s와 t가 주어질 때 s가 t의 부분 문자열인지 여부를 반환하는 문제입니다.

연속으로 포함되지 않아도 되기 때문에 다양한 방법으로 풀 수 있습니다.

워낙 간단한 문제라 답만 첨부합니다.

```java
public class Solution {

  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int sIndex = 0, tIndex = 0;
    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      tIndex++;
      if (sIndex == s.length()) {
        return true;
      }
    }
    return false;
  }
}
```

```java
public boolean isSubsequence(String s, String t) {
  for (char ch : s.toCharArray()) {
    int find = t.indexOf(ch);
    if (find == -1) {
      return false;
    }
    t = t.substring(find + 1);
  }
  return true;
}
```

```java
public boolean isSubsequence(String s, String t) {
  int start = 0;
  int count = 0;
  for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    while (start < t.length()) {
      if (ch == t.charAt(start)) {
        count++;
        start++;
        break;
      }
      start++;
    }
  }
  return count == s.length();
}
```

## Test

```java
package io.lcalmsky.leetcode.is_subsequence;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTwoStrings_whenFindOneIsSubsequenceOfAnother_thenCorrect() {
    assertAll(
        () -> test("abc", "ahbgdc", true, new Solution()),
        () -> test("axc", "ahbgdc", false, new Solution()),
        () -> test("abc", "ahbgdc", true, new Solution2()),
        () -> test("axc", "ahbgdc", false, new Solution2()),
        () -> test("abc", "ahbgdc", true, new Solution3()),
        () -> test("axc", "ahbgdc", false, new Solution3())
    );
  }

  private void test(String s, String t, boolean expected, Solution solution) {
    // when
    boolean actual = solution.isSubsequence(s, t);
    // then
    assertEquals(expected, actual);
  }
}
```
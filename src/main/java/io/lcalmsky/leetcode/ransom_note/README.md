> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/ransom_note/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/ransom-note/) 있습니다.

## Problem

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

**Example 1:**
```text
Input: ransomNote = "a", magazine = "b"
Output: false
```
**Example 2:**
```text
Input: ransomNote = "aa", magazine = "ab"
Output: false
```
**Example 3:**
```text
Input: ransomNote = "aa", magazine = "aab"
Output: true
```

**Constraints:**

* 1 <= ransomNote.length, magazine.length <= 10^5
* ransomNote and magazine consist of lowercase English letters.

## Solution

메거진의 글자를 잘라서 만든 글자를 랜섬노트라고 하는데, 랜섬노트와 매거진 문자열이 주어졌을 때 랜섬노트를 만들 수 있으면 true를 반환하는 문제입니다.

```java
public class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] alphabets = new int[26];
    for (char c : magazine.toCharArray()) {
      alphabets[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (--alphabets[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
```

매거진에 있는 알파벳 갯수를 먼저 센 뒤, 랜섬노트에 필요한 알파벳 갯수를 빼주면서 0이하가 하나라도 존재할 경우 false를 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.ransom_note;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("a", "b", false),
        () -> test("aa", "ab", false),
        () -> test("aa", "aab", true)
    );
  }

  private void test(String ransomNote, String magazine, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.canConstruct(ransomNote, magazine);
    // then
    assertEquals(expected, actual);
  }
}
```
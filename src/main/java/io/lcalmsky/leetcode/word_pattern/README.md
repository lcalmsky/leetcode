> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/word_pattern/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/word-pattern/) 있습니다.

## Problem

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

**Example 1:**
```text
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
```
**Example 2:**
```text
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
```
**Example 3:**
```text
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
```

**Constraints:**

* 1 <= pattern.length <= 300
* pattern contains only lower-case English letters.
* 1 <= s.length <= 3000
* s contains only lowercase English letters and spaces ' '.
* s does not contain any leading or trailing spaces.
* All the words in s are separated by a single space.

## Solution

패턴과 문자열이 주어지는데 문자열이 패턴에 해당하는지 여부를 반환하는 문제입니다.

Map을 이용해 간단히 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.word_pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean wordPattern(String pattern, String str) {
    char[] patterns = pattern.toCharArray();
    String[] words = str.split(" ");
    if (patterns.length != words.length) {
      return false;
    }
    Map<Character, String> patternMap = new HashMap<>();
    for (int i = 0; i < patterns.length; i++) {
      char p = patterns[i];
      String word = words[i];
      if (patternMap.containsKey(p)) { // (1)
        if (!patternMap.get(p).equals(word)) {
          return false;
        }
      } else { // (2)
        if (patternMap.containsValue(word)) {
          return false;
        }
        patternMap.put(p, word); // (3)
      }
    }
    return true;
  }
}
```

1. 키가 존재하는데 값이 현재 단어와 같지 않으면 false를 반환합니다.
2. 키가 존재하지 않는데 현재 단어에 해당하는 단어가 존재하면 false를 반환합니다.
3. Map에 패턴과 패턴에 상응하는 단어를 추가합니다.

## Test

```java
package io.lcalmsky.leetcode.word_pattern;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenPatternAndWords_whenCheckPattern_thenCorrect() {
    assertAll(
        () -> test("abba", "dog cat cat dog", true),
        () -> test("abba", "dog cat cat fish", false),
        () -> test("aaaa", "dog cat cat dog", false),
        () -> test("abba", "dog dog dog dog", false)
    );
  }

  private void test(String pattern, String words, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.wordPattern(pattern, words);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_and_replace_pattern/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-and-replace-pattern/) 있습니다.

## Problem

Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

**Example 1:**
```text
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
```

**Example 2:**
```text
Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
```


**Constraints:**

* 1 <= pattern.length <= 20
* 1 <= words.length <= 50
* words[i].length == pattern.length
* pattern and words[i] are lowercase English letters.

## Solution

단어 배열과 패턴이 주어지면 패턴과 일치하는 단어들을 반환하는 문제입니다.

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> list = new ArrayList<>();
    for (String word : words) {
      if (matches(word, pattern)) {
        list.add(word);
      }
    }
    return list;
  }

  private static boolean matches(String word, String pattern) {
    for (int i = 0; i < word.length(); i++) {
      if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
```

단어의 i번째 문자와 패턴의 i번째 문자에 해당하는 인덱스가 동일한 경우 단어가 해당 패턴을 가진다는 뜻이므로 모두 일치하는 단어들만 추가하여 반환하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.find_and_replace_pattern;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb",
            List.of("mee", "aqq")),
        () -> test(new String[]{"a", "b", "c"}, "a", List.of("a", "b", "c"))
    );
  }

  private void test(String[] words, String pattern, List<String> expected) {
    // when
    Solution solution = new Solution();
    List<String> actual = solution.findAndReplacePattern(words, pattern);
    // then
    assertEquals(expected, actual);
  }
}
```
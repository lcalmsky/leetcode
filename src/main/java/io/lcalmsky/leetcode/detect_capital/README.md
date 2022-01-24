> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/detect_capital/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/detect-capital/) 있습니다.

## Problem

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

**Example 1:**
```text
Input: word = "USA"
Output: true
```
**Example 2:**
```text
Input: word = "FlaG"
Output: false
```

**Constraints:**

* 1 <= word.length <= 100
* word consists of lowercase and uppercase English letters.

## Solution

모든 문자가 대문자이거나, 소문자이거나, 첫 문자만 대문자인 경우 true를 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.detect_capital;

public class Solution {

  public boolean detectCapitalUse(String word) {
    if (Character.isUpperCase(word.charAt(0))) {
      word = word.substring(1);
      return word.toUpperCase().equals(word) || word.toLowerCase().equals(word);
    }
    return word.toLowerCase().equals(word);
  }
}
```

첫 번째 문자가 대문자일 때, 나머지 부분이 모두 대문자이거나 모두 소문자인지 비교하여 반환하고, 첫 문자가 소문자일 때, 모두 소문자인지 여부를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.detect_capital;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenWord_whenCheckItConsistsOnlyCapital_thenCorrect() {
    assertAll(
        () -> test("USA", true),
        () -> test("FlaG", false)
    );
  }

  private void test(String given, boolean expected) {
    // when
    Solution detectCapital = new Solution();
    boolean actual = detectCapital.detectCapitalUse(given);

    // then
    assertEquals(expected, actual);
  }
}
```

---

> 문제가 간단한 만큼 직접 케이스별로 단순 비교형태로 구현하면 더 좋은 결과를 얻을 수 있습니다.
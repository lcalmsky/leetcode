> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/first_unique_character_in_a_string/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/first-unique-character-in-a-string/) 있습니다.

## Problem

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

**Example 1:**
```text
Input: s = "leetcode"
Output: 0
```

**Example 2:**
```text
Input: s = "loveleetcode"
Output: 2
```

**Example 3:**
```text
Input: s = "aabb"
Output: -1
```

**Constraints:**

* 1 <= s.length <= 10^5
* s consists of only lowercase English letters.

## Solution

문자열 s가 주어졌을 때 처음으로 반복되지 않는 문자가 나오는 인덱스를 반환하는 문제입니다.

반복되지 않는지 확인해야하기 때문에 문자열 전체 탐색이 필요합니다.

탐색하면서 각 문자열이 몇 번 나타났는지 카운트하고, 다시 문자열 앞부터 탐색하면서 한 번 나타난 문자를 반환하면 됩니다. 

## Test

```java
package io.lcalmsky.leetcode.first_unique_character_in_a_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenString_findFirstUniqueCharacter_thenCorrect() {
    assertAll(
        () -> test("leetcode", 0),
        () -> test("loveleetcode", 2),
        () -> test("aabb", -1)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution firstUniqueCharacterInAString = new Solution();
    int actual = firstUniqueCharacterInAString.firstUniqChar(given);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/consecutive_characters/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/consecutive-characters/) 있습니다.

## Problem

The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.



**Example 1:**

```text
Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
```
**Example 2:**

```text
Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
```
**Example 3:**

```text
Input: s = "triplepillooooow"
Output: 5
```

**Example 4:**

```text
Input: s = "hooraaaaaaaaaaay"
Output: 11
```

**Example 5:**

```text
Input: s = "tourist"
Output: 1
```

Constraints:

* 1 <= s.length <= 500
* s consists of only lowercase English letters.

## Solution

문자열의 power를 하나의 고유 문자만 포함하는 비어 있지 않은 하위 문자열의 최대 길이라고 할 때 주어진 문자열 s의 power를 구하는 문제입니다.

단순하게 기준 문자와 비교하면서 같을 때 count를 증가시키고, max 값을 갱신하고, 다를 때 count를 초기화하고 기준 문자를 바꿔주도록 구현하였습니다.

모든 문자열이 다를 때를 대비해 마지막에도 count와 max 값 중 더 높은 값을 반환해야 합니다.

```java
public class Solution {

  public int maxPower(String s) {
    char[] chars = s.toCharArray();
    char c = chars[0];
    int cnt = 1;
    int max = 0;
    for (int i = 1; i < chars.length; i++) {
      if (c == chars[i]) {
        cnt++;
        max = Math.max(max, cnt);
      } else {
        c = chars[i];
        cnt = 1;
      }
    }
    return Math.max(max, cnt);
  }
}
```

저는 일단 생각나는 방법으로 풀어본 뒤 최적화시키거나 잘 모를 때는 답을 빨리 찾아보는 편인데, 한 방에 runtime 에서도 100%를 받아 당황스러웠습니다.

반면 메모리 측면으로는 캐릭터 배열을 따로 선언해서 그런지 45%의 점수를 획득하였는데, 메모리 측면에서 이득을 보기 위해선 배열을 따로 선언하지 않고 charAt을 사용하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.consecutive_characters;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("leetcode", 2),
        () -> test("abbcccddddeeeeedcba", 5),
        () -> test("triplepillooooow", 5),
        () -> test("hooraaaaaaaaaaay", 11),
        () -> test("tourist", 1)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxPower(given);
    // then
    assertEquals(expected, actual);
  }
}
```
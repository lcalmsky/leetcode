> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_all_anagrams_in_a_string/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-all-anagrams-in-a-string/) 있습니다.

## Problem

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


**Example 1:**
```text
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```

**Example 2:**
```text
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

**Constraints:**

* 1 <= s.length, p.length <= 3 * 10^4
* s and p consist of lowercase English letters.

## Solution

문자열 s와 p가 주어질 때, 문자열 s에서 p로 표현할 수 있는 모든 anagram을 찾아 anagram이 시작하는 인덱스를 순서에 상관없이 반환하는 문제입니다.

> anagram은 문자의 순서를 바꿔 다른 문자를 만드는 것을 말합니다.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    if (s == null) {
      return Collections.emptyList();
    }
    int sLength = s.length();
    int pLength = p.length();
    if (sLength == 0 || sLength < pLength) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    int[] pMap = new int[26];
    int[] sMap = new int[26];
    for (int i = 0; i < pLength; i++) { // (1)
      pMap[p.charAt(i) - 'a']++;
    }
    for (int i = 0; i < pLength; i++) { // (2)
      sMap[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < sLength - pLength; i++) { // (3)
      if (isMatch(pMap, sMap)) { // (4)
        result.add(i);
      }
      sMap[s.charAt(i + pLength) - 'a']++; // (5)
      sMap[s.charAt(i) - 'a']--; // (6)
    }
    if (isMatch(pMap, sMap)) { // (7)
      result.add(sLength - pLength);
    }
    return result;
  }

  public boolean isMatch(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
}
```

1. p에 나타나는 알파벳의 갯수를 저장합니다.
2. s에 나타나는 알파벳의 갯수를 처음부터 p의 길이만큼만 저장합니다.
3. 문자열 s를 순차적으로 탐색하면서
4. 두 문자열에 나타난 알파벳의 갯수가 동일한지 확인하여 동일하면 결과에 인덱스를 추가합니다.
5. 다음 인덱스에 해당하는 알파벳의 갯수를 1 증가시켜주고
6. 첫 번째 인덱스에 해당하는 알파벳의 갯수를 1 감소시킵니다.
7. s의 마지막 문자열 중 p의 길이에 해당하는 만큼 알파벳의 갯수가 일치하는지 확인하여 결과에 마지막 인덱스까지 추가해줍니다.

## Test

```java
package io.lcalmsky.leetcode.find_all_anagram_in_a_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTwoStrings_whenFindAnagram_thenCorrect() {
    assertAll(
        () -> test("cbaebabacd", "abc", List.of(0, 6)),
        () -> test("abab", "ab", List.of(0, 1, 2))
    );
  }

  private void test(String s, String p, List<Integer> expected) {
    // when
    Solution findAllAnagramInAString = new Solution();
    List<Integer> actual = findAllAnagramInAString.findAnagrams(s, p);

    // then
    assertEquals(expected, actual);
  }
}
```
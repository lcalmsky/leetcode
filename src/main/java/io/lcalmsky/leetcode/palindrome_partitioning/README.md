> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/palindrome_partitioning/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/palindrome-partitioning/) 있습니다.

## Problem

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

**Example 1:**

```text
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

**Example 2:**

```text
Input: s = "a"
Output: [["a"]]
```

**Constraints:**

* 1 <= s.length <= 16
* s contains only lowercase English letters.

## Solution

문자열 s가 주어지고, s를 나눌 때 s를 나눈 문자열이 회문이 되는 모든 경우를 반환하는 문제입니다.

DFS를 이용해 풀 수 있습니다.

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> lists = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return lists;
    }
    List<String> partitions = new ArrayList<>();
    addPalindrome(s, 0, partitions, lists);
    return lists;
  }

  private void addPalindrome(String s, int start, List<String> partitions,
      List<List<String>> lists) {
    if (start == s.length()) {
      lists.add(new ArrayList<>(partitions));
      return;
    }
    for (int i = start + 1; i <= s.length(); i++) {
      String str = s.substring(start, i);
      if (isPalindrome(str)) {
        partitions.add(str);
        addPalindrome(s, i, partitions, lists);
        partitions.remove(partitions.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--)) {
        return false;
      }
    }
    return true;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.palindrome_partitioning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenString_whenGetPalindromePartition_thenCorrect() {
    assertAll(
        () -> test("aab", List.of(
            List.of("aa", "b"),
            List.of("a", "a", "b")
        )),
        () -> test("a", List.of(List.of("a")))
    );
  }

  private void test(String given, List<List<String>> expected) {
    // when
    Solution solution = new Solution();
    List<List<String>> actual = solution.partition(given);
    // then
    assertThat(actual).containsAll(expected);
  }
}
```
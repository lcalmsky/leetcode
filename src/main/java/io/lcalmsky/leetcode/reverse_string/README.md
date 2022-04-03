> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reverse_string/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/reverse-string/) 있습니다.

## Problem

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

**Example 1:**
```text
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```
**Example 2:**
```text
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```

**Constraints:**

* 1 <= s.length <= 10^5
* s[i] is a printable ascii character.

## Solution

문자 배열이 주어질 때 해당 문자 배열을 뒤집는 기능을 구현하는 문제입니다.

상수 메모리를 추가로 사용할 수 있습니다.

변수 temp 하나만 사용해서 배열의 양 끝에서부터 swap 해주면 간단히 해결할 수 있습니다.

```java
public class Solution {

  public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right) {
      char temp = s[left];
      s[left++] = s[right];
      s[right--] = temp;
    }
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.reverse_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
        () -> test(new char[]{'H', 'a', 'n', 'n', 'a', 'h'},
            new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
    );
  }

  private void test(char[] given, char[] expected) {
    // when
    Solution solution = new Solution();
    solution.reverseString(given);
    // then
    assertArrayEquals(expected, given);
  }
}
```
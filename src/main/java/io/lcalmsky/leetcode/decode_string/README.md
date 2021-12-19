> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/decode_string/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/decode-string/) 있습니다.


## Problem

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

**Example 1:**

```text
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
```

**Example 2:**

```text
Input: s = "3[a2[c]]"
Output: "accaccacc"
```

**Example 3:**

```text
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
```

**Example 4:**

```text
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
```

**Constraints:**

* 1 <= s.length <= 30
* s consists of lowercase English letters, digits, and square brackets '[]'.
* s is guaranteed to be a valid input.
* All the integers in s are in the range [1, 300].

## Solution

인코딩 된 문자열을 정해진 규칙에따라 디코딩하는 문제입니다.

인코딩 규칙은 숫자와 대괄호로 표현하고 대괄호 안의 문자열이 앞에 숫자만큼 반복됨을 나타냅니다.

```java
import java.util.Stack;

public class Solution {

  public String decodeString(String s) {
    StringBuilder result = new StringBuilder();
    Stack<Integer> countStack = new Stack<>();
    Stack<String> resultStack = new Stack<>();
    int index = 0;
    while (index < s.length()) {
      if (Character.isDigit(s.charAt(index))) { // (1)
        int count = 0;
        while (Character.isDigit(s.charAt(index))) {
          count = 10 * count + (s.charAt(index) - '0');
          index++;
        }
        countStack.push(count);
      } else if (s.charAt(index) == '[') { // (2)
        resultStack.push(result.toString());
        result = new StringBuilder();
        index++;
      } else if (s.charAt(index) == ']') { // (3)
        StringBuilder temp = new StringBuilder(resultStack.pop());
        int repeatTimes = countStack.pop();
        temp.append(result.toString().repeat(Math.max(0, repeatTimes)));
        result = new StringBuilder(temp.toString());
        index++;
      } else { // (4)
        result.append(s.charAt(index));
        index++;
      }
    }
    return result.toString();
  }
}
```

1. 문자가 숫자일 때, 반복해야할 횟수를 구해 stack에 저장합니다. 문자열을 순차적으로 탐색하기 때문에 연달아서 숫자가 있는 경우 10의자리, 100의자리 순으로 반복 횟수가 늘어나게 됩니다.
2. 문자가 여는 대괄호([)일 때, 결과를 저장할 stack에 여태까지의 문자열을 저장합니다.
3. 문자가 닫는 대괄호(])일 때, 결과 stack에 저장된 문자열을 pop하여 반복 횟수 stack의 top에 있는 횟수만큼 반복하여 append 합니다.
4. 문자가 그냥 알파벳일 경우 결과에 더해줍니다.

## Test

```java
package io.lcalmsky.leetcode.decode_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenString_whenDecode_thenCorrect() {
    assertAll(
        () -> test("3[a]2[bc]", "aaabcbc"),
        () -> test("3[a2[c]]", "accaccacc"),
        () -> test("2[abc]3[cd]ef", "abcabccdcdcdef"),
        () -> test("abc3[cd]xyz", "abccdcdcdxyz")
    );
  }

  private void test(String given, String expected) {
    // when
    Solution decodeString = new Solution();
    String actual = decodeString.decodeString(given);
    // then
    assertEquals(expected, actual);
  }
}
```
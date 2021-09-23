> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/break_a_palindrome/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3985/) 있습니다.

## Problem

Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

**Example 1:**

```
Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.
```

**Example 2:**

```
Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
```

**Example 3:**

```
Input: palindrome = "aa"
Output: "ab"
```

**Example 4:**

```
Input: palindrome = "aba"
Output: "abb"
```

**Constraints:**

* 1 <= palindrome.length <= 1000
* palindrome consists of only lowercase English letters.

## Solution

회문(palindrome, 거꾸로 읽어도 동일한 문자열)이 주어졌을 때, 한 문자만 바꿔서 회문을 깨는 문제입니다. 단, 한 문자만 바꾸는 경우의 수는 엄청 많을 수 있으니 알파벳 순으로 가장 가까운 문자열로 바꿔줘야 합니다.

한 문자를 바꿔서 회문을 깰 수 없다면 빈 문자열을 반환합니다.

회문을 바꾸는 것이기 때문에 문자열의 길이의 반까지만 검사하면서 알파벳 순으로 반환하기 위해 앞에서부터 'a'가 아닌 경우 'a'로 바꿔준 뒤 문자열을 반환해주면 됩니다.

만약 문자열 길이의 반까지 검사했는데 아무 것도 바뀌지 않았다면 모두 'a'라는 뜻이므로 맨 뒷자리를 'b'로 변환한 뒤 반환해줍니다.

```java
public class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[chars.length - 1] = 'b';
        return String.valueOf(chars);
    }
}
```

## Test

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPalindrome_whenReplaceOneCharacter_thenBreakPalindrome() {
        assertAll(
                () -> test("abccba", "aaccba"),
                () -> test("a", ""),
                () -> test("aa", "ab"),
                () -> test("aba", "abb")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.breakPalindrome(given);

        // then
        assertEquals(expected, actual);
    }
}
```
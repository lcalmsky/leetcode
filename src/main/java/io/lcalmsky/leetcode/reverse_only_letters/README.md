> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reverse_only_letters/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/) 있습니다.

## Problem

Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

**Example 1:**

```
Input: s = "ab-cd"
Output: "dc-ba"
```

**Example 2:**

```
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
```

**Example 3:**

```
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
```

**Constraints:**

* 1 <= s.length <= 100
* s consists of characters with ASCII values in the range [33, 122].
* s does not contain '\"' or '\\'.

## Solution

문자열이 주어졌을 때 알파벳(대소문자)만 역순으로 출력하는 문제입니다.

정확히 반을 나눠서 대응하는 인덱스마다 swap 시켜주게되면 문자열도 같이 swap되기 때문에 이런 방식으로 접근하면 안 되고, 두 개의 포인터를 이용해 둘 다 알파벳인지 판단 후 두 문자를 swap 해주면 됩니다.

둘 중 하나라도 문자열이 아닌 경우 포인터를 움직여줘야 하고, 둘 다 아닐 경우 두 포인터 모두 움직여줘야 합니다.

```java
public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (Character.isAlphabetic(chars[left]) && Character.isAlphabetic(chars[right])) {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            } else if (Character.isAlphabetic(chars[left])) {
                right--;
            } else if (Character.isAlphabetic(chars[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
```

스택을 이용한 방법도 있습니다.

```java
public String reverseOnlyLetters(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (Character.isAlphabetic(c)) {
            stack.push(c);
        }
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (Character.isAlphabetic(c)) {
            stringBuilder.append(stack.pop());
        } else {
            stringBuilder.append(c);
        }
    }
    return stringBuilder.toString();
}
```

## Test

```java
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenLetters_whenReverseOnlyLetters_thenCorrect() {
        assertAll(
                () -> test("ab-cd", "dc-ba"),
                () -> test("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
                () -> test("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.reverseOnlyLetters(given);

        // then
        assertEquals(expected, actual);
    }
}
```
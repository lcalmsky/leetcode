> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/shifting_letters/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/) 있습니다.

## Problem
You are given a string s of lowercase English letters and an integer array shifts of the same length.

Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.

**Example 1:**

```
Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: We start with "abc".
After shifting the first 1 letters of s by 3, we have "dbc".
After shifting the first 2 letters of s by 5, we have "igc".
After shifting the first 3 letters of s by 9, we have "rpl", the answer.
```

**Example 2:**

```
Input: s = "aaa", shifts = [1,2,3]
Output: "gfd"
```

**Constraints:**

* 1 <= s.length <= 10^5
* s consists of lowercase English letters.
* shifts.length == s.length
* 0 <= shifts[i] <= 10^9

## Solution

주어진 문자열을 주어진 배열의 인덱스에 해당하는 값만큼 shift 시켜 반환하는 문제로 Medium 난이도 치고는 굉장히 쉬운 편입니다.

각 인덱스에 해당하는 문자열을 shift 할 때 첫 번 째 인덱스에 대해서는 첫 번 째 문자만 shift 하지만, 그 이후 인덱스에 대해서는 앞 쪽 문자까지 같이 shift 해줘야 합니다.

따라서 기존 shift 배열에 대해 실제로 shift 해야 할 횟수를 더하고 알파벳의 갯수를 나눈 나머지로 설정해주는 작업이 필요합니다.

```java
public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) { // (1)
            shifts[i] += shifts[i + 1] % 26;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < shifts.length; i++) { // (2)
            chars[i] += shifts[i] % 26;
            if (chars[i] > 'z') { // (3)
                chars[i] -= 26;
            }
        }
        return new String(chars);
    }
}
```

> (1) shift 배열의 누적 값을 계산하여 26으로 나눈 나머지를 구함  
> (2) 문자열을 탐색하면서 shift 배열에 해당하는 값만큼 shift  
> (3) shift한 값이 알파벳 소문자 범위를 넘어가면 26을 빼줌

## Test

```java
package io.lcalmsky.leetcode.shifting_letters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenStringAndShifts_whenShiftString_thenCorrect() {
        assertAll(
                () -> test("abc", new int[]{3, 5, 9}, "rpl"),
                () -> test("ruu", new int[]{26, 9, 17}, "rul"),
                () -> test("mkgfzkkuxownxvfvxasy", new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}, "wqqwlcjnkphhsyvrkdod")
        );
    }

    private void test(String S, int[] shifts, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.shiftingLetters(S, shifts);

        // then
        assertEquals(expected, actual);
    }
}
```
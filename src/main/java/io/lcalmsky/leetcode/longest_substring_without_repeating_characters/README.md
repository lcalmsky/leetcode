> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_substring_without_repeating_characters/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-substring-without-repeating-characters/) 있습니다.

## Problem

Given a string s, find the length of the longest substring without repeating characters.

**Example 1:**
```text
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

**Example 2:**
```text
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:**
```text
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
```

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

**Constraints:**

* 0 <= s.length <= 5 * 104
* s consists of English letters, digits, symbols and spaces.

## Solution

문자열 s가 주어졌을 때 반복되지 않는 가장 긴 부분 문자열의 길이를 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char key = s.charAt(end);
            if (map.containsKey(key)) {
                start = Math.max(start, map.get(key) + 1);
            }
            map.put(key, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
```

1. 우선, 입력 문자열의 길이가 0인 경우, 중복되지 않는 부분 문자열이 존재하지 않으므로 0을 반환합니다.
1. map은 문자와 해당 문자의 인덱스를 저장하는 HashMap입니다. 문자를 키로 사용하여 해당 문자의 최신 인덱스를 값으로 저장합니다.
1. maxLength는 최대 길이를 나타내는 변수로, 초기값은 0입니다.
1. 반복문에서 start와 end 변수를 사용하여 부분 문자열의 시작과 끝 인덱스를 관리합니다.
1. 반복문을 통해 문자열을 탐색하면서 각 문자를 key 변수에 저장합니다.
1. 만약 map이 해당 문자를 포함하고 있다면, 중복이 발생한 것이므로 start 값을 업데이트합니다. 이때, 중복된 문자의 이전 인덱스보다 큰 값을 start로 설정하여 중복 문자 이전의 문자는 무시합니다.
1. map에 현재 문자와 해당 인덱스를 저장합니다.
1. maxLength를 업데이트하여 현재까지의 최대 부분 문자열의 길이를 유지합니다. end - start + 1은 현재 부분 문자열의 길이를 나타냅니다.
1. 반복문이 종료되면, 최대 길이인 maxLength를 반환합니다.

이 코드는 슬라이딩 윈도우와 해시 맵을 사용하여 중복을 효율적으로 처리하고, 반복문을 한 번만 실행하여 중복되지 않는 가장 긴 부분 문자열의 길이를 구하는 효율적인 방법을 제공합니다

아래는 시간, 공간 복잡도가 더 낮은 솔루션 입니다.

```java
package io.lcalmsky.leetcode.longest_substring_without_repeating_characters;

public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int[] visited = new int[96];
        for (int end = 0; end < s.length(); end++) {
            int current = s.charAt(end) - 32;
            start = Math.max(visited[current], start);
            max = Math.max(max, end - start + 1);
            visited[current] = end + 1;
        }
        return max;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("abcabcbb", 3),
                () -> test("bbbbb", 1),
                () -> test("dvdf", 3),
                () -> test("pwwkew", 3)
        );
    }

    private void test(String s, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring(s);
        // then
        assertEquals(expected, actual);
    }
}
```
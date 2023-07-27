> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_number_of_vowels_in_a_substring_of_given_length/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) 있습니다.

## Problem

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

**Example 1:**
```text
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
```

**Example 2:**
```text
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
```

**Example 3:**
```text
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
```

**Constraints:**

* 1 <= s.length <= 10^5
* s consists of lowercase English letters.
* 1 <= k <= s.length

## Solution

주어진 문자열에서 길이가 k인 연속된 부분 문자열 중에서 모음의 최대 개수를 구하는 문제입니다.

```java
public class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (VOWELS.contains(charArray[i])) {
                currentVowels++;
            }
            int diff = (i + 1) - k;
            if (diff >= 0) {
                maxVowels = Math.max(maxVowels, currentVowels);
                if (VOWELS.contains(charArray[diff])) {
                    currentVowels--;
                }
            }
        }
        return maxVowels;
    }
}
```

1. Set<Character> VOWELS: 모음을 저장하는 Set 컬렉션입니다.
1. int maxVowels(String s, int k): 주어진 문자열 s와 길이 k를 인자로 받아서 모음의 최대 개수를 반환하는 함수입니다.
1. int maxVowels = 0;: 최대 모음 개수를 저장하는 변수를 0으로 초기화합니다.
1. int currentVowels = 0;: 현재 연속된 부분 문자열 내의 모음 개수를 저장하는 변수를 0으로 초기화합니다.
1. char[] charArray = s.toCharArray();: 주어진 문자열 s를 char 배열로 변환합니다. 이렇게 하면 문자열의 각 문자에 쉽게 접근할 수 있습니다.
1. for (int i = 0; i < charArray.length; i++): 문자열을 순회하면서 모음의 개수를 계산합니다.
1. if (VOWELS.contains(charArray[i])): 현재 문자가 모음인지 검사합니다. 모음인 경우 currentVowels를 1 증가시킵니다.
1. int diff = (i + 1) - k;: 현재 문자를 포함하여 k 길이의 연속된 부분 문자열을 유지하기 위해 필요한 문자 개수를 계산합니다.
1. if (diff >= 0): k 길이의 연속된 부분 문자열을 현재 문자열에서 구할 수 있는 경우를 확인합니다.
1. maxVowels = Math.max(maxVowels, currentVowels);: 현재 연속된 부분 문자열 내의 모음 개수(currentVowels)와 기존의 최대 모음 개수(maxVowels)를 비교하여 더 큰 값을 maxVowels에 저장합니다. 이렇게 함으로써 지금까지 탐색한 모든 부분 문자열 중에서 가장 많은 모음을 가진 부분 문자열의 모음 개수를 기록합니다.
1. if (VOWELS.contains(charArray[diff])): 만약 연속된 부분 문자열에서 제외되는 문자가 모음인 경우, 현재 모음 개수(currentVowels)를 1 감소시킵니다. 새로운 문자가 추가될 때 모음인 경우는 이미 위에서 currentVowels를 증가시켰으므로, 부분 문자열의 첫 번째 문자를 제외할 때만 이 부분이 수행됩니다.
1. 최종적으로 maxVowels에는 k 길이의 연속된 부분 문자열 중에서 가장 많은 모음의 개수가 저장되고, 이 값을 반환합니다.

주어진 문자열이 매우 길어도 k가 작다면 선형 시간 내에 해결될 수 있습니다.

아래 코드는 조금 더 최적화시킨 풀이입니다.

```java
public class Solution2 {
    public int maxVowels(String s, int k) {
        int[] vowels = new int[26];
        vowels[0] = 1;
        vowels['e' - 'a'] = 1;
        vowels['i' - 'a'] = 1;
        vowels['o' - 'a'] = 1;
        vowels['u' - 'a'] = 1;
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            vowelCount += vowels[s.charAt(i) - 'a'];
        }
        int maxVowels = vowelCount;
        for (int i = k; i < s.length(); i++) {
            vowelCount += vowels[s.charAt(i) - 'a'] - vowels[s.charAt(i - k) - 'a'];
            maxVowels = Math.max(maxVowels, vowelCount);
            if (maxVowels == k) {
                return maxVowels;
            }
        }
        return maxVowels;
    }
}
```

이 코드는 배열을 이용하여 모음의 존재 여부를 빠르게 확인하고, 문자열을 한 번만 순회하여 최대 모음 개수를 구하기 때문에 효율적입니다.

## Test

```java
package io.lcalmsky.leetcode.maximum_number_of_vowels_in_a_substring_of_given_length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("abciiidef", 3, 3),
                () -> test("aeiou", 2, 2),
                () -> test("leetcode", 3, 2)
        );
    }

    private void test(String s, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxVowels(s, k);
        // then
        assertEquals(expected, actual);
    }
}
```
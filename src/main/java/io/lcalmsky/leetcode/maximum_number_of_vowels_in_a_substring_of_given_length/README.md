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
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_number_of_balloons/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/) 있습니다.

## Problem
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

**Example 1:**

```
Input: text = "nlaebolko"
Output: 1
```

**Example 2:**

```
Input: text = "loonbalxballpoon"
Output: 2
```

**Example 3:**

```
Input: text = "leetcode"
Output: 0
```

**Constraints:**

* 1 <= text.length <= 10^4
* text consists of lower case English letters only.

## Solution

주어진 문자열을 가지고 `balloon`을 최대 몇 번 만들 수 있는지 찾는 문제입니다.

문자열에서 나타나는 알파벳 중 b, a, l, o, n의 빈도수를 구해 이 중 최솟값을 반환하면 됩니다.

l과 o는 두 개씩 필요하니 빈도수를 2로 나눠준 뒤 최솟값을 구해야 합니다.

```java
import java.util.stream.Stream;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alphabets = new int[26];
        for (char c : text.toCharArray()) {
            alphabets[c - 'a']++;
        }
        int max = alphabets[0];
        return Math.min(Math.min(Math.min(Math.min(max, alphabets[1]), alphabets[11] / 2), alphabets[14] / 2), alphabets[13]);
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.maximum_number_of_balloons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenText_whenFindBalloons_thenCorrect() {
        assertAll(
                () -> test("nlaebolko", 1),
                () -> test("loonbalxballpoon", 2),
                () -> test("leetcode", 0)
        );
    }

    private void test(String given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxNumberOfBalloons(given);

        // then
        assertEquals(expected, actual);
    }
}
```
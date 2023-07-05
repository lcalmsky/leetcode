> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/word_break/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/word-break/) 있습니다.

## Problem

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

**Example 1:**

```text
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
```

**Example 2:**

```text
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
```

**Example 3:**

```text
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
```

**Constraints:**

* 1 <= s.length <= 300
* 1 <= wordDict.length <= 1000
* 1 <= wordDict[i].length <= 20
* s and wordDict[i] consist of only lowercase English letters.
* All the strings of wordDict are unique.

## Solution

주어진 문자열 s를 주어진 단어 목록 wordDict를 사용하여 분할할 수 있는지 여부를 확인하는 문제입니다.

아래는 DP (Dynamic Programming)를 사용한 방법입니다.

```java
package io.lcalmsky.leetcode.word_break;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                int end = i + word.length();
                if (end > length) {
                    continue;
                }
                if (dp[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(word)) {
                    dp[end] = true;
                }
            }
        }
        return dp[length];
    }
}
```

1. 문자열 s의 길이를 기준으로 길이가 length + 1인 boolean 배열 dp를 생성합니다. dp[i]는 s의 처음 i개 문자가 wordDict를 사용하여 분할될 수 있는지 여부를 나타냅니다.
1. dp[0]를 true로 설정합니다. 이는 빈 문자열은 항상 wordDict로 분할 가능하다는 것을 의미합니다.
1. dp[i]를 확인하고 false인 경우, s의 현재 위치에서부터 wordDict의 각 단어를 확인합니다. 이때, end 변수는 현재 위치에서 단어의 길이만큼 이동한 위치를 나타냅니다.
1. end가 s의 길이를 초과하는 경우, 해당 단어로 분할할 수 없으므로 다음 단어로 넘어갑니다.
1. dp[end]가 true인 경우, 이미 해당 위치까지 wordDict로 분할할 수 있다는 의미이므로 다음 단어로 넘어갑니다.
1. 위의 두 조건에 해당하지 않는 경우, s의 현재 위치에서부터 end 위치까지의 부분 문자열이 word와 일치하는지 확인합니다. 일치하는 경우, dp[end]를 true로 설정합니다.
1. 모든 단어를 확인하면서 dp 배열을 업데이트하고, 마지막으로 dp[length] 값을 반환합니다. 이 값은 s를 wordDict를 사용하여 분할할 수 있는지 여부를 나타냅니다.

다음은 재귀호출을 이용한 방법입니다.

```java
package io.lcalmsky.leetcode.word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict));
    }

    private boolean wordBreak(String s, Set<String> set) {
        int restLength = s.length();
        if (restLength == 0) {
            return true;
        }
        for (int i = 1; i <= restLength; ++i) {
            if (set.contains(s.substring(0, i)) && wordBreak(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
```

1. 먼저, wordDict를 사용하기 편리하게 조회하기 위해 Set 자료구조인 set을 생성하고, wordDict의 모든 단어를 set에 추가합니다.
1. 재귀함수를 호출하여 문자열 s를 분할할 수 있는지 확인합니다. 함수는 현재 문자열 s와 set을 인자로 받습니다.
1. 재귀함수 내에서 문자열 s의 길이를 확인하여 길이가 0이라면 더 이상 분할할 수 없으므로 true를 반환합니다.
1. for 루프를 통해 s를 가능한 모든 위치에서 분할해보고, 분할된 부분 문자열이 set에 포함되는지 확인합니다.
1. 만약 set에 포함된다면, 해당 부분 문자열을 제외한 나머지 문자열에 대해 재귀적으로 함수를 호출합니다.
1. 재귀 호출 결과가 true라면, 현재 위치에서 분할이 가능하다는 의미이므로 true를 반환합니다.
1. 모든 위치에서의 분할 시도가 실패한 경우, 분할이 불가능하다는 의미로 false를 반환합니다.

> 이 방법은 시간 초과로 통과되지 않네요. 예시가 업데이트 된 거 같습니다.

## Test

```java
package io.lcalmsky.leetcode.word_break;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("leetcode", List.of("leet", "code"), true),
                () -> test("applepenapple", List.of("apple", "pen"), true),
                () -> test("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }

    private void test(String s, List<String> wordDict, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.wordBreak(s, wordDict);
        // then
        assertEquals(expected, actual);
    }

}
```
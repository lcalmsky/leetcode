> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/slowest_key/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3965/) 있습니다.

## Problem

A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.

You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released. Both arrays are 0-indexed. The 0th key was pressed at the time 0, and every subsequent key was pressed at the exact time the previous key was released.

The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].

Note that the same key could have been pressed multiple times during the test, and these multiple presses of the same key may not have had the same duration.

Return the key of the keypress that had the longest duration. If there are multiple such keypresses, return the lexicographically largest key of the keypresses.

**Example 1:**

```
Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
Output: "c"
Explanation: The keypresses were as follows:
Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after the release of the previous character and released at time 29).
Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after the release of the previous character and released at time 49).
Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after the release of the previous character and released at time 50).
The longest of these was the keypress for 'b' and the second keypress for 'c', both with duration 20.
'c' is lexicographically larger than 'b', so the answer is 'c'.
```

**Example 2:**

```
Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
Output: "a"
Explanation: The keypresses were as follows:
Keypress for 's' had a duration of 12.
Keypress for 'p' had a duration of 23 - 12 = 11.
Keypress for 'u' had a duration of 36 - 23 = 13.
Keypress for 'd' had a duration of 46 - 36 = 10.
Keypress for 'a' had a duration of 62 - 46 = 16.
The longest of these was the keypress for 'a' with duration 16.
```

**Constraints:**

* releaseTimes.length == n
* keysPressed.length == n
* 2 <= n <= 1000
* 1 <= releaseTimes[i] <= 10^9
* releaseTimes[i] < releaseTimes[i+1]
* keysPressed contains only lowercase English letters.

## Solution

가장 오랫동안 눌린 키를 찾는 문제인데 눌린 시간이 동일할 경우 사전식 순서로 비교하여 결과를 반환해야 합니다.

난이도도 낮고 워낙 쉬운 문제라 바로 소스 코드로 설명을 대체하겠습니다.

```java
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxReleaseTime = releaseTimes[0];
        int maxIndex = 0;
        for (int i = 1; i < releaseTimes.length; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > maxReleaseTime) { // 차이가 가장 클 때의 시간과 인덱스를 구함
                maxIndex = i;
                maxReleaseTime = diff;
            } else if (diff == maxReleaseTime) { // 차이가 가장 클 때와 같을 때는 사전식 순서로 더 큰 인덱스를 구함
                maxIndex = keysPressed.charAt(maxIndex) > keysPressed.charAt(i) ? maxIndex : i;
            }
        }
        return keysPressed.charAt(maxIndex); // 해당 인덱스의 키를 반환
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
    void givenKeysAndTimes_whenReturnKeyOfLongestDuration_thenCorrect() {
        assertAll(
                () -> test(new int[]{9, 29, 49, 50}, "cbcd", 'c'),
                () -> test(new int[]{12, 23, 36, 46, 62}, "spuda", 'a')
        );
    }

    private void test(int[] releasedTimes, String keysPressed, char expected) {
        // when
        Solution solution = new Solution();
        char actual = solution.slowestKey(releasedTimes, keysPressed);

        // then
        assertEquals(expected, actual);
    }
}
```
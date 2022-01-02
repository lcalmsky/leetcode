> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/pairs_of_songs_with_total_durations_divisible_by_60/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/) 있습니다.

## Problem

You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

**Example 1:**

```text
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
```

**Example 2:**

```text
Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
```

**Constraints:**

* 1 <= time.length <= 6 * 10^4
* 1 <= time[i] <= 500

## Solution

노래 길이로 구성된 배열이 주어질 때 60으로 나눠지는 노래의 쌍의 갯수를 모두 구하는 문제입니다.

단순히 생각하면 O(N^2)으로 반복문 안에 반복문을 사용하여 매 번 계산하여 카운팅 하는 방식을 떠올릴 수 있는데 시간 복잡도를 줄이기 위해서 Map을 사용할 수 있습니다.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numPairsDivisibleBy60(int[] time) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int t : time) {
      int duration = (60 - t % 60) % 60; // (1)
      if (map.containsKey(duration)) { // (2)
        result += map.get(duration);
      }
      map.put(t % 60, map.getOrDefault(t % 60, 0) + 1); // (3)  
    }
    return result;
  }
}
```

1. 합해서 60을 만들어야 하기 때문에 60에서 시간을 빼주는데 나중에 60으로 나눈 나머지를 구해야 하므로 미리 나눠서 차를 구해줍니다. 차이가 60이 될 경우를 대비해 한 번 더 60으로 나눈 결과를 저장합니다.
2. Map의 Key는 앞으로 얼마를 더해야 60이 되는지를 나타내므로 해당 키가 존재할 경우 이전 값에 현재 값을 더하면 60이 된다는 의미이므로 결과 값을 1 더해줍니다.
3. 키가 존재하지 않으면 Map에 저장하는데 저장할 때의 키는 현재 노래 시간을 60으로 나눈 나머지 입니다. 이렇게 저장해야 (1)번에서 계산한 결과와 합했을 때 60이 됩니다.

## Test

```java
package io.lcalmsky.leetcode.pairs_of_songs_with_total_durations_divisible_by_60;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void numPairsDivisibleBy60() {
    assertAll(
        () -> test(new int[]{30, 20, 150, 100, 40}, 3),
        () -> test(new int[]{60, 60, 60}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numPairsDivisibleBy60(given);
    // then
    assertEquals(expected, actual);
  }
}
```
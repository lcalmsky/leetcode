> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/remove_covered_intervals/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/remove-covered-intervals/) 있습니다.

## Problem

Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.

**Example 1:**
```text
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
```
**Example 2:**
```text
Input: intervals = [[1,4],[2,3]]
Output: 1
```

**Constraints:**

* 1 <= intervals.length <= 1000
* intervals[i].length == 2
* 0 <= li <= ri <= 10^5
* All the given intervals are unique.

## Solution

인터벌 배열이 주어질 때 겹치는 인터벌을 제외하고 남은 인터벌의 개수를 반환하는 문제입니다.

```java
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // (1)
    int[] currentIndices = { -1, -1 }; // (2)
    int result = 0;
    for (int[] interval : intervals) {
      if (currentIndices[0] < interval[0] && currentIndices[1] < interval[1]) { // (3)
        currentIndices[0] = interval[0];
        result++;
      }
      currentIndices[1] = Math.max(currentIndices[1], interval[1]); // (4)
    }
    return result;
  }
}
```

1. 인터벌의 첫 번째 원소로 정렬합니다.
2. 인터벌과 순차적으로 비교하기 위한 배열을 생성합니다.
3. 현재 범위와 겹치는 경우 현재 범위의 시작 부분을 갱신하고 결과를 1 증가시킵니다.
4. 현재 범위의 끝부분을 인터벌과 비교해 더 높은 값으로 갱신합니다.

## Test
```java
package io.lcalmsky.leetcode.remove_covered_intervals;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 4}, {3, 6}, {2, 8}}, 2),
        () -> test(new int[][]{{1, 4}, {2, 3}}, 1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.removeCoveredIntervals(given);
    // then
    assertEquals(expected, actual);
  }
}
```
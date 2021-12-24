> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/merge_intervals/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/merge-intervals/) 있습니다.

## Problem

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

**Example 1:**

```text
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

**Example 2:**

```text
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

**Constraints:**

* 1 <= intervals.length <= 10^4
* intervals[i].length == 2
* 0 <= starti <= endi <= 10^4

## Solution

시작과 끝 인덱스를 가진 배열이 존재할 때 중복되는 부분을 모두 합친 배열을 반환하는 문제입니다.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0 || intervals.length == 1) {
      return intervals;
    }
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); // (1)
    List<int[]> list = new ArrayList<>();
    int[] interval = intervals[0]; // (2)
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= interval[1]) { // (3)
        interval[1] = Math.max(intervals[i][1], interval[1]); 
      } else { // (4)
        list.add(interval);
        interval = intervals[i];
      }
    }
    list.add(interval);
    int[][] result = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}

```

1. 시작을 기준으로 정렬해줍니다.
2. 비교할 기준을 지정합니다.
3. 기준의 끝이 다음 interval의 시작보다 큰 경우, 현재 끝 값과 비교 대상의 끝 값중 더 큰 값으로 끝 값을 갱신합니다.
4. 기준의 끝이 다음 interval의 시작보다 작은 경우 기존 interval을 결과에 추가하고 기준 값을 갱신합니다.

## Test

```java
package io.lcalmsky.leetcode.merge_intervals;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTwoDimensionArray_whenMergeIntervals_thenCorrect() {
    assertAll(
        () -> test(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
            new int[][]{{1, 6}, {8, 10}, {15, 18}}),
        () -> test(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
        () -> test(new int[][]{}, new int[][]{})
    );
  }

  public void test(int[][] given, int[][] expected) {
    // when
    Solution mergeIntervals = new Solution();
    int[][] result = mergeIntervals.merge(given);

    System.out.println(Arrays.deepToString(result));

    // then
    assertArrayEquals(expected, result);
  }
}
```
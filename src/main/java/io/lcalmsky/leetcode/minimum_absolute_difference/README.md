> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_absolute_difference/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-absolute-difference/) 있습니다.

## Problem

Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

* a, b are from arr
* a < b
* b - a equals to the minimum absolute difference of any two elements in arr


**Example 1:**

```text
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
```

**Example 2:**

```text
Input: arr = [1,3,6,10,15]
Output: [[1,3]]
```

**Example 3:**

```text
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
```

**Constraints:**

* 2 <= arr.length <= 10^5
* -10^6 <= arr[i] <= 10^6

## Solution

중복되지 않는 정수 배열이 주어졌을 때 두 원소의 차이가 최소가 되는 모든 쌍을 찾아 반환하는 문제입니다.

아주 단순하게 생각하면 간단히 풀리는 문제로, 먼저 배열을 정렬한 뒤 최소 차이를 구하고, 다시 한 번 탐색하면서 최소 차이와 같을 때 리스트에 추가해주면 쉽게 해결할 수 있습니다.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < arr.length; i++) {
      min = Math.min(min, arr[i] - arr[i - 1]);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] == min) {
        result.add(List.of(arr[i - 1], arr[i]));
      }
    }
    return result;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.minimum_absolute_difference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{4, 2, 1, 3}, List.of(
            List.of(1, 2),
            List.of(2, 3),
            List.of(3, 4)
        )),
        () -> test(new int[]{1, 3, 6, 10, 15}, List.of(
            List.of(1, 3)
        )),
        () -> test(new int[]{3, 8, -10, 23, 19, -4, -14, 27}, List.of(
            List.of(-14, -10),
            List.of(19, 23),
            List.of(23, 27)
        ))
    );
  }

  private void test(int[] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.minimumAbsDifference(given);
    // then
    assertEquals(expected, actual);
  }
}
```
=======

## Test

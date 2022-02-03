> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/4sum_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/4sum-ii/) 있습니다.

## Problem

Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

* 0 <= i, j, k, l < n
* nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

**Example 1:**
```text
Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
```
**Example 2:**
```text
Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
```

**Constraints:**

* n == nums1.length
* n == nums2.length
* n == nums3.length
* n == nums4.length
* 1 <= n <= 200
* -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28

## Solution

길이가 n인 네 개의 정수 배열이 주어질 때 다음 조건을 만족하는 튜플의 갯수를 반환하는 문제입니다.

1. 0 <= i, j, k, l < n
2. nums1[i] + nums1[j] + nums1[k] + nums1[l] = 0

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int i : nums1) { // (1)
      for (int j : nums2) {
        int sum = i + j;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    for (int i : nums3) { // (2)
      for (int j : nums4) {
        int sum = i + j;
        if (map.containsKey(-sum)) {
          result += map.get(-sum);
        }
      }
    }
    return result;
  }
}
```

1. nums1, nums2 배열을 순차적으로 탐색하면서 합을 맵에 저장합니다. 합이 키, 합이 나타나는 빈도수가 값 입니다.
2. nums3, nums4 배열을 순차적으로 탐색하면서 합의 부호를 바꿔서 해당 키가 존재한다면 현재 sum과의 합이 0이된다는 뜻이고 그 합을 이뤘던 조합의 갯수만큼 반환할 튜플의 갯수가 증가하게 됩니다.

## Test

```java
package io.lcalmsky.leetcode._4sum_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2),
        () -> test(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, 1)
    );
  }

  private void test(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.fourSumCount(nums1, nums2, nums3, nums4);
    // then
    assertEquals(expected, actual);
  }
}
```
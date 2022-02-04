> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/contiguous_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/contiguous-array/) 있습니다.

## Problem

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

**Example 1:**
```text
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
```
**Example 2:**
```text
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
```

**Constraints:**

* 1 <= nums.length <= 10^5
* nums[i] is either 0 or 1.

## Solution

이진 배열이 주어질 때 0과 1의 개수가 동일하게 연속되는 부분 배열의 최대 길이를 구하는 문제입니다.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> countToIndex = new HashMap<>(); // (1)
    countToIndex.put(0, -1);
    int sum = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i] == 1 ? 1 : -1; // (2) 
      if (countToIndex.containsKey(sum)) { // (3)
        max = Math.max(max, i - countToIndex.get(sum)); // (4)
      } else {
        countToIndex.put(sum, i); // (5)
      }
    }
    return max;
  }
}

```

1. 해당 인덱스까지의 연속된 개수를 저장할 맵을 선언 및 초기화합니다.
2. 배열을 순차적으로 탐색하면서 1이면 더하고 0이면 1을 빼줍니다.
3. 위에서 더한 값을 키로 갖고있다면
4. 현재 인덱스에서 해당 인덱스까지의 합을 빼준 값과 최댓값을 비교하여 최댓값을 갱신하고
5. 그렇지 않을 경우 더한 값에 해당하는 인덱스를 저장합니다.

## Test

```java
package io.lcalmsky.leetcode.contiguous_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNumbers_whenFindTheMaximumLengthOfAContiguousSubarray_thenCorrect() {
    assertAll(
        () -> test(new int[]{0, 1}, 2),
        () -> test(new int[]{0, 1, 0}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution contiguousArray = new Solution();
    int actual = contiguousArray.findMaxLength(given);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/summary_ranges/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/summary-ranges/) 있습니다.

## Problem

You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

**Example 1:**
```text
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
```
**Example 2:**
```text
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
```


**Constraints:**

* 0 <= nums.length <= 20
* -2^31 <= nums[i] <= 2^31 - 1
* All the values of nums are unique.
* nums is sorted in ascending order.

## Solution

정렬되어있고 중복되지 않는 정수로 이루어진 배열이 주어질 때 배열 내 모든 정수를 커버할 수 있는 범위로 이루어진 가장 작은 리스트를 반환하는 문제입니다.

범위는 화살표(->)로 나타내고 범위가 아닐 경우 정수로 나타냅니다.

배열을 순차적으로 비교하면서 1이상 차이날 때 커버할 수 있는 범위를 벗어난 것이므로 비교하던 숫자로 범위를 만들어주면 됩니다.

```java
package io.lcalmsky.leetcode.summary_ranges;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<String> summaryRanges(int[] nums) {
    LinkedList<String> result = new LinkedList<>();
    int length = nums.length;
    if (length == 0) {
      return result;
    }
    int left = 0;
    for (int i = 1; i < length + 1; i++) {
      if (i == length || nums[i] != nums[i - 1] + 1) {
        if (i - 1 == left) {
          result.add(String.valueOf(nums[left]));
        } else {
          result.add(String.format("%d->%d", nums[left], nums[i - 1]));
        }
        left = i;
      }
    }
    return result;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.summary_ranges;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
        () -> test(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9"))
    );
  }

  private void test(int[] given, List<String> expected) {
    // when
    Solution solution = new Solution();
    List<String> actual = solution.summaryRanges(given);
    // then
    assertEquals(expected, actual);
  }
}
```
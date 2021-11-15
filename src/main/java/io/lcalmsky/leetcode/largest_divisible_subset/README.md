> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/largest_divisible_subset/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/largest-divisible-subset/) 있습니다.

## Problem

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

**Example 1:**

```text
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
```

**Example 2:**

```text
Input: nums = [1,2,4,8]
Output: [1,2,4,8]
```

**Constraints:**

* 1 <= nums.length <= 1000
* 1 <= nums[i] <= 2 * 10^9
* All the integers in nums are unique.

## Solution

주어진 배열의 가장 큰 부분 배열을 반환하는데, 이 때 조건은 부분 배열의 모든 Pair가 약수 관계여야 한다는 것입니다.

배열을 정렬한 뒤 탐색하면서 현재 인덱스와 이전 인덱스들에 해당하는 값들을 비교하여 약수 관계가 성립할 때 총 갯수와 이전 인덱스를 매번 갱신하는 형태로 DP를 이용해 풀 수 있습니다.

갱신할 때 조건은 이전 값 보다 높아야 한다는 것인데 최대 크기의 배열을 구하기 위함입니다.

```java
package io.lcalmsky.leetcode.largest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int[] count = new int[nums.length];
    int[] previous = new int[nums.length];
    int max = 0;
    int index = -1;
    for (int i = 0; i < nums.length; i++) {
      count[i] = 1;
      previous[i] = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          if (1 + count[j] > count[i]) {
            count[i] = count[j] + 1;
            previous[i] = j;
          }
        }
      }
      if (count[i] > max) {
        max = count[i];
        index = i;
      }
    }
    List<Integer> result = new ArrayList<>();
    while (index != -1) {
      result.add(nums[index]);
      index = previous[index];
    }
    return result;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.largest_divisible_subset;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, List.of(1, 2)),
        () -> test(new int[]{1, 2, 4, 8}, List.of(1, 2, 4, 8))
    );
  }

  private void test(int[] given, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.largestDivisibleSubset(given);
    // then
    assertEquals(expected, actual);
  }

}
```
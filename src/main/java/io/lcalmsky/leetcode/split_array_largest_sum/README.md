> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/split_array_largest_sum/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/split-array-largest-sum/) 있습니다.

## Problem

Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

**Example 1:**
```text
Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
```
**Example 2:**
```text
Input: nums = [1,2,3,4,5], m = 2
Output: 9
```
**Example 3:**
```text
Input: nums = [1,4,4], m = 3
Output: 4
```


**Constraints:**

* 1 <= nums.length <= 1000
* 0 <= nums[i] <= 10^6
* 1 <= m <= min(50, nums.length)

## Solution

음이 아닌 정수로 구성된 배열과 정수 m이 주어질 배열을 비어있지 않은 m개의 연속된 부분 배열로 분할할 수 있습니다.

m개의 부분 배열 중 가장 큰 합이 최소가 되는 값을 구하는 문제입니다.

```java
public class Solution {

  public int splitArray(int[] nums, int m) {
    // (1)
    int max = 0;
    long sum = 0;
    for (int num : nums) {
      max = Math.max(num, max);
      sum += num;
    }
    // (2)
    if (m == 1) {
      return (int) sum;
    }
    // (3)
    long left = max;
    long right = sum;
    while (left <= right) {
      long mid = (left + right) / 2;
      // (5)
      if (valid(mid, nums, m)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) left;
  }

  public boolean valid(long target, int[] nums, int m) {
    int count = 1;
    long total = 0;
    // (4)
    for (int num : nums) {
      total += num;
      if (total > target) {
        total = num;
        count++;
        if (count > m) {
          return false;
        }
      }
    }
    return true;
  }
}
```

1. 답은 배열 숫자 중 최댓값과 배열 숫자 전체 합의 사이이므로 최댓값과 합을 먼저 구합니다.
2. m이 1일 경우 최댓값이나 합 둘 중 하나를 반환합니다.
3. 최댓값부터 전체 합까지의 사이를 이진탐색하면서 답을 구합니다.
4. 부분 배열은 연속된 배열이므로 중간값보다 커지는 순간까지 배열의 합을 구하면서 count 값을 증가시키고 count가 m보다 커지면 false를, 그렇지 않으면 true를 반환합니다.
5. 4번의 결과에 따라 범위를 좁혀나가다 left == right가 되는 순간 left를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.split_array_largest_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{7, 2, 5, 10, 8}, 2, 18),
        () -> test(new int[]{1, 2, 3, 4, 5}, 2, 9),
        () -> test(new int[]{1, 4, 4}, 3, 4)
    );
  }

  private void test(int[] nums, int m, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.splitArray(nums, m);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/two_sum_ii_input_array_is_sorted/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) 있습니다.

## Problem

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

**Example 1:**
```text
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
```
**Example 2:**
```text
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
```
**Example 3:**
```text
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
```


**Constraints:**

* 2 <= numbers.length <= 3 * 10^4
* -1000 <= numbers[i] <= 1000
* numbers is sorted in non-decreasing order.
* -1000 <= target <= 1000
* The tests are generated such that there is exactly one solution.

## Solution

감소하지 않는 이미 정렬된 1로 시작하는 인덱스 배열이 주어집니다.

배열 내 두 숫자를 더해 target을 만들 때 두 인덱스를 반환합니다.

인덱스는 1부터 시작하기 떄문에 1 <= index <= n 의 범위를 가집니다.

```java
package io.lcalmsky.leetcode.two_sum_ii_input_array_is_sorted;

public class Solution {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum < target) {
        left++;
      } else if (sum > target) {
        right--;
      } else {
        return new int[]{left + 1, right + 1};
      }
    }
    throw new IllegalStateException("cannot reach here");
  }
}
```

처음부터 시작하는 포인터와 마지막부터 시작하는 포인터를 이용해 합을 구하면서 포인터를 이동시키고 정확히 일치하는 답이 나왔을 때 답을 반환합니다.

문제에서 답은 하나밖에 없다고 했으므로 처음 찾은 답이 정답이고 반환시에 인덱스 값을 1씩 올려주어야 합니다.

## Test

```java
package io.lcalmsky.leetcode.two_sum_ii_input_array_is_sorted;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenSumTwoElements_thenGetIndices() {
    assertAll(
        () -> test(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
        () -> test(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
        () -> test(new int[]{-1, 0}, -1, new int[]{1, 2})
    );
  }

  private void test(int[] given, int target, int[] expected) {
    // when
    Solution twoSumInputArrayIsSorted = new Solution();
    int[] actual = twoSumInputArrayIsSorted.twoSum(given, target);

    // then
    assertArrayEquals(expected, actual);
  }
}
```
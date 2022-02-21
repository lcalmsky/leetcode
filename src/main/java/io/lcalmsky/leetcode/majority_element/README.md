> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/majority_element/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/majority-element/) 있습니다.

## Problem

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

**Example 1:**
```text
Input: nums = [3,2,3]
Output: 3
```
**Example 2:**
```text
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

**Constraints:**

* n == nums.length
* 1 <= n <= 5 * 10^4
* -2^31 <= nums[i] <= 2^31 - 1

**Follow-up:** Could you solve the problem in linear time and in O(1) space?

## Solution

n개의 원소를 가진 정수 배열이 주어질 때, 과반수 이상 등장하는 원소를 반환하는 문제입니다.

과반수 이상 등장하는 원소는 반드시 한 개 존재하고, 선형 시간 내에 추가 공간 O(1)만 사용하여 풀어볼 것을 권장하고 있습니다.

과반수 이상 등장한다는 의미는 다른 원소의 개수를 모두 합한 것보다 많다는 뜻이므로 아래 처럼 간단히 풀이할 수 있습니다.

```java
public class Solution {

  public int majorityElement(int[] nums) {
    int result = 0, count = 0;
    for (int num : nums) {
      if (count == 0) { // (1)
        result = num;
        count = 1;
      } else if (result == num) { // (2)
        count++;
      } else { // (3)
        count--;
      }
    }
    return result;
  }
}
```

1. 기준이 되는 숫자를 바꿔줍니다.
2. 같은 수가 등장하면 count를 증가시킵니다.
3. 다른 수가 등장하면 count를 감소시킵니다.

## Test

```java
package io.lcalmsky.leetcode.majority_element;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindMajorElement_thenCorrect() {
    assertAll(
        () -> test(new int[]{3, 2, 3}, 3),
        () -> test(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.majorityElement(given);
    // then
    assertEquals(expected, actual);
  }
}
```
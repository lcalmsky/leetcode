> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_conssecutive_sequence/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-conssecutive-sequence/) 있습니다.

## Problem

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

**Example 1:**
```text
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

**Example 2:**
```text
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

Constraints:

* 0 <= nums.length <= 10^5
* -10^9 <= nums[i] <= 10^9

## Solution

정렬되지 않은 정수 배열이 주어질 때 가장 길게 연속되는 부분 배열의 길이를 구하는 문제입니다.

```java
import java.util.Arrays;

public class Solution {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int longest = 1;
    int current = 1;
    for (int i = 1; i < nums.length; i++) {
      int currentNumber = nums[i];
      int previousNumber = nums[i - 1];
      if (currentNumber == previousNumber) {
        continue;
      }
      if (currentNumber == previousNumber + 1) { // (1)
        current += 1; // (2)
      } else { // (3)
        longest = Math.max(longest, current); // (4)
        current = 1; // (5)
      }
    }
    return Math.max(longest, current);
  }
}
```

(1) 현재 숫자와 이전 숫자가 연속될 때  
(2) 현재 세고있는 길이를 1 증가시킵니다.  
(3) 연속되지 않을 경우  
(4) max 값을 갱신합니다.  
(5) 현재 길이를 1로 초기화 합니다.  

## Test

```java
package io.lcalmsky.leetcode.longest_consecutive_sequence;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenGetLongestConsecutiveSequence_thenCorrect() {
    assertAll(
        () -> test(new int[]{100, 4, 200, 1, 3, 2}, 4),
        () -> test(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.longestConsecutive(given);
    // then
    assertEquals(expected, actual);
  }
}
```
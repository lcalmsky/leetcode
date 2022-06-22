> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/kth_largest_element_in_an_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/kth-largest-element-in-an-array/) 있습니다.

## Problem

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

**Example 1:**
```text
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

**Example 2:**
```text
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

**Constraints:**

* 1 <= k <= nums.length <= 10^4
* -10^4 <= nums[i] <= 10^4

## Solution

정수 배열과 정수 k가 주어질 때, 배열 내에서 k번째로 큰 원소를 반환하는 문제입니다.

이 문제는 어이없게도(?) 

```java
import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```

이렇게도 풀립니다.

하지만 문제가 의도하는 건 이런 방식의 풀이가 아니겠죠?

우선순위 큐를 이용하면 간단히 해결할 수 있습니다.

```java
import java.util.PriorityQueue;

public class Solution {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int num : nums) {
      priorityQueue.offer(num);
    }
    while (priorityQueue.size() > k) {
      priorityQueue.poll();
    }
    if (priorityQueue.isEmpty()) {
      throw new IllegalStateException();
    }
    return priorityQueue.poll();
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.kth_largest_element_in_an_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNumbers_whenFindKthNumber_thenCorrect() {
    assertAll(
        () -> test(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
        () -> test(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
    );
  }

  private void test(int[] nums, int k, int expected) {
    // when
    Solution kthLargestElementInAnArray = new Solution();
    int actual = kthLargestElementInAnArray.findKthLargest(nums, k);

    // then
    assertEquals(expected, actual);
  }
}
```
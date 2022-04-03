> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/next_permutation/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/next-permutation/) 있습니다.

## Problem

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

**Example 1:**
```text
Input: nums = [1,2,3]
Output: [1,3,2]
```
**Example 2:**
```text
Input: nums = [3,2,1]
Output: [1,2,3]
```
**Example 3:**
```text
Input: nums = [1,1,5]
Output: [1,5,1]
```


**Constraints:**

* 1 <= nums.length <= 100
* 0 <= nums[i] <= 100

## Solution

정수 배열의 순열은 시퀀스 또는 선형 순서로 배열하는 것입니다.

정수 배열이 주어졌을 때 해당 배열의 순열 중 다음 순서에 해당하는 배열을 구하는 문제입니다.

순열은 처음엔 오름차순으로 정렬되어있지만 이후엔 바뀔 수 있으므로 뒤에서부터 처음으로 감소하는 구간을 찾습니다.

아래와 같이 뒤에서부터 계속 증가하는 배열의 경우 순열의 마지막 배열이므로 거꾸로 뒤집기만 하면 됩니다.

```text
[5, 4, 3, 2, 1] -(next permutation)-> [1, 2, 3, 4, 5]
```

그렇지 않은 경우엔 반드시 아래 배열처럼 감소하는 구간이 존재합니다.

```text
[5, 3, 4, 2, 1]
    ^
4에서 3으로 감소함
```

감소할 때의 수 3과, 3 뒤의 숫자 중 3보다 큰 숫자를 swap 해줍니다.

```text
[5, 3, 4, 2, 1] -(swap)-> [5, 4, 3, 2, 1] 
```

그리고 바뀐 숫자부터 나머지 뒷 부분을 reverse 해주면 처음 주어진 배열의 다음 순열이 됩니다.

```text
[5, 4, 3, 2, 1] -(reverse)-> [5, 4, 1, 2, 3]
       ^
```

코드로 표현하면 아래와 같습니다.

```java
public class Solution {

  public void nextPermutation(int[] nums) {
    // (1)
    int i = nums.length - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      // (2)
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    // (3)
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
```

1. 뒤에서부터 감소하는 구간을 찾습니다.
2. 감소가 시작된 구간의 수보다 큰 수를 찾아 swap 합니다.
3. swap 한 숫자 이후 뒷부분을 뒤집어 줍니다.

## Test

```java
package io.lcalmsky.leetcode.next_permutation;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, new int[]{1, 3, 2}),
        () -> test(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
        () -> test(new int[]{1, 1, 5}, new int[]{1, 5, 1})
    );
  }

  private void test(int[] given, int[] expected) {
    // when
    Solution solution = new Solution();
    solution.nextPermutation(given);
    // then
    assertArrayEquals(expected, given);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/valid_mountain_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/valid-mountain-array/) 있습니다.

## Problem

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

![](https://assets.leetcode.com/uploads/2019/10/20/hint_valid_mountain_array.png)

**Example 1:**
```text
Input: arr = [2,1]
Output: false
```
**Example 2:**
```text
Input: arr = [3,5,5]
Output: false
```
**Example 3:**
```text
Input: arr = [0,3,2,1]
Output: true
```

**Constraints:**

* 1 <= arr.length <= 10^4
* 0 <= arr[i] <= 10^4

## Solution

계속 증가하다가 특정 시점부터 계속 감소하는 배열(문제의 그림 참조)을 mountain array라고 하는데 주어진 배열이 mountain array인지 여부를 반환하는 문제입니다.

```java
public class Solution {

  public boolean validMountainArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int length = arr.length - 1;
    while (left + 1 < length && arr[left] < arr[left + 1]) { // (1)
      left++;
    }
    while (right > 0 && arr[right] < arr[right - 1]) { // (2)
      right--;
    }
    return (left > 0 && left == right && right < length); // (3)
  }
}
```

1. 왼쪽부터 증가하는동안 포인터를 이동시킵니다.
2. 오른쪽부터 감소하는동안 포인터를 이동시킵니다.
3. 두 포인터가 범위 안에 있고 동일한 곳을 가리키면 mountain array 입니다.

## Test

```java
package io.lcalmsky.leetcode.valid_mountain_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 1}, false),
        () -> test(new int[]{3, 5, 5}, false),
        () -> test(new int[]{0, 3, 2, 1}, true)
    );
  }

  private void test(int[] given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.validMountainArray(given);
    // then
    assertEquals(expected, actual);
  }
}
```
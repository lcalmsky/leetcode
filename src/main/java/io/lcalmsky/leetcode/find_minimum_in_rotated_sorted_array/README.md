> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_minimum_in_rotated_sorted_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3958/) 있습니다.

## Problem

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums
= [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2],
..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

**Example 1:**

```
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
```

**Example 3:**

```
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
```

**Constraints:**

* n == nums.length
* 1 <= n <= 5000
* -5000 <= nums[i] <= 5000
* All the integers of nums are unique.
* nums is sorted and rotated between 1 and n times.

## Solution

오름차순을 오른쪽으로 회전시킨 배열이 주어질 때 이 배열의 원소중 최솟값을 구하는 문제입니다.

시간 복잡도 O(log n) 안에 최솟값을 찾아야하기 때문에 순차적으로 탐색하면서 가장 낮은 값을 찾는 방식을 사용하면 O(n)이 되어 문제를 통과하지 못하겠죠?

두 개의 포인터를 사용해 왼쪽 포인터의 값이 오른쪽 포인터의 값보다 작아지는 순간에 왼쪽 포인터의 값을 반환하면 간단히 답을 찾을 수 있습니다.

```text
[6, 7, (1), 2, 3, 4, 5]
        ^            ^
```

이 때 매 번 중간값을 다시 계산해야 O(log n) 안에 수행될 수 있고, 각 포인터를 움직이는 조건은 중간값과 비교하여 결정합니다.

왼쪽 포인터의 값이 중간값보다 큰 경우 최솟값은 그 사이에 위치하게 되므로 오른쪽 포인터의 위치를 중간값의 위치로 바꿔줍니다.

```text
[7, (1), 2, 3, 4, 5, 6]
 ^          ^ <----- ^
```

반대로 왼쪽 포인터의 값이 중간값보다 작거나 같은 경우 최솟값은 중간값과 오른쪽 포인터 사이에 위치하게 되므로 왼쪽 포인터의 위치를 중간값의 다음 위치로 바꿔줍니다.

```text
[4, 5, 6, 7, (1), 2, 3]
 ^        ^          ^
 -----------> ^
```

여기서 왼쪽 포인터가 최솟값일 경우는 앞에 조건에서 걸러지기 때문에 생각할 필요가 없습니다.

이 내용을 구현하면 아래와 같습니다.

```java
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            int m = (left + right) / 2;
            if (nums[m] >= nums[left]) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return -1;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.find_minimum_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void givenArray_whenFindMinimum_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 4, 5, 1, 2}, 1),
                () -> test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                () -> test(new int[]{3, 1, 2}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.findMin(given);

        // then
        assertEquals(expected, actual);
    }
}
```
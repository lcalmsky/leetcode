> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_first_and_last_position_of_element_in_sorted_array/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) 있습니다.

## Problem

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

**Example 1:**
```text
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**
```text
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

**Example 3:**
```text
Input: nums = [], target = 0
Output: [-1,-1]
```

**Constraints:**

* 0 <= nums.length <= 10^5
* -10^9 <= nums[i] <= 10^9
* nums is a non-decreasing array.
* -10^9 <= target <= 10^9

## Solution

감소하지 않는 순서로 정렬된 배열이 주어질 때, 목표 값의 시작과 끝을 찾아서 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target); // 1
        if (start == nums.length || nums[start] != target) { // 2
            return new int[]{-1, -1};
        }
        int end = firstGreaterEqual(nums, target + 1) - 1; // 3
        return new int[]{start, end}; // 4
    }

    private int firstGreaterEqual(int[] nums, int target) { // 5
        int low = 0, high = nums.length; // 6
        while (low < high) { // 7
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // 8
    }
}

```

1. 먼저 `firstGreaterEqual` 메서드를 호출하여 시작 위치를 찾습니다. 이 위치는 주어진 `target` 값보다 크거나 같은 첫 번째 원소의 인덱스입니다.
2. 만약 시작 위치가 `nums` 배열의 길이와 동일하거나, 해당 위치의 값이 `target`와 다르다면, 배열에 `target`이 존재하지 않으므로 결과 배열 `[-1, -1]`을 반환합니다.
3. 시작 위치가 유효하다면, 다시 `firstGreaterEqual` 메서드를 호출하여 끝 위치를 찾습니다. 이 위치는 `target`+1보다 크거나 같은 첫 번째 원소의 인덱스에서 1을 뺀 값입니다. 이는 `target` 값의 마지막 위치를 찾는 것을 의미합니다.
4. 마지막으로, 시작 위치와 끝 위치를 담은 배열 `[start, end]`를 생성하여 반환합니다.
5. `firstGreaterEqual` 메서드는 이진 탐색을 사용하여 주어진 배열 `nums`에서 주어진 `target` 값 이상인 첫 번째 원소의 인덱스를 찾는 역할을 합니다.
6. 해당 메서드는 low와 high 두 개의 포인터를 사용하여 이진 탐색을 수행합니다. low는 현재 탐색하는 범위의 왼쪽 경계를 가리키고, high는 현재 탐색하는 범위의 오른쪽 경계 바로 다음을 가리킵니다.
7. 반복문을 통해 low가 high보다 작은 동안 탐색을 진행하며, 중간 지점인 mid를 계산합니다. 이후, `nums[mid]` 값이 `target`보다 작다면 탐색 범위를 오른쪽으로 좁히기 위해 low를 mid+1로 업데이트하고, 그렇지 않으면 탐색 범위를 왼쪽으로 좁히기 위해 high를 mid로 업데이트합니다.
8. 반복문이 종료되면 low 값을 반환합니다. 이는 주어진 `target` 값보다 크거나 같은 첫 번째 원소의 인덱스를 나타냅니다.

이 알고리즘은 이진 탐색을 사용하므로 `firstGreaterEqual` 메서드의 시간 복잡도는 O(log n)입니다. 따라서 전체 searchRange 메서드의 런타임 복잡도도 O(log n)입니다. 이를 통해 주어진 문제의 요구사항인 O(log n)의 런타임 복잡도를 만족합니다.

## Test

```java
package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                () -> test(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                () -> test(new int[]{}, 0, new int[]{-1, -1})
        );
    }

    private void test(int[] nums, int target, int[] expected) {
        // when
        Solution solution2 = new Solution();
        int[] actual = solution2.searchRange(nums, target);
        // then
        assertArrayEquals(expected, actual);
    }
}
```
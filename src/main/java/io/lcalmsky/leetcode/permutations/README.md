> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/permutations/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/permutations/) 있습니다.

## Problem

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

**Example 1:**
```text
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**Example 2:**
```text
Input: nums = [0,1]
Output: [[0,1],[1,0]]
```

**Example 3:**
```text
Input: nums = [1]
Output: [[1]]
```

**Constraints:**

* 1 <= nums.length <= 6
* -10 <= nums[i] <= 10
* All the integers of nums are unique.

## Solution

고유한 정수로 이루어진 배열이 주어질 때 가능한 모든 조합의 순열을 반환하는 문제입니다.

정답의 순서는 상관 없습니다.

dfs를 이용해 풀 수 있습니다.

```java
package io.lcalmsky.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, result);
        return result;
    }

    private void dfs(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            dfs(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int start) {
        int tmp = nums[i];
        nums[i] = nums[start];
        nums[start] = tmp;
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.permutations;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3}, List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))),
                () -> test(new int[]{0, 1}, List.of(List.of(0, 1), List.of(1, 0))),
                () -> test(new int[]{1}, List.of(List.of(1)))
        );
    }

    private void test(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.permute(nums);
        Set<List<Integer>> expectedSet = new HashSet<>(expected);
        Set<List<Integer>> actualSet = new HashSet<>(actual);
        assertTrue(expectedSet.containsAll(actualSet));
    }
}
```
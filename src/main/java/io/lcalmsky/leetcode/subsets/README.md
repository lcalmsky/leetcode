> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/subsets/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/subsets/) 있습니다.

## Problem

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

**Example 1:**

```text
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

**Example 2:**

```text
Input: nums = [0]
Output: [[],[0]]
```

**Constraints:**

* 1 <= nums.length <= 10
* -10 <= nums[i] <= 10
* All the numbers of nums are unique.

## Solution

고유한 원소로 이루어진 정수 배열이 주어질 때 모든 가능한 부분 집합을 반환하는 문제입니다.

dfs를 이용해 풀이할 수 있습니다.

```java
package io.lcalmsky.leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, result, subset, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.subsets;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3}, List.of(List.of(), List.of(1), List.of(2), List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3))),
                () -> test(new int[]{0}, List.of(List.of(), List.of(0)))
        );
    }

    private void test(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.subsets(nums);
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (List<Integer> subset : expected) {
            map.put(subset, map.getOrDefault(subset, 0) + 1);
        }
        for (List<Integer> subset : actual) {
            map.put(subset, map.getOrDefault(subset, 0) - 1);
        }
        map.values().forEach(v -> assertEquals(0, v));
    }
}
```
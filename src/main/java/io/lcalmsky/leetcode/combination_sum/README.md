> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/combination_sum/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/combination-sum/) 있습니다.

## Problem

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

**Example 1:**

```text
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```

**Example 2:**
```text
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```

**Example 3:**
```text
Input: candidates = [2], target = 1
Output: []
```

**Constraints:**

* 1 <= candidates.length <= 30
* 1 <= candidates[i] <= 200
* All elements of candidates are distinct.
* 1 <= target <= 500

## Solution

각 값이 고유한 정수 배열이 주어지고 타겟 숫자가 주어질 때 배열의 원소들을 조합해 더한 합이 타겟 정수가 되는 조합을 모두 구하는 문제입니다.

Backtracking을 이용해 문제를 해결할 수 있습니다.

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    helper(candidates, 0, target, 0, new ArrayList<>(), result);
    return result;
  }

  private void helper(int[] candidates, int start, int target, int sum, List<Integer> list,
      List<List<Integer>> result) {
    if (sum > target) { // (1)
      return;
    }
    if (sum == target) { // (2)
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < candidates.length; i++) { 
      list.add(candidates[i]); // (3)
      helper(candidates, i, target, sum + candidates[i], list, result); // (4)
      list.remove(list.size() - 1); // (5)
    }
  }
}
```

1. 합이 target을 넘어가면 메서드를 종료합니다.
2. 합이 target과 같을 때 리스트를 결과에 추가합니다.
3. 리스트에 원소의 값을 추가합니다.
4. 인덱스와 현재까지의 합을 갱신하여 재귀호출합니다.
5. 리스트에 마지막에 추가된 원소를 제거합니다.

## Test

```java
package io.lcalmsky.leetcode.combination_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
        () -> test(new int[]{2, 3, 5}, 8,
            List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))),
        () -> test(new int[]{2}, 1, List.of())
    );
  }

  private void test(int[] candidates, int target, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.combinationSum(candidates, target);
    // then
    assertTrue(actual.containsAll(expected));
  }
}
```
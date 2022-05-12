> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/permutations_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/permutations-ii/) 있습니다.

## Problem

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

**Example 1:**
```text
Input: nums = [1,1,2]
Output:
[[1,1,2],
[1,2,1],
[2,1,1]]
```

**Example 2:**
```text
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

**Constraints:**

* 1 <= nums.length <= 8
* -10 <= nums[i] <= 10

## Solution

중복이 포함될 수 있는 정수 배열이 주어지면, 가능한 모든 순열을 반환하는 문제입니다.

백트래킹을 이용해 풀 수 있습니다.

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(0, nums, result);
    return new ArrayList<>(result);
  }

  private void helper(int start, int[] nums, List<List<Integer>> result) {
    if (start == nums.length - 1) { // (1)
      List<Integer> list = new ArrayList<>();
      for (int num : nums) {
        list.add(num);
      }
      result.add(list);
      return;
    }
    Set<Integer> set = new HashSet<>(); // (2)
    for (int i = start; i < nums.length; i++) { // (3)
      if (!set.add(nums[i])) { // (4)
        continue;
      }
      swap(nums, i, start); // (5)
      helper(start + 1, nums, result); // (6)
      swap(nums, i, start); // (7)
    }
  }

  private void swap(int[] nums, int i, int start) {
    int tmp = nums[i];
    nums[i] = nums[start];
    nums[start] = tmp;
  }
}
```

1. 인덱스가 배열의 길이가 되었을 때 배열의 정수를 모두 리스트에 추가하고, 해당 리스트를 결과 리스트에 추가합니다.
2. 이미 순열에 포함되었는지를 체크하기 위한 Set 입니다.
3. 시작 인덱스부터 반복합니다.
4. 이미 순열에 포함된 경우 아무 것도 하지 않습니다.
5. 순열에 포함되지 않은 수일 경우 현재 숫자와 시작 인덱스의 숫자를 swap 해줍니다.
6. 시작 인덱스를 증가시키고 재귀호출 합니다.
7. 현재 숫자와 시작 인덱스의 숫자를 다시 swap 합니다.

## Test

```java
package io.lcalmsky.leetcode.permutations_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 2}, List.of(
            List.of(1, 1, 2),
            List.of(1, 2, 1),
            List.of(2, 1, 1)
        )),
        () -> test(new int[]{1, 2, 3}, List.of(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1)
        ))
    );
  }

  private void test(int[] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.permuteUnique(given);
    // then
    assertTrue(actual.containsAll(expected));
  }
}
```
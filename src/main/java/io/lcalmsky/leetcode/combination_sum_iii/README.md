> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/combination_sum_iii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/combination-sum-iii/) 있습니다.

## Problem

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

**Example 1:**
```text
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
```
**Example 2:**
```text
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
```
**Example 3:**
```text
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
```

**Constraints:**

* 2 <= k <= 9
* 1 <= n <= 60

## Solution

더해서 n을 만들 수 있는 k개의 숫자로 구성된 조합을 모두 구하는 문제입니다.

숫자는 1~9까지 주어지고, 각 숫자는 한 번만 사용할 수 있습니다.

DFS를 사용해 풀이할 수 있습니다.

```java
package io.lcalmsky.leetcode.combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    dfs(result, list, k, 1, n);
    return result;
  }

  private void dfs(List<List<Integer>> result, List<Integer> list, int k, int start, int sum) {
    if (sum < 0) { // (1)
      return;
    }
    if (sum == 0 && list.size() == k) { // (2)  
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i <= 9; i++) { // (3) 
      list.add(i);
      dfs(result, list, k, i + 1, sum - i); // (4) 
      list.remove(list.size() - 1); // (5) 
    }
  }
}

```

1. 숫자들의 합이 sum을 넘어간 것이므로 결과에 추가하지 않습니다.
2. k개의 숫자들의 합이 sum일 때 결과에 추가합니다.
3. 1~9까지 반복하면서 임시 리스트에 숫자를 추가하고
4. 해당 숫자만큼 sum에서 제외하고 인덱스를 증가시킨 후 재귀호출 합니다.
5. 모두 끝났을 때 임시 리스트의 마지막 값을 제거합니다.

## Test

```java
package io.lcalmsky.leetcode.combination_sum_iii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNumberAndSum_whenFindCombinations_thenCorrect() {
    assertAll(
        () -> test(3, 7, List.of(
            List.of(1, 2, 4)
        )),
        () -> test(3, 9, List.of(
            List.of(1, 2, 6),
            List.of(1, 3, 5),
            List.of(2, 3, 4))
        )
    );
  }

  private void test(int k, int n, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.combinationSum3(k, n);
    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/range_addition_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3957/) 있습니다.  

## Problem
You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/02/ex1.jpg)

```text
Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
```

**Example 2:**

```text
Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
```

**Example 3:**

```
Input: m = 3, n = 3, ops = []
Output: 9
```

**Constraints:**

* 1 <= m, n <= 4 * 10^4
* 0 <= ops.length <= 10^4
* ops[i].length == 2
* 1 <= ai <= m
* 1 <= bi <= n

## Solution

M * N 행렬과 operation을 나타내는 배열이 주어졌을 때, 각 operation 수행 후 가장 높은 숫자의 갯수를 반환하는 문제입니다.

여기서 operation은 [0, 0]에서 [x, y]까지의 숫자를 1씩 증가시켜주는 것으로 M, N이 모두 5이고 operation이 [3, 3]인 경우

```text
1 1 1 0 0
1 1 1 0 0
1 1 1 0 0
0 0 0 0 0
0 0 0 0 0
```

이런 행렬이 되어 가장 높은 숫자(1)의 갯수는 9가 됩니다.

얼핏 보면 어려워보이지만 생각을 조금만 해보면 매우 쉬운 문제입니다.

[0, 0]부터 행렬의 숫자가 증가하기 때문에 [2, 2], [3, 3] 등의 operation이 있을 때 더 작은 수의 operation에 해당하는 행렬의 숫자가 더 높아질 수 밖에 없습니다.

따라서 operation 중 가장 작은 숫자만 골라서 두 수를 곱해주면 됩니다.

```java
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int leftMin = m, rightMin = n;
        for (int[] op : ops) {
            leftMin = Math.min(op[0], leftMin);
            rightMin = Math.min(op[1], rightMin);
        }
        return leftMin * rightMin;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.range_addition_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenMbyNMatrix_whenExecuteOperation_thenFindTheNumberOfMaximumIntegers() {
        assertAll(
                () -> test(3, 3, new int[][]{
                        {2, 2},
                        {3, 3}
                }, 4),
                () -> test(3, 3, new int[][]{
                        {2, 2},
                        {3, 3},
                        {3, 3},
                        {3, 3},
                        {2, 2},
                        {3, 3},
                        {3, 3},
                        {3, 3},
                        {2, 2},
                        {3, 3},
                        {3, 3},
                        {3, 3}
                }, 4),
                () -> test(3, 3, new int[][]{
                }, 9),
                () -> test(18, 3, new int[][]{
                        {16, 1},
                        {14, 3},
                        {14, 2},
                        {4, 1},
                        {10, 1},
                        {11, 1},
                        {8, 3},
                        {16, 2},
                        {13, 1},
                        {8, 3},
                        {2, 2},
                        {9, 1},
                        {3, 1},
                        {2, 2},
                        {6, 3}
                }, 2)
        );
    }

    private void test(int givenM, int givenN, int[][] givenOps, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxCount(givenM, givenN, givenOps);

        // then
        assertEquals(expected, actual);
    }
}
```
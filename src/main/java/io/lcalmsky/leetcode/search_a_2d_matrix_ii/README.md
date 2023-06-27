> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/search_a_2d_matrix_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/search-a-2d-matrix-ii/) 있습니다.

## Problem

Write an efficient algorithm that searches for a value `target` in an `m x n` integer `matrix` matrix. This matrix has the following properties:

* Integers in each row are sorted in ascending from left to right.
* Integers in each column are sorted in ascending from top to bottom.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/24/searchgrid2.jpg)

```text
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/11/24/searchgrid.jpg)

```text
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
```

**Constraints:**

* m == matrix.length
* n == matrix[i].length
* 1 <= n, m <= 300
* -10^9 <= matrix[i][j] <= 10^9
* All the integers in each row are sorted in ascending order.
* All the integers in each column are sorted in ascending order.
* -10^9 <= target <= 10^9

## Solution

m*n 정수 행렬에서 target을 찾는 문제입니다.

행렬은 왼쪽에서 오른쪽으로, 위에서 아래로 모두 오름차순으로 정렬되어 있습니다.

```java
package io.lcalmsky.leetcode.search_a_2d_matrix_ii;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int n = matrix[0].length - 1;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= n) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}

```

행렬의 좌측 하단에서부터 조건에 따라 위쪽, 오른쪽으로 움직이면서 탐색하여 찾을 수 있습니다. 

## Test

```java
package io.lcalmsky.leetcode.search_a_2d_matrix_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5, true),
                () -> test(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20, false)
        );
    }

    private void test(int[][] matrix, int target, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.searchMatrix(matrix, target);
        // then
        assertEquals(expected, actual);
    }

}
```
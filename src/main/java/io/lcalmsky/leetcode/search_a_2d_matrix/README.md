> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/search_a_2d_matrix/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/search-a-2d-matrix/) 있습니다.

## Problem

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/05/mat.jpg)

```text
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg)

```text
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
```

**Constraints:**

* m == matrix.length
* n == matrix[i].length
* 1 <= m, n <= 100
* -10^4 <= matrix[i][j], target <= 10^4

## Solution

정수 행렬이 주어지는데 각 열과 행은 오름차순으로 정렬되어있습니다.

타겟 정수가 행렬에 존재하는지 여부를 반환하는 문제입니다.

각 행을 탐색하면서 이진탐색으로 타겟 정수를 찾으면 됩니다. 

```java
public class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int[] row : matrix) {
      if (target <= row[n - 1]) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
          int mid = low + (high - low) / 2;
          if (target == row[mid]) {
            return true;
          }
          if (target < row[mid]) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
      }
    }
    return false;
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.search_a_2d_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenMatrix_whenSearchesTarget_thenReturnsWhetherExists() {
    assertAll(
        () -> test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3, true),
        () -> test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13, false)
    );
  }

  private void test(int[][] givenArray, int givenTarget, boolean expected) {
    // when
    Solution searchA2dMatrix = new Solution();
    boolean actual = searchA2dMatrix.searchMatrix(givenArray, givenTarget);

    // then
    assertEquals(expected, actual);
  }
}
```
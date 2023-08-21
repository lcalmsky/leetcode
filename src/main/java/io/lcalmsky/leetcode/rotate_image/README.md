> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/rotate_image/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/rotate-image/) 있습니다.

## Problem

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg)

```text
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg)

```text
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
```

**Constraints:**

* n == matrix.length == matrix[i].length
* 1 <= n <= 20
* -1000 <= matrix[i][j] <= 1000

## Solution

2D 정사각형 행렬을 오른쪽으로 90도 회전하는 문제입니다.

대각선 기준으로 swap한 뒤 좌우 대칭으로 swap 해주면 원하는대로 오른쪽으로 90도 회전한 행렬을 얻을 수 있습니다.

예를 들어, 아래와 같은 3x3 행렬이 있을 때

```text
1 2 3
4 5 6
7 8 9
```

대각선을 기준으로 swap하면,
```text
1 4 7
2 5 8
3 6 9
```

이렇게 되고, 다시 좌우로 swap해주면,
```text
7 4 1
8 5 2
9 6 3
```

원하는 결과를 얻을 수 있습니다.

```java
package io.lcalmsky.leetcode.rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

```

## Test

```java
package io.lcalmsky.leetcode.rotate_image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[][]{
                                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                        },
                        new int[][]{
                                {7, 4, 1}, {8, 5, 2}, {9, 6, 3}
                        }
                ),
                () -> test(
                        new int[][]{
                                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
                        },
                        new int[][]{
                                {15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}
                        }
                )
        );
    }

    private void test(int[][] matrix, int[][] expected) {
        Solution solution = new Solution();
        solution.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }
}
```
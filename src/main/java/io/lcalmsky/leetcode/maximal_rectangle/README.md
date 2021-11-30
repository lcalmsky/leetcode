> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximal_rectangle/Solution.java) 있습니다.  
> 문제는 [여기](https://github.com/lcalmsky/leetcode/issues/47) 있습니다.

## Problem

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

**Example 1:**

```text
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
```

**Example 2:**

```text
Input: matrix = []
Output: 0
```

**Example 3:**

```text
Input: matrix = [["0"]]
Output: 0
```

**Example 4:**

```text
Input: matrix = [["1"]]
Output: 1
```

**Example 5:**

```text
Input: matrix = [["0","0"]]
Output: 0
```

**Constraints:**

* rows == matrix.length
* cols == matrix[i].length
* 0 <= row, cols <= 200
* matrix[i][j] is '0' or '1'.

## Solution

0과 1로 구성된 행렬이 주어졌을 때 1로 이뤄진 가장 큰 사각형의 넓이를 구하는 문제입니다.

단순히 이어진 구간을 구하는 게 아니라 사각형을 찾아야하는 문제라 상당히 까다로운 문제라고 할 수 있습니다.

in-line으로 설명을 추가했습니다.

```java

import java.util.Stack;

public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] height = new int[n];
    Arrays.fill(right, n);
    int maxArea = 0;
    for (char[] row : matrix) { // 각 행을 순차적으로 탐색하면서
      int currentLeft = 0, currentRight = n;
      for (int i = 0; i < n; i++) { // 높이 배열을 업데이트 합니다.
        if (row[i] == '1') { // 1일 때 높이를 올려주고
          height[i]++;
        } else { // 1이 아니면 높이를 0으로 초기화하여 다시 계산할 수 있게 해줍니다.
          height[i] = 0;
        }
      }
      for (int i = 0; i < n; i++) { // 가로 길이를 구하기 위해 left 배열을 업데이트 합니다.
        if (row[i] == '1') { // 1일 때 left 배열에 해당하는 최댓값을 갱신합니다.
          left[i] = Math.max(left[i], currentLeft);
        } else { // 0일 때 left를 0으로 초기화하여 다시 계산할 수 있게 해주고 현재 left 값의 포인터 위치를 이동시킵니다.
          left[i] = 0;
          currentLeft = i + 1;
        }
      }
      for (int i = n - 1; i >= 0; i--) { // 가로 길이를 구하기 위해 right 배열을 업데이트 합니다.
        if (row[i] == '1') { // 1일 때 right 값을 갱신합니다. 
          right[i] = Math.min(right[i], currentRight);
        } else { // 0일 때 right 값을 다시 우측 끝인 n으로 초기화하고 현재 right 값의 포인터를 현재 인덱스로 이동시킵니다.
          right[i] = n;
          currentRight = i;
        }
      }
      for (int i = 0; i < n; i++) { // 각 행에 대해 계산한 높이와 가로 길이를 이용해 넓이 최댓값을 갱신합니다.
        maxArea = Math.max(maxArea, (right[i] - left[i]) * height[i]);
      }
    }
    return maxArea;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.maximal_rectangle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenGetMaximalRectangleArea_thenCorrect() {
    assertAll(
        () -> test(new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        }, 6),
        () -> test(new char[][]{}, 0),
        () -> test(new char[][]{{'0'}}, 0),
        () -> test(new char[][]{{'1'}}, 1),
        () -> test(new char[][]{{'0', '0'}}, 0)
    );
  }

  private void test(char[][] given, int expected) {
    // when
    Solution maximalRectangle = new Solution();
    int actual = maximalRectangle.maximalRectangle(given);

    // then
    assertEquals(expected, actual);
  }
}
```
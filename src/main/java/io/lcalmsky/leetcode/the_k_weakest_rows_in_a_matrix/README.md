> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/the_k_weakest_rows_in_a_matrix/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/) 있습니다.

## Problem

You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

**Example 1:**
```text
Input: mat =
[[1,1,0,0,0],
[1,1,1,1,0],
[1,0,0,0,0],
[1,1,0,0,0],
[1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].
```  
**Example 2:**
```text
Input: mat =
[[1,0,0,0],
[1,1,1,1],
[1,0,0,0],
[1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].
```

**Constraints:**

* m == mat.length
* n == mat[i].length
* 2 <= n, m <= 100
* 1 <= k <= m
* matrix[i][j] is either 0 or 1.

## Solution

m * n 이진 행렬이 주어지고 1이 군인, 0이 시민을 나타냅니다. 모든 군인은 모든 시민보다 항상 앞에(왼쪽) 있습니다.

i번 째 행이 j번 째 행보다 군인의 수가 적거나, 같은 경우엔 인덱스가 더 작을 때 더 약하다고 표현을 합니다.

정수 k가 주어지면 가장 약한 k개의 행의 인덱스를 가장 약한 행에서 강한 행 순으로 반환하는 문제입니다.

문제를 아주 직관적으로 접근하면 됩니다.

```java
public class Solution {

  public int[] kWeakestRows(int[][] mat, int k) {
    int[] soldiers = new int[mat.length];
    int[] result = new int[k];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 1) {
          soldiers[i]++;
        }
      }
    }
    int index = 0;
    while (k > 0) {
      int minIndex = 0;
      for (int i = 0; i < soldiers.length; i++) {
        if (soldiers[i] < soldiers[minIndex]) {
          minIndex = i;
        }
      }
      result[index++] = minIndex;
      soldiers[minIndex] = Integer.MAX_VALUE;
      k--;
    }
    return result;
  }
}
```

각 행의 군인 수를 구하고, 결과 배열에 순차적으로 넣어주면서 넣어준 군인 배열의 수를 최댓값으로 바꿔줘 다시 선택되지 않게 해주면 됩니다.

군인의 수를 구하거나 최솟값을 구할 때 이진 탐색을 이용하면 O(n^2)에서 O(N Log N)으로 성능을 향상시킬 수 있습니다. 

## Test

```java
package io.lcalmsky.leetcode.the_k_weakest_rows_in_a_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}}, 3, new int[]{2, 0, 3}),
        () -> test(new int[][]{{1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}}, 2, new int[]{0, 2})
    );
  }

  private void test(int[][] mat, int k, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.kWeakestRows(mat, k);
    // then
    assertArrayEquals(expected, actual);
  }
}
```
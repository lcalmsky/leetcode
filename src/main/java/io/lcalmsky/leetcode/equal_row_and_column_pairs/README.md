> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/equal_row_and_column_pairs/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/equal-row-and-column-pairs/) 있습니다.

## Problem

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

**Example 1:**

```text
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
```

**Example 2:**

```text
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
```

**Constraints:**

* n == grid.length == grid[i].length
* 1 <= n <= 200
* 1 <= grid[i][j] <= 10^5

## Solution

2차원 정수 배열 grid가 주어졌을 때, 행과 열이 같은 원소를 갖는 (ri, cj) 쌍의 개수를 계산하는 문제입니다.

```java
package io.lcalmsky.leetcode.equal_row_and_column_pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            map.merge(rowString, 1, Integer::sum);
        }
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            String colString = Arrays.toString(col);
            pairs += map.getOrDefault(colString, 0);
        }
        return pairs;
    }
}

```

1. equalPairs 함수는 grid 배열을 입력으로 받습니다.
2. n 변수에는 grid 배열의 길이, 즉 행 또는 열의 개수가 저장됩니다.
3. 빈 HashMap 객체인 map을 생성합니다. 이 맵은 행의 값을 문자열로 변환하여 저장하고, 해당 문자열이 몇 번 등장하는지를 세는데 사용됩니다.
4. grid 배열을 순회하면서 각 행에 대해 다음을 수행합니다:
   5. Arrays.toString() 메서드를 사용하여 행 배열을 문자열로 변환합니다. 이 문자열은 해당 행을 나타내는 고유한 키가 됩니다. 
   6. map.merge(rowString, 1, Integer::sum)을 호출하여 map에 행을 키로 가지는 값(등장 횟수)을 추가합니다. 만약 이미 해당 키가 존재하면, 기존 값과 1을 더한 값을 저장합니다.
   7. 이 과정을 통해 각 행의 등장 횟수가 map에 저장됩니다.
1. pairs 변수를 0으로 초기화합니다. 이 변수는 최종적으로 반환될 결과값으로, 같은 원소를 갖는 (ri, cj) 쌍의 개수를 나타냅니다.
1. grid 배열의 각 열에 대해 다음을 수행합니다:
   1. 빈 배열 col을 생성합니다. 이 배열은 현재 순회 중인 열의 값을 저장하는데 사용됩니다.
   1. grid 배열의 각 행에 대해 grid[j][i] 값을 col 배열에 저장합니다. 이로써 col 배열은 현재 순회 중인 열의 값들로 채워지게 됩니다.
   1. Arrays.toString() 메서드를 사용하여 col 배열을 문자열로 변환합니다. 이 문자열은 현재 순회 중인 열을 나타내는 고유한 키가 됩니다.
   1. map에서 해당 열에 대한 등장 횟수를 가져옵니다. 만약 colString이 map에 존재하지 않는다면, 0을 가져옵니다.
   1. pairs 변수에 해당 열의 등장 횟수를 더합니다.
1. pairs 변수를 반환하여 같은 원소를 갖는 (ri, cj) 쌍의 총 개수를 반환합니다.

**시간 복잡도(Time Complexity)**

먼저, for 루프를 통해 grid 배열을 한 번 순회하면서 각 행의 값을 문자열로 변환하고 map에 저장합니다. 이 작업은 O(n^2) 시간이 걸립니다.
그 다음, for 루프를 통해 grid 배열의 열을 순회하면서 col 배열을 생성하고 각 열의 값을 문자열로 변환하고 map에서 해당 열의 등장 횟수를 가져오는 작업을 수행합니다. 이 작업 역시 O(n^2) 시간이 걸립니다.
따라서, 전체 시간 복잡도는 O(n^2) + O(n^2) = O(n^2)입니다.

**공간 복잡도(Space Complexity)**

map을 사용하여 각 행의 값을 문자열로 변환하고 등장 횟수를 저장합니다. 최악의 경우, map에는 모든 서로 다른 행의 문자열이 저장될 수 있으므로, 공간 복잡도는 O(n^2)입니다.
추가적으로, col 배열을 생성하여 열의 값을 임시로 저장합니다. 이 배열은 열마다 새로 생성되므로 O(n)의 공간을 차지합니다.
따라서, 전체 공간 복잡도는 O(n^2) + O(n) = O(n^2)입니다.

## Test

```java
package io.lcalmsky.leetcode.equal_row_and_column_pairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
                () -> test(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3)
        );
    }

    private void test(int[][] grid, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.equalPairs(grid);
        // then
        assertEquals(expected, actual);
    }
}
```
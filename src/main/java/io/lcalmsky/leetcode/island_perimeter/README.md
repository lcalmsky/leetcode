> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/island-perimeter/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/island-perimeter/) 있습니다.

## Problem

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/10/12/island.png)

```text
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
```

**Example 2:**

```text
Input: grid = [[1]]
Output: 4
```

**Example 3:**

```text
Input: grid = [[1,0]]
Output: 4
```

**Constraints:**

* row == grid.length
* col == grid[i].length
* 1 <= row, col <= 100
* grid[i][j] is 0 or 1.
* There is exactly one island in grid.

## Solution

그리드가 주어졌을 때 1로 이어진 부분을 섬이라고하면, 그 섬의 둘레를 구하는 문제입니다.

easy 난이도이지만 알고리즘 풀이 경력이 짧을 경우 난이도에 비해 어렵게 느껴질 거 같습니다.

기본적으로 사각형의 둘레는 4가 되고, 각 면이 닿아있을 경우 두 사각형에서 모두 제외되므로 닿은 면 * 2만큼 둘레가 줄어듭니다.

1번 예시를 가로만 먼저 생각해봤을 때

[0, 1, 0, 0]: 닿아있지 않음
[1, 1, 1, 0]: 두 면이 닿아있으므로 -2*2
[0, 1, 0, 0]: 닿아있지 않음
[1, 1, 0, 0]: 한 면이 닿아있으므로 -2*1

둘레에서 10이 차감되고, 세로를 생각해보면 한 열에서만 세 개의 면이 닿아있으므로 -2*3이 되어

7개의 사각형의 둘레 28에서 (4+2+6) 만큼 빼준 16이 답이 됩니다.

이를 소스 코드로 확인해보면 아래와 같습니다.

```java
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        neighbours++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        neighbours++;
                    }
                }
            }
        }
        return count * 4 - neighbours * 2;
    }
}
```

## Test

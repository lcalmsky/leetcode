> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/spiral_matrix/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3977/) 있습니다.

## Problem

Given an m x n matrix, return all elements of the matrix in spiral order.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg)

```text
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg)

```text
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

**Constraints:**

* m == matrix.length
* n == matrix[i].length
* 1 <= m, n <= 10
* -100 <= matrix[i][j] <= 100

## Solution

행렬을 달팽이 모양(바깥에서 안 쪽으로)으로 접근한 결과를 리스트로 반환하는 문제입니다.

개인적으로 인덱스를 활용하고 계산하는 거에 자신이 별로 없고 헷갈려서 시간도 많이 소모하는 편입니다.

사실 차근차근 변수에 대입해가면서 푼다면 풀이 자체는 간단하게 구현할 수 있습니다.

다만 맨 위에 행이 높이로 계산했을 땐 m - 1이 될 거 같지만 실제로는 0이라는 점 이런 것들이 헷갈릴 수 있는데 이 또한 그림을 보고 충분히 생각하신 뒤 구현하시면 어렵지 않을 거 같습니다.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (result.size() < m * n) {
            for (int i = left; i <= right; i++) { // (1)
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) { // (2)
                result.add(matrix[i][right]);
            }
            right--;
            if (bottom < top) break;
            for (int i = right; i >= left; i--) { // (3)
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (right < left) break;
            for (int i = bottom; i >= top; i--) { // (4)
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
```

> (1) 왼쪽에서 오른쪽으로 가면서 결과 리스트에 행렬의 엘리먼트를 추가합니다. 이 때 기준은 위쪽 행이므로 모두 추가한 뒤 위쪽 기준을 1 더해줍니다.  
> (2) 위에서 아래로 가면서 결과 리스트에 행렬의 엘리먼트를 추가합니다. 이 때 기준은 오른쪽 열이므로 모두 추가한 뒤 오른쪽 기준을 1 빼줍니다.  
> (3) 아래쪽 기준이 위쪽 기준보다 낮아졌는지(그림상으로는 더 위쪽이 된 경우) 확인하여 낮아졌을 경우 반복문을 종료합니다. 그렇지 않다면 오른쪽에서 왼쪽으로 가면서 결과 리스트에 행렬의 엘리먼트를 추가합니다. 이 때 기준은 아래쪽 행이므로 모두 추가한 뒤 아래쪽 기준을 1 빼줍니다.  
> (4) 오른쪽 기준이 왼쪽 기준보다 낮아졌는지(그림상으로는 더 왼쪽이 된 경우) 확인하여 낮아졌을 경우 반복문을 종료합니다. 그렇지 않다면 아래쪽에서 위쪽으로 가면서 결과 리스트에 행렬의 엘리먼트를 추가합니다. 이 때 기준은 왼쪽 행이므로 모두 추가한 뒤 왼쪽 기준을 1 더해줍니다.

## Test

```java
package io.lcalmsky.leetcode.spiral_matrix;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenMatrix_whenMakeListInSpiralOrder_thenCorrect() {
        assertAll(
                () -> test(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                () -> test(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
        );
    }

    private void test(int[][] given, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.spiralOrder(given);

        // then
        assertEquals(expected, actual);
    }
}
```

---

제가 작년 12월쯤 쿠팡 라이브 코딩 테스트 진행할 때 접했던 문제입니다.

비대면 면접으로 진행했었는데 너무 긴장해서 전날 잠 하나도 못자고 이 문제를 딱 만났을 때 "이게 웬 떡이냐!"하면서 너무 반가웠던 기억이 있습니다.

여기서 반전은 못 풀었다는 것인데(사실 정확하게는 다른 문제를 시도했습니다) 혹시 라이브 코딩 테스트를 준비하는 분들이라면 어떤 문제를 풀든지 침착하게 설명하면서 푸는 습관을 들이는 게 중요한 거 같습니다.

지금 생각해보면 말로 얼마나 잘 설명하면서 떨지않고 코딩할 수 있느냐가(풀이 여부와 상관없이) 더 중요한 거 같아요.

실제로 라이브 코딩 테스트 경험이 많지 않다면 누군가가 지켜본다는 압박감이 엄청나서 머리가 하얘지면서 아는 것도 못 푸는 경우가 있기 때문에 평소에 꾸준한 연습이 필요한 거 같습니다.

어떤 알고리즘을 어떻게 써야한다고 설명할 수 있으면 가장 좋지만 그렇지 않을 경우엔 "일단 Brute Force로 풀어보고 이후에 최적화하겠다" 이런식으로 설명을 하고 시작하는 것과 그냥 막무가내로 풀고나서 피드백을 받는 것과는 하늘과 땅 차이인 거 같아요🙂

코테 준비하시는 분들 모두 힘내세요 💪


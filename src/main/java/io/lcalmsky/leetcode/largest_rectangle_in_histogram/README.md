> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/largest_rectangle_in_histogram/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/largest-rectangle-in-histogram/) 있습니다.

## Problem

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg)

```text
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg)

```text
Input: heights = [2,4]
Output: 4
```

**Constraints:**

* 1 <= heights.length <= 10^5
* 0 <= heights[i] <= 10^4

## Solution

히스토그램의 각 막대의 높이가 배열로 주어질 때 히스토그램 내 가장 넓이가 큰 직사각형의 넓이를 반환하는 문제입니다.

스택을 이용해 막대를 스택에 넣고 최신 막대를 비교하면서 최대 넓이를 구해나가면 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.largest_rectangle_in_histogram;

import java.util.Stack;

public class Solution {

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    int index = 0;
    while (index < heights.length) {
      if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) { // (1)
        stack.push(index++);
        continue;
      }
      max = getMaxArea(heights, stack, max, index); // (2)
    }
    while (!stack.isEmpty()) { // (4)
      max = getMaxArea(heights, stack, max, index);
    }
    return max;
  }

  private int getMaxArea(int[] heights, Stack<Integer> stack, int max, int index) { // (3)  
    int pop = stack.pop();
    int height = heights[pop];
    int width = stack.isEmpty() ? index : index - stack.peek() - 1;
    return Math.max(height * width, max);;
  }
}

```

1. 스택이 비어있거나 스택의 top에 있는 막대의 높이보다 현재 막대의 높이가 더 클 때 스택에 해당 인덱스를 추가합니다.
2. 스택이 비어있지 않으면 현재까지의 최대 넓이를 계산합니다.
3. 스택의 top의 엘리먼트를 꺼내 직사각형의 높이와 너비를 구하고, 직사각의 넓이를 구해 최댓값을 갱신합니다.
4. 히스토그램 끝까지 반복한 뒤에도 스택에 원소가 남아있다면 스택이 완전히 빌 때까지 반복해서 최대 넓이를 구합니다.

---

히스토그램 막대를 탐색하면서 이전 막대 중 현재 막대보다 더 작은 가장 최근 막대의 인덱스를 저장하는 방식으로 왼쪽에서 오른쪽 방향, 오른쪽에서 왼쪽 방향으로 두 번 확인하면서 최대 넓이를 구하면 속도면에서 훨씬 이득을 볼 수 있습니다.

```java
class AnotherSolution {

  public int largestRectangleArea(int[] heights) {
    int[] lastSmallerIndexFromLeft = new int[heights.length];
    int max = 0, index;
    for (int i = 0; i < heights.length; i++) {
      index = i - 1;
      while (index > -1 && heights[index] >= heights[i]) {
        max = Math.max(max, heights[index] * (i - lastSmallerIndexFromLeft[index] - 1));
        index = lastSmallerIndexFromLeft[index];
      }
      lastSmallerIndexFromLeft[i] = index;
    }
    index = heights.length - 1;
    while (index > -1) {
      max = Math.max(max, heights[index] * (heights.length - lastSmallerIndexFromLeft[index] - 1));
      index = lastSmallerIndexFromLeft[index];
    }
    return max;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.largest_rectangle_in_histogram;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindLargestRectangle_thenCorrect() {
    assertAll(
        () -> test(new int[]{2, 1, 5, 6, 2, 3}, 10),
        () -> test(new int[]{1}, 1),
        () -> test(new int[]{4, 2}, 4),
        () -> test(new int[]{0, 9}, 9),
        () -> test(new int[]{0, 0}, 0),
        () -> test(new int[]{2, 0, 2}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.largestRectangleArea(given);
    // then
    assertEquals(expected, actual);
  }
}
```
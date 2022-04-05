> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/container_with_most_water/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/container-with-most-water/) 있습니다.

## Problem

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

**Example 1:**

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg)

```text
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```

**Example 2:**
```text
Input: height = [1,1]
Output: 1
```

Constraints:

* n == height.length
* 2 <= n <= 10^5
* 0 <= height[i] <= 10^4

## Solution

길이가 n인 정수 배열 높이가 주어지고 i번째 선의 두 끝점이 (i, 0) 및 (i, height[i])가 되도록 n개의 수직선이 그려집니다.

컨테이너에 가장 많은 물이 포함되도록 x축과 함께 컨테이너를 형성하는 두 개의 선을 찾아 컨테이너가 저장할 수 있는 최대 물의 양을 반환하는 문제입니다.

간단하게 생각하면 순서대로 비교하여 물의 양을 구하고 가장 높은 물의 양을 반환하면 될 거 같은데, 이렇게하면 O(N^2) 만큼의 시간 복잡도가 필요합니다.

두 개의 포인터를 이용해 양쪽에서 범위를 줄여나가면 O(N)의 시간복잡도로도 답을 찾을 수 있습니다.

```java
public class Solution {

  public int maxArea(int[] height) {
    int max = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int currentLeft = height[left]; // (1)
      int currentRight = height[right]; // (2)
      max = Math.max(max, (right - left) * Math.min(currentLeft, currentRight)); // (3)
      if (currentLeft < currentRight) {
        while (left < right && height[left] <= currentLeft) { // (4)
          left++;
        }
      } else {
        while (left < right && height[right] <= currentRight) { // (5)
          right--;
        }
      }
    }
    return max;
  }
}
```

1. 현재 왼쪽 포인터가 가리키는 높이입니다.
2. 현재 오른쪽 포인터가 가리키는 높이입니다.
3. 물의 양을 계산합니다.
4. 현재 높이보다 작거나 같은 경우 왼쪽 포인터를 계속 오른쪽으로 이동시킵니다.
5. 현재 높이보다 작거나 같은 경우 오른쪽 포인터를 계속 왼쪽으로 이동시킵니다.

## Test

```java
package io.lcalmsky.leetcode.container_with_most_water;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
        () -> test(new int[]{1, 1}, 1)
    );

  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxArea(given);
    // then
    assertEquals(expected, actual);
  }
}
```
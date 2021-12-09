> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/jump_game_iii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/jump-game-iii/) 있습니다.

## Problem

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

**Example 1:**

```text
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
```

**Example 2:**

```text
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3
```

**Example 3:**

```text
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
```

**Constraints:**

* 1 <= arr.length <= 5 * 10^4
* 0 <= arr[i] < arr.length
* 0 <= start < arr.length

## Solution

0과 양수로 이루어진 배열과 첫 번째 위치가 주어지고, 해당 위치에서 해당 위치의 값만큼 왼쪽, 또는 오른쪽으로 이동할 수 있을 때 0이 위치한 곳으로 점프할 수 있는지 여부를 반환하는 문제입니다.

Queue와 방문 여부를 나타내는 배열을 이용해 해결할 수 있습니다.

```java
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public boolean canReach(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    boolean[] visited = new boolean[arr.length];
    visited[start] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      if (arr[current] == 0) {
        return true;
      }
      visited[current] = true;
      int right = current + arr[current], left = current - arr[current];
      if (right < arr.length && !visited[right]) {
        queue.offer(right);
      }
      if (left >= 0 && !visited[left]) {
        queue.offer(left);
      }
    }
    return false;
  }
}
```

재귀호출을 통해서도 구현 가능합니다.

```java
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public boolean canReach(int[] arr, int start) {
    if (arr[start] == 0) {
      return true;
    }
    if (arr[start] < 0) {
      return false;
    }
    arr[start] = -arr[start]; // 벙뮨 처리를 위해 배열의 기존 값을 음수로 바꿔줍니다.
    int right = start - arr[start]; // 음수가 되었기 때문에 실제로는 더하게 됩니다.
    if (right < arr.length && canReach(arr, right)) {
      return true;
    }
    int left = start + arr[start]; // 음수가 되었기 때문에 실제로는 빼게 됩니다.
    return left >= 0 && canReach(arr, left);
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.jump_game_iii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{4, 2, 3, 0, 3, 1, 2}, 5, true),
        () -> test(new int[]{4, 2, 3, 0, 3, 1, 2}, 0, true),
        () -> test(new int[]{3, 0, 2, 1, 2}, 2, false)
    );
  }

  private void test(int[] arr, int start, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.canReach(arr, start);
    // then
    assertEquals(expected, actual);
  }
}
```
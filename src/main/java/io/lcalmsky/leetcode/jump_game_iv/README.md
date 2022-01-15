> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/jump_game_iv/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/jump-game-iv/) 있습니다.

## Problem

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

* i + 1 where: i + 1 < arr.length.
* i - 1 where: i - 1 >= 0.
* j where: arr[i] == arr[j] and i != j.

* Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

**Example 1:**

```text
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
```

**Example 2:**

```text
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
```

**Example 3:**

```text
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
```

**Constraints:**

* 1 <= arr.length <= 5 * 10^4
* -10^8 <= arr[i] <= 10^8

## Solution

정수 배열이 주어지고 첫 번째 인덱스에서 시작해 마지막 인덱스까지 도달해야 하는데 움직일 수 있는 조건은 다음과 같습니다.

1. 앞으로 한 칸
2. 뒤로 한 칸
3. 값이 같은 곳까지 이동

이 때 마지막 인덱스에 도달하기위해 필요한 가장 적은 이동 횟수를 구하는 문제입니다.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int mimJumps(int[] arr) {
    Map<Integer, List<Integer>> map = new HashMap<>(); // (1)
    Set<Integer> set = new HashSet<>(); // (2)
    int length = arr.length;
    for (int i = 0; i < length; i++) { // (3)
      map.putIfAbsent(arr[i], new ArrayList<>());
      map.get(arr[i]).add(i);
    }
    boolean[] visited = new boolean[length]; // (4)
    Queue<Integer> queue = new LinkedList<>(); // (5)
    queue.add(0); // (6)
    int steps = 0;
    while (!queue.isEmpty()) {
      int remain = queue.size();
      while (remain-- > 0) {
        int polled = queue.poll();
        if (polled == length - 1) { // (7)
          return steps;
        }
        int previous = polled - 1; // (8)
        if (previous >= 0 && !visited[previous]) {
          visited[previous] = true;
          queue.add(previous);
        }
        int next = polled + 1; // (9)
        if (next < length && !visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
        if (set.contains(arr[polled])) { // (10
          continue;
        }
        set.add(arr[polled]); // (11
        for (Integer index : map.get(arr[polled])) { // (12
          if (!visited[index]) {
            visited[index] = true;
            queue.add(index);
          }
        }
      }
      steps++; // (13
    }
    return steps;
  }
}
```

1. 각 정수가 배열의 어느 위치에 각각 존재하는지 저장하기 위핸 Map을 생성합니다.
2. 이미 방문했던 정수를 저장할 Set을 생성합니다.
3. 배열을 탐색하면서 Map에 정수가 출현하는 인덱스들 위치를 저장합니다.
4. 인덱스 별로 방문처리를 위한 배열을 생성합니다.
5. 방문하는 인덱스를 저장할 큐를 생성합니다.
6. 첫 번째 인덱스에서 시작합니다.
7. 큐에 들어있는 인덱스가 마지막 인덱스일 때 현재까지의 이동 횟수를 반환합니다.
8. 현재 인덱스에서 한 칸 앞으로 이동했을 때 방문하지 않았다면 방문처리를 해주고 방문했으므로 큐에 추가해줍니다.
9. 현재 인덱스에서 한 칸 뒤로 이동했을 때 방문하지 않았다면 방문처리를 해주고 방문했으므로 큐에 추가해줍니다.
10. 방문한 인덱스에 해당하는 값을 방문한 적이 있다면 아무것도 하지 않고 다음으로 넘어갑니다.
11. 인덱스에 해당하는 값에도 방문 처리를 해줍니다.
12. 방문한 값에 해당하는 인덱스 모두를 방문처리 하면서 큐에 추가합니다. 마지막 인덱스를 방문하는 것이 빠를 수도 있지만 중간 어느 인덱스로 이동해서 앞으로 또는 뒤로 이동했을 때 최종 목적지를 방문하는 게 더 빨라질 수 있으므로 DFS 알고리즘을 사용하기 위함입니다.
13. 처음으로 방문한 인덱스에 해당하는 값이 출현하는 모든 인덱스에 대해 방문처리를 하였을 때 하나의 이동 횟수가 증가합니다.

## Test

```java
package io.lcalmsky.leetcode.jump_game_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}, 3),
        () -> test(new int[]{7}, 0),
        () -> test(new int[]{7, 6, 9, 6, 9, 6, 9, 7}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minJumps(given);
    // then
    assertEquals(expected, actual);
  }
}
```
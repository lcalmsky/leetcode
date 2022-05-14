> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/network_delay_time/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/network-delay-time/) 있습니다.

## Problem

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

**Example 1:**
```text
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
```
**Example 2:**
```text
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
```
**Example 3:**
```text
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
```

**Constraints:**

* 1 <= k <= n <= 100
* 1 <= times.length <= 6000
* times[i].length == 3
* 1 <= ui, vi <= n
* ui != vi
* 0 <= wi <= 100
* All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

## Solution

1부터 n까지 값을 가지는 n개의 노드로 구성된 그래프와 (시작 노드, 타겟 노드, 시간)으로 구성된 times 배열, 처음 신호를 받는 노드를 가리키는 k가 주어질 때, 노드 k에서 모든 노드에 신호가 도달하는 시간을 구하는 문제입니다. 모든 노드에 신호가 도달할 수 없는 경우 -1을 반환합니다.

다익스트라(Dijkstra) 알고리즘을 이용해 풀이할 수 있습니다.

```java
package io.lcalmsky.leetcode.network_delay_time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int[] time : times) { // 시작 노드를 키로 가지는 맵에 도착 노드와 시간을 인접리스트(adjacent list) 형태로 추가합니다.
      map.putIfAbsent(time[0], new ArrayList<>());
      map.get(time[0]).add(new int[]{time[1], time[2]});
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // 시간을 우선순위로 가지는 우선순위 큐를 생성합니다.
    queue.offer(new int[]{k, 0}); // 첫 노드를 큐에 추가합니다.
    boolean[] visited = new boolean[n + 1]; // 방문 여부를 체크하기 위해 boolean 배열을 생성합니다.
    while (!queue.isEmpty()) { // 큐가 빌 때까지 반복하면서
      int[] current = queue.poll();
      if (visited[current[0]]) { // 이미 방문한 노드는 아무것도 하지 않습니다.
        continue;
      }
      visited[current[0]] = true; // 방문하지 않았다면 방문처리를 합니다.
      if (--n == 0) { // n개의 노드를 모두 방문했을 때 그 때의 누적 시간을 반환합니다.
        return current[1];
      }
      if (map.containsKey(current[0])) { // 현재 노드가 맵에 존재한다면
        for (int[] next : map.get(current[0])) { // 인접리스트들에 대해 걸리는 시간을 계산하여 큐에 다시 추가합니다.
          queue.offer(new int[]{next[0], current[1] + next[1]});
        }
      }
    }
    return -1;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.network_delay_time;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2),
        () -> test(new int[][]{{1, 2, 1}}, 2, 1, 1),
        () -> test(new int[][]{{1, 2, 1}}, 2, 2, -1)
    );
  }

  private void test(int[][] times, int n, int k, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.networkDelayTime(times, n, k);
    // then
    assertEquals(expected, actual);
  }
}
```
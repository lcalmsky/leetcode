> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/all_paths_from_source_to_target/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/all-paths-from-source-to-target/) 있습니다.

## Problem

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg)

```text
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/28/all_2.jpg)

```text
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
```

**Example 3:**

```text
Input: graph = [[1],[]]
Output: [[0,1]]
```

**Example 4:**

```text
Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
```

**Example 5:**

```text
Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
```

**Constraints:**

* n == graph.length
* 2 <= n <= 15
* 0 <= graph[i][j] < n
* graph[i][j] != i (i.e., there will be no self-loops).
* All the elements of graph[i] are unique.
* The input graph is guaranteed to be a DAG.

## Solution

0~n-1까지의 값을 가지는 노드로 이뤄진 방향을 가진 비순환 그래프(DAG)가 주어질 때, 0에서 n-1까지 이동 가능한 모든 경로를 구하는 문제입니다.

전형적인 DFS 문제로 n-1 노드까지 접근했을 때 백트래킹 방식으로 다른 경로를 확인하면서 답을 구하면 됩니다. 

```java
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    path.add(0);
    dfs(graph, 0, path, result);
    return result;
  }

  private void dfs(int[][] graph, int index, List<Integer> path, List<List<Integer>> rst) {
    if (index == graph.length - 1) {
      rst.add(new LinkedList<>(path));
      return;
    }
    for (int neighbor : graph[index]) {
      path.add(neighbor);
      dfs(graph, neighbor, path, rst);
      path.remove(path.size() - 1);
    }
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.all_paths_from_source_to_target;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenDirectedAcyclicGraph_whenFindAllPaths_thenCorrect() {
    assertAll(
        () -> test(new int[][]{{1, 2}, {3}, {3}, {}}, List.of(List.of(0, 1, 3), List.of(0, 2, 3))),
        () -> test(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}},
            List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4),
                List.of(0, 1, 4))),
        () -> test(new int[][]{{1}, {}}, List.of(List.of(0, 1))),
        () -> test(new int[][]{{1, 2, 3}, {2}, {3}, {}},
            List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3))),
        () -> test(new int[][]{{1, 3}, {2}, {3}, {}}, List.of(List.of(0, 1, 2, 3), List.of(0, 3)))
    );
  }

  private void test(int[][] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.allPathsSourceTarget(given);
    // then
    assertEquals(expected, actual);
  }
}
```



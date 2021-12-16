> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/insertion_sort_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/insertion-sort-list/) 있습니다.

## Problem

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/01/e1.jpg)

```text
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/01/e2.jpg)

```text
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
```
**Example 3:**

```text
Input: n = , edges = []
Output: [0]
```
**Example 4:**

```text
Input: n = , edges = [[0,1]]
Output: [0,1]
```

**Constraints:**

* 1 <= n <= 2 * 10^4
* edges.length == n - 1
* 0 <= ai, bi < n
* ai != bi
* All the pairs (ai, bi) are distinct.
* The given input is guaranteed to be a tree and there will be no repeated edges.

## Solution

트리(순환 없이 연결된 그래프)를 구성하는 edge들이 주어질 때 가장 높이가 작은 트리의 root 노드의 값을 반환하는 문제입니다. 이 때 root 노드의 값이 여러 개일 수 있으므로 모두 반환해줘야 합니다.

```java
package io.lcalmsky.leetcode.minimum_height_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 0) {
      return Collections.emptyList();
    }
    if (n == 1) {
      return Collections.singletonList(0);
    }
    List<Set<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new HashSet<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    Deque<Integer> leaves = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (graph.get(i).size() == 1) {
        leaves.offer(i);
      }
    }
    while (n > 2) {
      n = n - leaves.size();
      Deque<Integer> newLeaves = new LinkedList<>();
      for (int leave : leaves) {
        int neighbor = graph.get(leave).iterator().next();
        graph.get(neighbor).remove(leave);
        if (graph.get(neighbor).size() == 1) {
          newLeaves.add(neighbor);
        }
      }
      leaves = newLeaves;
    }
    return new ArrayList<>(leaves);
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.minimum_height_trees;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenEdgesAndNumberOfNodes_whenFindRootNodeWithMinimumHeightTree_thenCorrect() {
    assertAll(
        () -> test(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, List.of(1)),
        () -> test(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}, List.of(3, 4)),
        () -> test(1, new int[][]{}, List.of(0))
    );
  }

  private void test(int n, int[][] edges, List<Integer> expected) {
    // when
    Solution minimumHeightTrees = new Solution();
    List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n, edges);
    // then
    assertEquals(expected, actual);
  }
}
```
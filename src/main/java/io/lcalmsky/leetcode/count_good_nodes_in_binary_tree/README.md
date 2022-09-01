> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/count_good_nodes_in_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) 있습니다.

## Problem

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/04/02/test_sample_1.png)

```text
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/04/02/test_sample_2.png)

```text
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
```

**Example 3:**
```text
Input: root = [1]
Output: 1
Explanation: Root is considered as good.
```

**Constraints:**

* The number of nodes in the binary tree is in the range [1, 10^5].
* Each node's value is between [-10^4, 10^4].

## Solution

이진트리의 루트 노드가 주어지고, 루트에서 X 노드로 향하는 경로 안에서 X보다 큰 값을 가진 노드가 존재하지 않는 경우 X 노드를 good 노드라고 부를 때 good 노드의 개수를 구하는 문제입니다.

```java
import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private int numGoodNodes = 0;

  public int goodNodes(TreeNode root) {
    dfs(root, Integer.MIN_VALUE);
    return numGoodNodes;
  }

  private void dfs(TreeNode node, int maxSoFar) {
    if (maxSoFar <= node.val) {
      numGoodNodes++;
    }
    if (node.right != null) {
      dfs(node.right, Math.max(node.val, maxSoFar));
    }
    if (node.left != null) {
      dfs(node.left, Math.max(node.val, maxSoFar));
    }
  }
}

```

DFS를 이용해 root 노드에서 순차적으로 탐색하면서 현재까지 중 최대값과 비교하여 노드의 값이 더 큰 경우 good 노드의 개수를 증가시킵니다. 

## Test

```java
package io.lcalmsky.leetcode.count_good_nodes_in_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(3, 1, 4, 3, null, 1, 5), 4),
        () -> test(TreeNode.of(3, 3, null, 4, 2), 3),
        () -> test(TreeNode.of(1), 1)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.goodNodes(given);
    // then
    assertEquals(expected, actual);
  }

}
```
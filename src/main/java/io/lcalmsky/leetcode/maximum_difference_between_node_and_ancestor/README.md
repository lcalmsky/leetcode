> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_difference_between_node_and_ancestor/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/) 있습니다.

## Problem

Given the root of a binary tree, find the maximum value v for which there exist different nodes `a` and `b` where v = |a.val - b.val| and `a` is an ancestor of `b`.

A node `a` is an ancestor of `b` if either: any child of `a` is equal to `b` or any child of `a` is an ancestor of `b`.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/09/tmp-tree.jpg)

```text
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
```
**Example 2:**

![](https://assets.leetcode.com/uploads/2020/11/09/tmp-tree-1.jpg)

```text
Input: root = [1,null,2,null,0,3]
Output: 3
```

**Constraints:**

* The number of nodes in the tree is in the range [2, 5000].
* 0 <= Node.val <= 10^5

## Solution

이진 트리의 root 노드가 주어질 때 조상 노드와 자식 노드간의 차이가 가장 큰 값을 구하는 문제입니다.

재귀호출로 노드를 탐색하면서 최댓값과 최솟값을 갱신하여 최종적으로 차이의 절대값을 구하면 됩니다.

```java
package io.lcalmsky.leetcode.maximum_difference_between_node_and_ancestor;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return maxDiff(root, root.val, root.val);
  }

  private int maxDiff(TreeNode node, int min, int max) {
    if (node == null) {
      return Math.abs(max - min);
    }
    if (node.val < min) {
      min = node.val;
    }
    if (node.val > max) {
      max = node.val;
    }
    return Math.max(maxDiff(node.left, min, max), maxDiff(node.right, min, max));
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.maximum_difference_between_node_and_ancestor;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13), 7),
        () -> test(TreeNode.of(1, null, 2, null, 0, 3), 3)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxAncestorDiff(given);
    // then
    assertEquals(expected, actual);
  }
}
```
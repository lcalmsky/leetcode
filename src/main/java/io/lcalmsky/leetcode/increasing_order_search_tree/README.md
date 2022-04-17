> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/increasing_order_search_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/increasing-order-search-tree/) 있습니다.

## Problem

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.



**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/17/ex1.jpg)
```text
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
```
**Example 2:**

```text
Input: root = [5,1,7]
Output: [1,null,5,null,7]
```

**Constraints:**

* The number of nodes in the given tree will be in the range [1, 100].
* 0 <= Node.val <= 1000

## Solution

이진 탐색 트리의 root노드가 주어질 때 가장 왼쪽 노드가 root 노드가 되고, 모든 노드가 root 노드의 오른쪽 노드가 되도록 재배열하는 문제입니다.

```java
package io.lcalmsky.leetcode.increasing_order_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private TreeNode head;
  private TreeNode current;

  public TreeNode increasingBST(TreeNode root) {
    traverse(root);
    return head;
  }

  private void traverse(TreeNode node) {
    if (node == null) {
      return;
    }
    traverse(node.left); // (1)
    TreeNode n = new TreeNode(node.val); 
    if (head == null) { // (2) 
      head = n;
      current = n;
    } else { // (3)
      current.right = n;
      current = current.right;
    }
    traverse(node.right); // (4)
  }
}

```

1. 왼쪽 노드를 먼저 탐색합니다.
2. head가 존재하지 않으면 현재 노드를 root 노드로 설정하빈다.
3. head가 존재하면 기존 노드의 우측 노드로 추가합니다.
4. 오른쪽 노드를 탐색하며 같은 동작을 반복합니다.

## Test

```java
package io.lcalmsky.leetcode.increasing_order_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9),
            TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9)),
        () -> test(TreeNode.of(5, 1, 7), TreeNode.of(1, null, 5, null, 7))
    );
  }

  private void test(TreeNode given, TreeNode expected) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.increasingBST(given);
    // then
    assertEquals(expected, actual);
  }
}
```
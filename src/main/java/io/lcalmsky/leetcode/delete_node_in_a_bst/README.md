> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/delete_node_in_a_bst/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/delete-node-in-a-bst/) 있습니다.

## Problem

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/04/del_node_1.jpg)

```text
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/04/del_node_supp.jpg)

```text
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
```

**Example 3:**

```text
Input: root = [], key = 0
Output: []
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 10^4].
* -10^5 <= Node.val <= 10^5
* Each node has a unique value.
* root is a valid binary search tree.
* -10^5 <= key <= 10^5

## Solution

이진 탐색 트리에서 주어진 값을 제거하는 문제입니다.

이진 탐색 트리는 무조건 현재 노드보다 왼쪽 노드의 값이 작고 오른쪽 노드의 값이 큽니다.

특정 값을 찾아 해당 값을 제거하면서 나머지 노드들을 정리하는 작업이 필요합니다.

```java
public class Solution {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) { // (1)
      return root;
    }
    if (key < root.val) { // (2)
      root.left = deleteNode(root.left, key);
      return root;
    }
    if (key > root.val) { // (3)
      root.right = deleteNode(root.right, key);
      return root;
    }
    if (root.left == null) { // (4)
      return root.right;
    }
    if (root.right == null) { // (5)
      return root.left;
    }
    // (6)
    TreeNode node = findNode(root.right);
    node.left = root.left;
    return root.right;
  }

  private TreeNode findNode(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
```

1. 현재 노드가 `null`이면 `null`을 반환합니다.
2. 현재 노드의 value가 key보다 크면 left node를 탐색합니다.
3. 현재 노드의 value가 key보다 작으면 right node를 탐색합니다.
4. 현재 노드의 value가 key와 같을 때 left node가 존재하지 않으면 right node를 반환합니다.
5. 현재 노드의 value가 key와 같을 때 right node가 존재하지 않으면 left node를 반환합니다.
6. 현재 노드의 value가 key와 같고 left, right node가 모두 존재할 때는 left node < right node가 항상 성립하므로 현재 node를 right node로 대체해야 합니다. 이 때 동작은 right 노드를 탐색하여 지우는 동작과 동일합니다.

## Test

```java
package io.lcalmsky.leetcode.delete_node_in_a_bst;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.lcalmsky.leetcode.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  void givenBstNode_whenDeleteNode_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(5, 3, 6, 2, 4, null, 7), 3,
            List.of(TreeNode.of(5, 4, 6, 2, null, null, 7), TreeNode.of(5, 2, 6, null, 4, null, 7)))
    );
  }

  private void test(TreeNode given, int key, List<TreeNode> expected) {
    // when
    Solution deleteNodeInABst = new Solution();
    TreeNode actual = deleteNodeInABst.deleteNode(given, key);

    // then
    assertTrue(expected.contains(actual));
  }
}
```
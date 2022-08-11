> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/validate_binary_search_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/validate-binary-search-tree/) 있습니다.

## Problem

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


**Example 1:**

```text
Input: root = [2,1,3]
Output: true
```
**Example 2:**

```text
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* -2^31 <= Node.val <= 2^31 - 1

## Solution

이진 트리의 루트 노드가 주어질 때 유효한 이진 탐색 트리인지 확인하는 문제입니다.

이진 탐색 트리(BST)는 다음과 같이 정의됩니다.

노드의 왼쪽 하위 트리에는 노드 키보다 작은 키가 있는 노드만 포함됩니다. 노드의 오른쪽 하위 트리에는 노드 키보다 큰 키가 있는 노드만 포함됩니다. 왼쪽 및 오른쪽 하위 트리도 모두 이진 검색 트리여야 합니다.

```java
import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  private boolean isValidBST(TreeNode node, double min, double max) {
    if (node == null) {
      return true;
    }
    if (node.val <= min || node.val >= max) {
      return false;
    }
    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
  }
}
```

재귀호출로 각 노드를 탐색하면서 BST 조건에 부합하는지 확인합니다.

## Test

```java
package io.lcalmsky.leetcode.validate_binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenValidate_thenCorrect() {
    assertAll(() -> test(TreeNode.of(2, 1, 3), true), () -> test(TreeNode.of(5, 1, 4, null, null, 3, 6), false),
        () -> test(TreeNode.of(10, 5, 15, null, null, 6, 20), false));
  }

  private void test(TreeNode given, boolean expected) {
    // when
    Solution validateBinarySearchTree = new Solution();
    boolean actual = validateBinarySearchTree.isValidBST(given);

    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/binary_tree_preorder_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/binary-tree-preorder-traversal/) 있습니다.

## Problem

Given the root of a binary tree, return the preorder traversal of its nodes' values.

**Example 1:**
```text
Input: root = [1,null,2,3]
Output: [1,2,3]
```

**Example 2:**
```text
Input: root = []
Output: []
```

**Example 3:**
```text
Input: root = [1]
Output: [1]
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 100].
* -100 <= Node.val <= 100

## Solution

이진 트리의 루트 노드가 주어질 때, preorder로 순회하면서 노드를 반환하는 문제입니다.

트리 순회 문제는 재귀호출로 풀 수 있습니다.

```java
import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> order = new ArrayList<>();
    preorder(root, order);
    return order;
  }

  private void preorder(TreeNode root, List<Integer> order) {
    if (root == null) {
      return;
    }
    order.add(root.val);
    preorder(root.left, order);
    preorder(root.right, order);
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.binary_tree_preorder_traversal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenPreorderTraverse_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, null, 2, 3), Arrays.asList(1, 2, 3))
    );
  }

  private void test(TreeNode given, List<Integer> expected) {
    // when
    Solution binaryTreePreorderTraversal = new Solution();
    List<Integer> actual = binaryTreePreorderTraversal.preorderTraversal(given);

    // then
    assertEquals(expected, actual);
  }
}
```
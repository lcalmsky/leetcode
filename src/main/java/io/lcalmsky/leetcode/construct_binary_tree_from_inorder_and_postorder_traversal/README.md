> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/construct_binary_tree_from_inorder_and_postorder_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) 있습니다.

## Problem

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/tree.jpg)

```text
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
```

**Example 2:**

```text
Input: inorder = [-1], postorder = [-1]
Output: [-1]
```

**Constraints:**

* 1 <= inorder.length <= 3000
* postorder.length == inorder.length
* -3000 <= inorder[i], postorder[i] <= 3000
* inorder and postorder consist of unique values.
* Each value of postorder also appears in inorder.
* inorder is guaranteed to be the inorder traversal of the tree.
* postorder is guaranteed to be the postorder traversal of the tree.

## Solution

inorder와 postorder로 구성된 배열이 주어질 때 실제 이진 트리를 구성하는 문제입니다.

postorder의 마지막 원소는 구성할 트리의 루트 원소입니다.

inorder의 경우 root 원소를 기준으로 왼쪽 원소들이 해당 노드의 left를 구성하게 될 것이고, 오른쪽 원소들이 해당 노드의 right를 구성하게 될 것입니다.



이런 작업을 반복해서 진행해나가면 이진 트리를 구성할 수 있게 됩니다.

```java
public class Solution {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  public TreeNode buildTree(int[] inorder, int inorderLeft, int inorderRight,
      int[] postorder, int postorderLeft, int postorderRight) {
    if (inorderLeft > inorderRight || postorderLeft > postorderRight) {
      return null;
    }
    int rootValue = postorder[postorderRight]; // (1)
    TreeNode root = new TreeNode(rootValue); // (1)
    int rootIndexOfInorder = getRootIndexOfInorder(inorder, rootValue); // (2)
    root.left = buildTree(inorder, inorderLeft, rootIndexOfInorder - 1,
        postorder, postorderLeft, postorderLeft + rootIndexOfInorder - (inorderLeft + 1)); // (3)
    root.right = buildTree(inorder, rootIndexOfInorder + 1, inorderRight,
        postorder, postorderLeft + rootIndexOfInorder - inorderLeft, postorderRight - 1); // (4)
    return root; // (5)
  }

  private int getRootIndexOfInorder(int[] inorder, int rootValue) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == rootValue) {
        return i;
      }
    }
    throw new IllegalStateException();
  }
}
```

1. postorder의 마지막 원소(현재 기준)는 root 노드의 값이 됩니다.
2. 1번에서 찾은 root 노드의 값으로 inorder에서 몇 번째 위치하는지 찾습니다.
3. 현재 노드(root)의 왼쪽 노드를 재귀 호출로 만듧니다. 이 때 inorder의 범위는 root 노드 전까지, postorder의 범위는 inorder의 갯수만큼 입니다.
4. 현재 노드(root)의 오른쪽 노드를 재귀호출로 만듭니다. 이 때 inorder의 범위는 root 노드 다음부터 끝까지, postorder의 범위는 inorder의 갯수만큼부터 루트 노드를 제외한 끝까지 입니다.
5. 1번에서 생성한 루트 노드를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenInorderAndPostorder_whenBuildTree_theCorrect() {
    assertAll(
        () -> test(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3},
            TreeNode.of(3, 9, 20, null, null, 15, 7))
    );
  }

  private void test(int[] inorder, int[] postorder, TreeNode expected) {
    // when
    Solution constructBinaryTreeFromInorderAndPostorderTraversal = new Solution();
    TreeNode actual = constructBinaryTreeFromInorderAndPostorderTraversal.buildTree(inorder,
        postorder);

    // then
    assertEquals(expected, actual);
  }
}
```
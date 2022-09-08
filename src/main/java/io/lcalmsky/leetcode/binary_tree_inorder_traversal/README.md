> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/binary_tree_inorder_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/binary-tree-inorder-traversal/) 있습니다.

## Problem

Given the root of a binary tree, return the inorder traversal of its nodes' values.

**Example 1:**
```text
Input: root = [1,null,2,3]
Output: [1,3,2]
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

이진 트리의 루트 노드가 주어졌을 때 inorder 방식으로 순회하는 문제입니다.

이전 문제와 아주 유사한 문제로 전위, 중위, 후위로 순회해야하는 경우 재귀호출 시 규칙이 있는데 그것만 알고있으면 간단히 풀이할 수 있습니다.

```java
import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    travel(result, root);
    return result;
  }

  private void travel(List<Integer> result, TreeNode root) {
    if (root == null) {
      return;
    }
    travel(result, root.left); // 1
    result.add(root.val); // 2
    travel(result, root.right); // 3
  }
}
```

preorder의 경우 2 -> 1 -> 3 순으로, inorder의 경우 1 -> 2 -> 3 순으로, postorder의 경우 1 -> 3 -> 2 순으로 재귀호출하면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.binary_tree_inorder_traversal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTree_whenInorderTravel_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, null, 2, 3), Arrays.asList(1, 3, 2))
    );
  }

  private void test(TreeNode given, List<Integer> expected) {
    // when
    Solution binaryTreeInorderTraversal = new Solution();
    List<Integer> actual = binaryTreeInorderTraversal.inorderTraversal(given);
    // then
    assertEquals(expected, actual);
  }
}
```
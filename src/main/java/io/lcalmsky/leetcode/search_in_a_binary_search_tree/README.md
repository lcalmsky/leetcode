> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/search_in_a_binary_search_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/search-in-a-binary-search-tree/) 있습니다.

## Problem

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.


**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/12/tree1.jpg)

```text
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/12/tree2.jpg)

```text
Input: root = [4,2,7,1,3], val = 5
Output: []
```


Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107

## Solution

이진 탐색 트리가 주어지고 타겟 정수가 주어지면 타겟 정수에 해당하는 노드를 반환하는 문제입니다.

노드가 존재하지 않을 경우 `null`을 반환합니다.

```java
package io.lcalmsky.leetcode.search_in_a_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) { // (1)
      return null;
    }
    if (root.val > val) { // (2)
      return searchBST(root.left, val);
    }
    if (root.val < val) { // (3)
      return searchBST(root.right, val);
    }
    return root; // (4)
  }
}
```

1. 노드가 null이면 null을 반환합니다.
2. 현재 노드의 값이 타겟 정수의 값보다 크면 left 노드를 기준으로 다시 호출합니다.
3. 현재 노드의 값이 타겟 정수의 값보다 작으면 right 노드를 기준으로 다시 호출합니다.
4. 현재 노드의 값과 타겟 정수의 값이 같으면 현재 노드를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.search_in_a_binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenFindTargetNumber_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(4, 2, 7, 1, 3), 2, TreeNode.of(2, 1, 3)),
        () -> test(TreeNode.of(4, 2, 7, 1, 3), 5, null)
    );
  }

  private void test(TreeNode given, int k, TreeNode expected) {
    Solution solution = new Solution();
    TreeNode actual = solution.searchBST(given, k);
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/binary_tree_pruning/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/binary-tree-pruning/) 있습니다.

## Problem

Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.



**Example 1:**

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_2.png)
```text
Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
```

**Example 2:**

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/06/1028_1.png)
```text
Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]
```

**Example 3:**

![](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/05/1028.png)
```text
Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 200].
* Node.val is either 0 or 1.

## Solution

이진 트리의 루트 노드가 주어졌을 때 1을 포함하지 않는 모든 하위 트리를 제거하는 문제입니다.

재귀 호출을 이용해 간단히 풀이할 수 있습니다.

```java
import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) {
      return null;
    }
    return root;
  }
}
```

자식이 없을 때까지 탐색을 한 뒤 그 노드가 0인 경우 null로 바꿔주면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.binary_tree_pruning;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenPrune_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, null, 0, 0, 1), TreeNode.of(1, null, 0, null, 1)),
        () -> test(TreeNode.of(1, 0, 1, 0, 0, 0, 1), TreeNode.of(1, null, 1, null, 1))
    );
  }

  private void test(TreeNode given, TreeNode expected) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.pruneTree(given);

    // then
    assertEquals(expected, actual);
  }
}
```
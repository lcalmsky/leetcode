> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/invert_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/invert-binary-tree/) 있습니다.

## Problem

Given the root of a binary tree, invert the tree, and return its root.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg)

```text
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg)

```text
Input: root = [2,1,3]
Output: [2,3,1]
```

**Example 3:**

```text
Input: root = []
Output: []
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 100].
* -100 <= Node.val <= 100

## Solution

이진 트리가 주어졌을 때 루트 노드를 기준으로 뒤집는 문제입니다.

재귀호출을 이용해 좌우 노드를 바꿔주면 간단히 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.invert_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;
        swap(root);
        invert(root.left);
        invert(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.invert_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void givenTreeNode_whenInvert_thenCorrect() {
        assertAll(
            () -> test(TreeNode.of(4, 2, 7, 1, 3, 6, 9), TreeNode.of(4, 7, 2, 9, 6, 3, 1))
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        Solution invertBinaryTree = new Solution();
        TreeNode actual = invertBinaryTree.invertTree(given);

        // then
        assertEquals(expected, actual);
    }
}
```
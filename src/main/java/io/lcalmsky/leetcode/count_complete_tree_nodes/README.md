> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/count_complete_tree_nodes/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/count-complete-tree-nodes/) 있습니다.

## Problem

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/14/complete.jpg)

```text
Input: root = [1,2,3,4,5,6]
Output: 6
```

**Example 2:**

```text
Input: root = []
Output: 0
```

**Example 3:**

```text
Input: root = [1]
Output: 1
```

**Constraints:**

^ The number of nodes in the tree is in the range [0, 5 * 104].
^ 0 <= Node.val <= 5 * 10^4
^ The tree is guaranteed to be complete.

## Solution

완전 이진트리가 주어졌을 때 전체 노드의 갯수를 세는 문제입니다.

Medium 난이도지만 너무 쉬워서 당황스러운 문제입니다.

recursive call을 이용해 풀 수 있습니다.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.count_complete_tree_nodes;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenCompleteTree_whenCount_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution countCompleteTreeNodes = new Solution();
        int actual = countCompleteTreeNodes.countNodes(given);
        // then
        assertEquals(expected, actual);
    }
}
```
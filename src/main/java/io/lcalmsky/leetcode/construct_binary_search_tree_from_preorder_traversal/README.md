> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/construct_binary_search_tree_from_preorder_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) 있습니다.

## Problem

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/03/06/1266.png)

```text
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
```

**Example 2:**

```text
Input: preorder = [1,3]
Output: [1,null,3]
```

**Constraints:**

* 1 <= preorder.length <= 100
* 1 <= preorder[i] <= 10&8
* All the values of preorder are unique.

## Solution

preorder 정수 배열이 주어졌을 때 다시 이진 검색 트리로 복원하는 문제입니다.

이진 검색 트리의 특성을 잘 생각해서 풀어야하는 문제입니다.

먼저 루트 기준으로 왼쪽에는 항상 루트보다 작은 값이 위치해야하고, preorder의 특성상 이 부분까지는 구현하기 매우 쉽습니다.

이전 값보다 현재 값이 높아지는 순간이 left 노드에서 right 노드로 넘어가는 순간인데 이 때 최댓값을 갱신해주지 않으면 숫자 비교를 제대로 할 수 없습니다.

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
public class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int max) {
        if (index == preorder.length || preorder[index] > max) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = bstFromPreorder(preorder, node.val);
        node.right = bstFromPreorder(preorder, max);
        return node;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.construct_binary_search_tree_from_preorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPreorder_whenConstructBinarySearchTree_thenCorrect() {
        assertAll(
                () -> test(new int[]{8, 5, 1, 7, 10, 12}, TreeNode.of(8, 5, 10, 1, 7, null, 12)),
                () -> test(new int[]{1, 3}, TreeNode.of(1, null, 3))
        );
    }

    private void test(int[] given, TreeNode expected) {
        // when
        Solution solution = new Solution();
        TreeNode actual = solution.bstFromPreorder(given);
        // then
        assertEquals(expected, actual);
    }
}
```
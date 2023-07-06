> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/lowest_common_ancestor_of_a_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) 있습니다.

## Problem

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

**Example 1:**
```text
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
```

**Example 2:**
```text
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
```

**Example 3:**
```text
Input: root = [1,2], p = 1, q = 2
Output: 1
```

**Constraints:**

* The number of nodes in the tree is in the range [2, 10^5].
* -10^9 <= Node.val <= 10^9
* All Node.val are unique.
* p != q
* p and q will exist in the tree.

## Solution

이진 트리와 두 노드가 주어질 때 LCA (Lowest Common Ancestor; 최소 공통 조상)를 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.lowest_common_ancestor_of_a_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

import java.util.Optional;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return Optional.ofNullable(left).orElse(right);
    }
}

```

1. 먼저, 주어진 root가 null이거나 p와 q 중 하나와 동일한 경우, 현재 root가 가장 낮은 공통 조상이므로 root를 반환합니다.
1. 그렇지 않은 경우, 현재 노드를 기준으로 왼쪽 서브트리와 오른쪽 서브트리에 대해 재귀적으로 lowestCommonAncestor 메서드를 호출합니다. 이를 통해 p와 q의 가장 낮은 공통 조상을 찾습니다.
1. 왼쪽 서브트리에서 반환된 결과를 left에 저장하고, 오른쪽 서브트리에서 반환된 결과를 right에 저장합니다.
1. 만약 left와 right가 모두 null이 아니라면, 즉, 현재 노드를 기준으로 p와 q가 왼쪽 서브트리와 오른쪽 서브트리에 모두 존재한다면, 현재 노드가 가장 낮은 공통 조상이 됩니다. 따라서 현재 root를 반환합니다.
1. 그렇지 않은 경우, left와 right 중 null이 아닌 값을 선택하여 반환합니다. Optional.ofNullable을 사용하여 null일 경우에도 결과를 반환할 수 있도록 처리합니다. 만약 left가 null이라면 right가 반환되고, right가 null이라면 left가 반환됩니다.

## Test

TreeNode를 제대로 구현하지 못해 테스트 코드 작성에 실패하였습니다😭
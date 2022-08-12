> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/losest_common_ancester_of_a_binary_search_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/losest-common-ancester-of-a-binary-search-tree/) 있습니다.

## Problem

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)

```text
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)

```text
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
```

**Example 3:**

```text
Input: root = [2,1], p = 2, q = 1
Output: 2
```

**Constraints:**

* The number of nodes in the tree is in the range [2, 10^5].
* -10^9 <= Node.val <= 10^9
* All Node.val are unique.
* p != q
* p and q will exist in the BST.

## Solution

이진 탐색 트리와 두 노드가 주어질 때 두 노드의 가장 작은 공통 조상을 구하는 문제입니다.

두 노드가 위로 이동하면서 처음으로 만나는 지점을 구하는 것이라고 할 수 있습니다.

```java
import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null && right == null) {
      return null;
    }
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}
```

노드 p, q를 먼저 찾은 뒤 두 노드를 비교해 공통 조상을 찾을 수 있습니다.
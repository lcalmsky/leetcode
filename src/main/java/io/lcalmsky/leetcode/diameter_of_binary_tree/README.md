> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/diameter_of_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/diameter-of-binary-tree/) 있습니다.

## Problem

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg)

```text
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
```

**Example 2:**

```text
Input: root = [1,2]
Output: 1
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* -100 <= Node.val <= 100

## Solution

이진트리가 주어졌을 때 이진트리의 직경(diameter)을 구하는 문제입니다.

여기서 직경은 트리 내에서 두 개의 노드 사이의 가장 긴 경로의 길이를 말합니다.

`easy` 레벨이지만 난이도가 조금 있는 편입니다.

```java
public class Solution {
    private int max = 0; // (1)

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max - 1; // (2)
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left); // (3)
        int right = getMaxDepth(root.right); // (4)
        max = Math.max(max, 1 + left + right); // (5)
        return 1 + Math.max(left, right); // (6)
    }
}
```

1. 전체 최대 길이를 저장하기 위한 변수입니다.
2. 왼쪽, 오른쪽 노드에 대해 길이를 모두 저장하기 때문에 중복되는 길이 1을 빼줘서 반환합니다.
3. 왼쪽 노드에 대해 최대 깊이를 탐색합니다.
4. 오른쪽 노드에 대해 최대 깊이를 탐색합니다.
5. 양쪽 노드에 대해 최대 깊이를 갱신합니다.
6. 현재 노드의 부모 노드에 현재까지의 최대 깊이를 전달합니다.

## Test

```java
package io.lcalmsky.leetcode.diameter_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenTreeNode_whenFindDiameterOfBinaryTree_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4, 5), 3),
                () -> test(TreeNode.of(1, 2), 1)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.diameterOfBinaryTree(given);

        // then
        assertEquals(expected, actual);
    }
}
```
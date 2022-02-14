> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_depth_of_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-depth-of-binary-tree/) 있습니다.

## Problem

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down
to the farthest leaf node.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg)

```text
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

**Example 2:**

```text
Input: root = [1,null,2]
Output: 2
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 104].
* -100 <= Node.val <= 100

## Solution

이진 트리의 루트 노드가 주어졌을 때 해당 트리의 최대 깊이를 구하는 문제입니다.

재귀호출을 이용해 간단히 구현할 수 있습니다.

```java
package io.lcalmsky.leetcode.maximum_depth_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.maximum_depth_of_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), 3),
        () -> test(TreeNode.of(1, null, 2), 2)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxDepth(given);
    // then
    assertEquals(expected, actual);
  }
}
```
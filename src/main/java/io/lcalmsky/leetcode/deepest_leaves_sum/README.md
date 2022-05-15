> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/deepest_leaves_sum/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/deepest-leaves-sum/) 있습니다.

## Problem

Given the root of a binary tree, return the sum of values of its deepest leaves.

![](https://assets.leetcode.com/uploads/2019/07/31/1483_ex1.png)

**Example 1:**
```text
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
```

**Example 2:**
```text
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* 1 <= Node.val <= 100

## Solution

이진 트리의 루트노드가 주어질 때 가장 깊은 노드의 합을 반환하는 문제입니다.

먼저 트리의 depth를 구한 뒤 재귀호출을 이용해 간단히 풀 수 있습니다.

```java
package io.lcalmsky.leetcode.deepest_leaves_sum;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int deepestLeavesSum(TreeNode root) {
    int depth = countDepth(root);
    return sum(root, 1, depth);
  }

  private int countDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(countDepth(root.left), countDepth(root.right));
  }

  private int sum(TreeNode root, int currentDepth, int depth) {
    if (root == null) {
      return 0;
    }
    if (currentDepth == depth) {
      return root.val;
    }
    return sum(root.left, currentDepth + 1, depth) + sum(root.right, currentDepth + 1, depth);
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.deepest_leaves_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8), 15),
        () -> test(TreeNode.of(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5), 19)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.deepestLeavesSum(given);
    // then
    assertEquals(expected, actual);
  }
}
```
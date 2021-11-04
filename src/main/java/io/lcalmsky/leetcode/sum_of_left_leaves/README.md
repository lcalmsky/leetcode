> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sum_of_left_leaves/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/sum-of-left-leaves/) 있습니다.

## Problem

Given the root of a binary tree, return the sum of all left leaves.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/04/08/leftsum-tree.jpg)

```text
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
```

**Example 2:**

```text
Input: root = [1]
Output: 0
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 1000].
* -1000 <= Node.val <= 1000

## Solution

이진 트리에서 모든 왼쪽 leaf 노드의 합을 구하는 문제입니다.

왼쪽 노드가 leaf 노드일 때 해당 노드의 값을 계속 더해주고, leaf 노드가 아닐 때는 왼쪽 노드를 재귀호출로 다시 탐색해 반복합니다.

왼쪽 노드를 다 탐색한 다음에는 오른쪽 노드도 동일하게 탐색하여 오른쪽 노드의 왼쪽 leaf 노드가 존재하면 값을 더해줘 반환합니다.

```java
public class Solution {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (root.left != null) {
      if (isLeaf(root.left)) {
        sum += root.left.val;
      } else {
        sum += sumOfLeftLeaves(root.left);
      }
    }
    sum += sumOfLeftLeaves(root.right);
    return sum;
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.sum_of_left_leaves;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTreeNodes_whenSumLeftLeaves_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), 24)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution sumOfLeftLeaves = new Solution();
    int actual = sumOfLeftLeaves.sumOfLeftLeaves(given);

    // then
    assertEquals(expected, actual);
  }
}
```
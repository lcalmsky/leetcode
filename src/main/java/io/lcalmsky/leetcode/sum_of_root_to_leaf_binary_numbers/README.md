> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sum_of_root_to_leaf_binary_numbers/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/) 있습니다.

## Problem

You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png)

```text
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

**Example 2:**

```text
Input: root = [0]
Output: 0
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 1000].
* Node.val is 0 or 1.

## Solution

0과 1로 이루어진 이진트리가 주어질 때 루트 노드부트 리프 노드까지를 이진수로 변환하여 이진수들의 합을 구하는 문제입니다.

```java
import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return sum(root, 0);
  }

  private int sum(TreeNode node, int parentValue) {
    if (node == null) {
      return 0;
    }
    int current = parentValue * 2 + node.val; // (1) 
    if (node.left == null && node.right == null) { // (2) 
      return current;
    }
    return sum(node.left, current) + sum(node.right, current); // (3) 
  }
}
```

1. 이진수를 십진수로 변환하기 위해 기존 값에 2를 곱하고 현재 값을 더해줍니다.
2. 현재 노드가 리프 노드일 때 현재까지 계산된 값을 반환합니다.
3. 현재 노드의 left, right 노드를 탐색하며 반환값을 더해줍니다.

## Test

```java
package io.lcalmsky.leetcode.sum_of_root_to_leaf_binary_numbers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(1, 0, 1, 0, 1, 0, 1), 22),
        () -> test(TreeNode.of(0), 0)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.sumRootToLeaf(given);
    // then
    assertEquals(expected, actual);
  }
}
```
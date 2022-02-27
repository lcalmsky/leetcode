> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximum_width_of_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximum-width-of-binary-tree/) 있습니다.

## Problem

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.


**Example 1:**

```text
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
```
**Example 2:**

```text
Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
```
**Example 3:**

```text
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
```


**Constraints:**

* The number of nodes in the tree is in the range [1, 3000].
* -100 <= Node.val <= 100

## Solution

이진 트리의 루트 노드가 주어졌을 때 트리의 최대 너비를 구하는 문제입니다.

DFS 방식으로 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.maximum_width_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int widthOfBinaryTree(TreeNode root) {
    return dfs(root, 1, 0, new ArrayList<>());
  }

  private int dfs(TreeNode node, Integer index, Integer depth, List<Integer> leftMost) {
    if (node == null) { // (1)
      return 0;
    }
    if (depth >= leftMost.size()) { // (2)
      leftMost.add(index);
    }
    int current = index - leftMost.get(depth) + 1; // (3) 
    int left = dfs(node.left, index * 2, depth + 1, leftMost); // (4)
    int right = dfs(node.right, index * 2 + 1, depth + 1, leftMost); // (5) 
    return Math.max(current, Math.max(left, right)); // (6)
  }
}
```

1. 노드가 null이면 0을 반환합니다.
2. 현재 depth가 leftmost 리스트의 사이즈보다 크거나 같을 때 leftmost 리스트에 현재 인덱스를 추가합니다.
3. 현재 너비는 인덱스에서 가장 왼쪽 인덱스 값을 뺀 것에 1을 더한 값입니다.
4. 왼쪽 노드에 대해 재귀호출로 같은 작업을 수행합니다. 이 때 depth는 1 증가하고 인덱스는 두 배가 됩니다.
5. 오른쪽 노드에 대해 같은 재귀호출로 같은 작업을 수행합니다. 이 때 depth는 1 증가하고 인덱스는 두 배를 더한 뒤 1을 더해줍니다.
6. 현재 너비와 왼쪽 노드의 너비, 오른쪽 노드의 너비 세 가지를 비교해 가장 높은 값을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.maximum_width_of_binary_tree;

import static org.junit.jupiter.api.Assertions.*;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  public void givenBinaryTree_whenFindMaximumWidth_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, 3, 2, 5, 3, null, 9), 4),
        () -> test(TreeNode.of(1, 3, null, 5, 3), 2),
        () -> test(TreeNode.of(1, 3, 2, 5), 2)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.widthOfBinaryTree(given);

    // then
    assertEquals(expected, actual);
  }
}
```
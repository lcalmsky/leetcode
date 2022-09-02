> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/average_of_levels_in_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/average-of-levels-in-binary-tree/) 있습니다.

## Problem

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.


**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/09/avg1-tree.jpg)
```text
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/09/avg2-tree.jpg)
```text
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* -2^31 <= Node.val <= 2^31 - 1

## Solution

이진 트리의 루트 노드가 주어질 때 트리의 각 레벨의 노드들의 평균을 구하는 문제입니다.

```java
import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(sum / size);
    }
    return result;
  }
}

```

queue를 사용하여 BFS 알고리즘을 구현하면 간단히 해결할 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.average_of_levels_in_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNonEmptyBinaryTree_whenFindAverageOfLevelsInTheTree_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), Arrays.asList(3d, 14.5d, 11d))
    );
  }

  private void test(TreeNode given, List<Double> expected) {
    // when
    Solution averageOfLevelsInBinaryTree = new Solution();
    List<Double> actual = averageOfLevelsInBinaryTree.averageOfLevels(given);

    // then
    assertEquals(expected, actual);
  }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/recover_binary_search_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/recover-binary-search-tree/) 있습니다.

## Problem

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

**Example 1:**

```text
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
```

**Example 2:**

```text
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
```

**Constraints:**

* The number of nodes in the tree is in the range [2, 1000].
* -23^1 <= Node.val <= 23^1 - 1


**Follow up:** A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?

## Solution

정확히 두 노드만 swap 되어있는 이진 탐색 트리가 주어질 때 구조를 바꾸지 않고 트리를 정상적으로 돌려놓는 문제입니다.

인라인 주석으로 설명을 추가하였습니다.

```java
import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private TreeNode first;
  private TreeNode second;
  private TreeNode pre;

  public void recoverTree(TreeNode root) {
    if (root == null) { // 현재 node가 null이면 아무 것도 하지 않습니다.
      return;
    }
    inorder(root); // 현재 노드를 inorder traversal로 탐색하며 검사합니다.
    if (second != null && first != null) { // swap 해야 할 두 노드를 발견했다면 swap해 줍니다.
      int val = second.val;
      second.val = first.val;
      first.val = val;
    }
  }

  private void inorder(TreeNode root) {
    if (root == null) { // 현재 노드가 null이면 아무 것도 하지 않습니다.
      return;
    }
    inorder(root.left); // 왼쪽 노드를 먼저 검사합니다.
    if (pre != null) { // 이전 노드가 존재하고
      if (root.val < pre.val) { // 현재 노드가 이전 노드보다 작고
        if (first == null) { // 첫 번째 노드를 아직 발견하지 못했다면
          first = pre; // 이전 노드가 swap 해야 할 첫 번째 노드가 됩니다.
        }
        second = root; // 현재 노드를 swap 해야 할 두 번째 노드로 대체합니다. 
      }
    }
    pre = root; // 이전 노드를 현재 노드로 대체합니다.
    inorder(root.right); // 오른쪽 노드를 나중에 검사합니다.
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.recover_binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSwappedTree_whenRecover_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, 3, null, null, 2), TreeNode.of(3, 1, null, null, 2)),
        () -> test(TreeNode.of(3, 1, 4, null, null, 2), TreeNode.of(2, 1, 4, null, null, 3))
    );
  }

  private void test(TreeNode given, TreeNode expected) {
    // when
    Solution solution = new Solution();
    solution.recoverTree(given);
    // then
    assertEquals(expected, given);
  }
}
```

<details>
<summary>TreeNode.java 전체 보기</summary>

```java
package io.lcalmsky.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public static TreeNode of(Integer... array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException();
    }

    Queue<TreeNode> treeNodeQueue = new LinkedList<>();
    Queue<Integer> integerQueue = new LinkedList<>();
    for (int i = 1; i < array.length; i++) {
      integerQueue.offer(array[i]);
    }

    TreeNode treeNode = new TreeNode(array[0]);
    treeNodeQueue.offer(treeNode);

    while (!integerQueue.isEmpty()) {
      Integer leftVal = integerQueue.poll();
      Integer rightVal = integerQueue.isEmpty() ? null : integerQueue.poll();
      TreeNode current = treeNodeQueue.poll();
      if (leftVal != null) {
        TreeNode left = new TreeNode(leftVal);
        assert current != null;
        current.left = left;
        treeNodeQueue.offer(left);
      }
      if (rightVal != null) {
        TreeNode right = new TreeNode(rightVal);
        assert current != null;
        current.right = right;
        treeNodeQueue.offer(right);
      }
    }
    return treeNode;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
        .add("val=" + val)
        .add("left=" + left)
        .add("right=" + right)
        .toString();
  }

  public static void print(TreeNode treeNode) {
    BTreePrinter.printNode(treeNode);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeNode)) {
      return false;
    }
    TreeNode treeNode = (TreeNode) o;
    return val == treeNode.val &&
        Objects.equals(left, treeNode.left) &&
        Objects.equals(right, treeNode.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }

  static class BTreePrinter {

    public static void printNode(TreeNode root) {
      int maxLevel = BTreePrinter.maxLevel(root);
      printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
      if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes)) {
        return;
      }
      int floor = maxLevel - level;
      int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
      int firstSpaces = (int) Math.pow(2, (floor)) - 1;
      int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
      BTreePrinter.printWhitespaces(firstSpaces);
      List<TreeNode> newNodes = new ArrayList<>();
      for (TreeNode node : nodes) {
        if (node != null) {
          System.out.print(node.val);
          newNodes.add(node.left);
          newNodes.add(node.right);
        } else {
          newNodes.add(null);
          newNodes.add(null);
          System.out.print(" ");
        }
        BTreePrinter.printWhitespaces(betweenSpaces);
      }
      System.out.println();

      for (int i = 1; i <= edgeLines; i++) {
        for (TreeNode node : nodes) {
          BTreePrinter.printWhitespaces(firstSpaces - i);
          if (node == null) {
            BTreePrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
            continue;
          }
          if (node.left != null) {
            System.out.print("/");
          } else {
            BTreePrinter.printWhitespaces(1);
          }
          BTreePrinter.printWhitespaces(i + i - 1);
          if (node.right != null) {
            System.out.print("\\");
          } else {
            BTreePrinter.printWhitespaces(1);
          }
          BTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
        }
        System.out.println();
      }
      printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
      for (int i = 0; i < count; i++) {
        System.out.print(" ");
      }
    }

    private static int maxLevel(TreeNode node) {
      if (node == null) {
        return 0;
      }
      return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
      for (Object object : list) {
        if (object != null) {
          return false;
        }
      }
      return true;
    }
  }
}

```

</details>
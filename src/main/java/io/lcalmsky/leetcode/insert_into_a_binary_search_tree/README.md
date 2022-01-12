> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/insert_into_a_binary_search_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/insert-into-a-binary-search-tree/) 있습니다.

## Problem

You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/05/insertbst.jpg)

```text
Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:
```

![](https://assets.leetcode.com/uploads/2020/10/05/bst.jpg)

**Example 2:**

```text
Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
```

**Example 3:**

```text
Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
```

**Constraints:**

* The number of nodes in the tree will be in the range [0, 10^4].
* -10^8 <= Node.val <= 10^8
* All the values Node.val are unique.
* -10^8 <= val <= 10^8
* It's guaranteed that val does not exist in the original BST.

## Solution

BST와 특정 값이 주어질 때 특정 값을 BST에 추가한 뒤 root 노드를 반환하는 문제입니다.

```java
public class Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) { // (1)
      return new TreeNode(val);
    }
    traverse(root, val);
    return root;
  }

  private void traverse(TreeNode node, int val) {
    if (node == null) {
      return;
    }
    if (val > node.val) { // (2) 
      if (node.right == null) {
        node.right = new TreeNode(val);
        return;
      }
      traverse(node.right, val);
    } else { // (3)
      if (node.left == null) {
        node.left = new TreeNode(val);
        return;
      }
      traverse(node.left, val);
    }
  }
}
```

1. root 노드가 null이면 새로운 노드를 생성해 반환합니다.
2. 현재 노드의 값보다 추가할 값이 더 클 때, 현재 노드의 right 노드로 추가해야 합니다. right 노드가 null이면 추가한 뒤 종료하고, 그렇지 않을 땐 right 노드를 기준으로 다시 같은 과정을 진행합니다.
3. 현재 노드의 값보다 추가할 값이 더 작을 때, 현재 노드의 left 노드로 추가해야 합니다. left 노드가 null이면 추가한 뒤 종료하고, 그렇지 않을 땐 left 노드를 기준으로 다시 같은 과정을 진행합니다.

## Test

```java
package io.lcalmsky.leetcode.insert_into_a_binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenBinarySearchTree_whenInsertTreeNode_thenCorrect() {
    assertAll(
        () -> test(null, 5, TreeNode.of(5)),
        () -> test(TreeNode.of(4, 2, 7, 1, 3), 5, TreeNode.of(4, 2, 7, 1, 3, 5)),
        () -> test(TreeNode.of(40, 20, 60, 10, 30, 50, 70), 25,
            TreeNode.of(40, 20, 60, 10, 30, 50, 70, null, null, 25)),
        () -> test(TreeNode.of(4, 2, 7, 1, 3, null, null, null, null, null, null), 5,
            TreeNode.of(4, 2, 7, 1, 3, 5))
    );
  }

  private void test(TreeNode root, int k, TreeNode expected) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.insertIntoBST(root, k);

    // then
    assertEquals(expected, actual);
  }
}
```

<details>
<summary>풀이에 사용된 TreeNode.java 클래스 보기</summary>

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
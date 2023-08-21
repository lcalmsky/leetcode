> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/flatten_binary_tree_to_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) 있습니다.

## Problem

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg)

```text
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
```

**Example 2:**

```text
Input: root = []
Output: []
```

**Example 3:**

```text
Input: root = [0]
Output: [0]
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 2000].
* -100 <= Node.val <= 100

**Follow up:** Can you flatten the tree in-place (with O(1) extra space)?

## Solution

이진 트리를 펼쳐서 연결 리스트로 만드는 문제입니다.

```java
package io.lcalmsky.leetcode.flatten_binary_tree_to_linked_list;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    private TreeNode head = null;

    public void flatten(TreeNode root) {
        if (root != null) {
            reversePreOrder(root);
        }
    }

    private void reversePreOrder(TreeNode node) {
        if (node.right != null) { // 오른쪽 서브 트리를 먼저 탐색합니다.
            reversePreOrder(node.right);
        }
        if (node.left != null) { // 오른쪽 서브트리 탐색이 끝나면 왼쪽 서브 트리를 탐색합니다.
            reversePreOrder(node.left);
        }
        node.left = null; // 현재 노드의 왼쪽 자식을 null로 설정해 이진트리에서 연결을 끊습니다.
        node.right = head; // 현재 노드의 오른쪽 자식을 head로 설정합니다. head는 이전 단계의 연결 리스트 시작을 나타내는 변수입니다.
        head = node; // 현재 노드로 업데이트 합니다. 현재 노드가 연결 리스트의 시작 부분이 되고, 다음 노드는 현재 노드의 오른쪽 자식이 됩니다.
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.flatten_binary_tree_to_linked_list;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test(
                        TreeNode.of(1, 2, 5, 3, 4, null, 6),
                        TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6)
                )
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        Solution solution = new Solution();
        solution.flatten(given);

        // then
        assertEquals(expected, given);
    }
}

```

<details>
<summary>TreeNode 펼처보기</summary>

```java
package io.lcalmsky.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;

public class TreeNode implements Cloneable{

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

  @Override
  public TreeNode clone() {
    try {
      return (TreeNode) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
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
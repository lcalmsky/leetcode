> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/binary_tree_right_side_view/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/binary-tree-right-side-view/) 있습니다.

## Problem

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/14/tree.jpg)

```text
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
```

**Example 2:**
```text
Input: root = [1,null,3]
Output: [1,3]
```

**Example 3:**
```text
Input: root = []
Output: []
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 100].
* -100 <= Node.val <= 100

## Solution

이진 트리의 root가 주어질 때 오른쪽에서 트리를 바라봤을 때 트리의 모습을 순서대로 배열로 반환하는 문제입니다.

트리의 level(depth)을 구하는 문제와 매우 유사합니다.

먼저 추가한 것이 먼저 나오는 특징을 가진 자료구조인 큐를 이용하여 현재 동일 레벨의 노드를 추가한 뒤, 순차적으로 제거하면서 해당 노드의 값을 결과 리스트에 추가해주는 방식으로 풀이할 수 있습니다.

이 때 유의할 점은 오른쪽에서 본 모습이어야하기 때문에 노드의 오른쪽 노드가 우선적으로 추가되어야 먼저 큐에서 제거되면서 결과 리스트에 추가될 수 있습니다.

```java
package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.remove(); // 큐에서 제거하고
                if (i == 0) { // 현재 레벨의 첫 번째 노드의 값만 추가함
                    values.add(node.val);
                }
                if (node.right != null) { // 오른쪽 노드를 우선적으로 큐에 추가함
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return values;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, null, 5, null, 4), List.of(1, 3, 4)),
                () -> test(TreeNode.of(1, null, 3), List.of(1, 3)),
                () -> test(null, List.of())
        );
    }

    private void test(TreeNode root, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);
        // then
        assertEquals(expected, actual);
    }
}
```

<details>
<summary>TreeNode.java</summary>

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
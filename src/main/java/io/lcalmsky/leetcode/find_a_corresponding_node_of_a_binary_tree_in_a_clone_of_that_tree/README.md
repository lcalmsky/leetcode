> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/) 있습니다.

## Problem

Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/02/21/e1.png)

```text
Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/02/21/e2.png)

```text
Input: tree = [7], target =  7
Output: 7
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2020/02/21/e3.png)

```text
Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* The values of the nodes of the tree are unique.
* target node is a node from the original tree and is not null.

**Follow up:** Could you solve the problem if repeated values on the tree are allowed?

## Solution

두 개의 이진 트리가 주어지는데 하나는 원본 하나는 복사본입니다. 그리고 원본의 노드 중 하나의 레퍼런스가 target으로 주어질 때 복사본의 동일한 노드를 반환하는 문제입니다.

풀이 자체는 너무 간단한데 왜 `Medium` 난이도인지 모르겠습니다. 나름 함정을 주려고 했던 거 같은데 단순하게 생각해도 간단히 풀이할 수 있습니다.

저는 DFS를 이용해 inorder traversal로 동일한 노드를 찾았을 때 복사본의 노드를 반환하는 방식으로 풀었습니다.

```java
package io.lcalmsky.leetcode.find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private TreeNode result;

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {
    inorder(original, cloned, target);
    return result;
  }

  private void inorder(TreeNode original, TreeNode cloned, TreeNode target) {
    if (original == null) {
      return;
    }
    inorder(original.left, cloned.left, target);
    if (original == target) {
      result = cloned;
      return;
    }
    inorder(original.right, cloned.right, target);
  }
}

```

## Test

테스트를 위해선 우선 기존 `TreeNode` 클래스에 `Clonable`을 구현해야 합니다.

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
  // 생략
  @Override
  public TreeNode clone() {
    try {
      return (TreeNode) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
```

아주 간단하게 IDE에서 제공하는 메서드로 구현하였습니다.

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

테스트 코드에서 `target` 노드는 레퍼런스로 전달해야 하기 때문에 `original` 노드에서 `target` 노드까지 직접 이동하여 전달하였습니다.

```java
package io.lcalmsky.leetcode.find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import static org.junit.jupiter.api.Assertions.*;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> {
          TreeNode original = TreeNode.of(7, 4, 3, null, null, 6, 19);
          TreeNode cloned = original.clone();
          TreeNode target = original.right;
          test(original, cloned, target);
        },
        () -> {
          TreeNode original = TreeNode.of(7);
          TreeNode cloned = original.clone();
          TreeNode target = original;
          test(original, cloned, target);
        },
        () -> {
          TreeNode original = TreeNode.of(8,null,6,null,5,null,4,null,3,null,2,null,1);
          TreeNode cloned = original.clone();
          TreeNode target = original.right.right.right;
          test(original, cloned, target);
        }
    );
  }

  private void test(TreeNode original, TreeNode cloned, TreeNode target) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.getTargetCopy(original, cloned, target);
    // solution
    assertEquals(target, actual);
  }

}
```
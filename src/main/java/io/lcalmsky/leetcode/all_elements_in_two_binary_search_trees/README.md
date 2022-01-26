> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/all_elements_in_two_binary_search_trees/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/all-elements-in-two-binary-search-trees/) 있습니다.

## Problem

Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/12/18/q2-e1.png)

```text
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2019/12/18/q2-e5-.png)

```text
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
```

**Constraints:**

* The number of nodes in each tree is in the range [0, 5000].
* -10^5 <= Node.val <= 10^5

## Solution

두 개의 이진트리의 루트노드가 주어질 때 두 트리의 모든 노드를 오름차순으로 정렬해 반환하는 문제입니다.

간단하게 생각하면 두 트리를 모두 탐색하면서 리스트에 넣고 마지막에 리스트를 정렬해서 반환하면 되는데요, 그래서 그런지 Medium 난이도 문제이지만 정답률이 매우 높습니다.

```java
import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> result = new ArrayList<>();
    travel(result, root1); // (1)
    travel(result, root2); // (2)
    Collections.sort(result); // (3)
    return result;
  }

  private void travel(List<Integer> result, TreeNode node) {
    if (node == null) {
      return;
    }
    result.add(node.val);
    travel(result, node.left);
    travel(result, node.right);
  }
}
```

1. 첫 번째 이진트리를 탐색하면서 노드의 값을 리스트에 추가합니다.
2. 두 번째 이진트리를 탐색하면서 노드의 값을 리스트에 추가합니다.
3. 오름차순으로 정렳합니다.

---

이렇게 제출하면 당연히 문제 의도에 맞지 않을 거라고 생각했는데 의외로 좋은 성적으로 통과가 되네요. 😅

#₩ Test

```java
package io.lcalmsky.leetcode.all_elements_in_two_binary_search_trees;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(2, 1, 4), TreeNode.of(1, 0, 3), List.of(0, 1, 1, 2, 3, 4)),
        () -> test(TreeNode.of(1, null, 8), TreeNode.of(8, 1), List.of(1, 1, 8, 8))
    );
  }

  private void test(TreeNode root1, TreeNode root2, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.getAllElements(root1, root2);
    // then
    assertEquals(expected, actual);
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

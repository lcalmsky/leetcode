> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/range_sum_of_bst/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/range-sum-of-bst/) 있습니다.

## Problem

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg)

```text
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg)

```text
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
```

**Constraints:**

The number of nodes in the tree is in the range [1, 2 * 104].
* 1 <= Node.val <= 10^5
* 1 <= low <= high <= 10^5
All Node.val are unique.

## Solution

이진 트리의 루트 노드와 두 정수가 주어졌을 때 두 정수를 포함한 범위 내에 해당하는 노드의 값들을 더해 반환하는 문제입니다.

풀이가 간단하여 바로 소스 코드부터 확인하겠습니다.

```java
package io.lcalmsky.leetcode.range_sum_of_bst;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) { // (1)
      return 0;
    }
    if (root.val < low) { // (2)
      return rangeSumBST(root.right, low, high);
    }
    if (root.val > high) { // (3)
      return rangeSumBST(root.left, low, high);
    }
    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high); // (4)
  }
}
```

1. 현재 노드가 null일 때 0을 반환합니다.
2. 현재 노드가 low보다 낮은 값일 때 현재 노드의 right 노드를 탐색해 결과를 반환합니다.
3. 현재 노드가 right보다 높은 값일 때 현재 노드의 left 노드를 탐색해 결과를 반환합니다.
4. 현재 노드가 low와 right를 포함하는 사이 값일 때 현재 노드와 left, right 노드를 탐색한 결과를 더해 결과를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.range_sum_of_bst;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(10, 5, 15, 3, 7, null, 18), 7, 15, 32),
        () -> test(TreeNode.of(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10, 23)
    );
  }

  private void test(TreeNode root, int low, int high, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.rangeSumBST(root, low, high);
    // then
    assertEquals(expected, actual);
  }
}
```

---

<details>
<summary>테스트에 사용된 TreeNode.java 전체 보기</summary>

```java
package io.lcalmsky.leetcode;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode of(Integer... array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        for (int i = 1; i < array.length; i++) integerQueue.offer(array[i]);

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
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
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
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

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

                    if (node.left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (node.right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
                }

                System.out.println();
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static int maxLevel(TreeNode node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }
}
```

</details>
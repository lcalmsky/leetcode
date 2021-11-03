> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/sum_root_to_leaft_numbers/Solution.java) 있습니다.
> 문제는 [여기](https://leetcode.com/problems/https://leetcode.com/problems/sum-root-to-leaf-numbers/) 있습니다.

## Problem

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg)

```text
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg)

```text
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 1000].
* 0 <= Node.val <= 9
* The depth of the tree will not exceed 10.

## Solution

0~9로 이루어져있는 이진트리의 루트노드에서 리프노드까지를 하나의 숫자로 구성할 때 모든 구성 가능한 숫자의 합을 구하는 문제입니다.

루트에서 리프노드까지 탐색한 뒤 마지막 리프노드를 제거하고 다음 리프노드를 추가하는 식으로 백트래킹을 이용해 풀 수 있습니다.

```java
package io.lcalmsky.leetcode.sum_root_to_leaf_numbers;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<TreeNode>> lists = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        getRootToLeafNodes(lists, treeNodes, root);
        return lists.stream() // (4)
            .map(tnl -> tnl.stream()
                .map(tn -> tn.val)
                .map(String::valueOf)
                .collect(Collectors.joining()))
            .map(Integer::valueOf)
            .reduce(Integer::sum)
            .orElse(0);
    }

    private void getRootToLeafNodes(
        List<List<TreeNode>> lists, List<TreeNode> treeNodes, TreeNode node) {
        if (node.left == null && node.right == null) { // (1)
            lists.add(new ArrayList<>(treeNodes));
        }
        if (node.left != null) { // (2)
            treeNodes.add(node.left);
            getRootToLeafNodes(lists, treeNodes, node.left);
            treeNodes.remove(treeNodes.size() - 1);
        }
        if (node.right != null) { // (3)
            treeNodes.add(node.right);
            getRootToLeafNodes(lists, treeNodes, node.right);
            treeNodes.remove(treeNodes.size() - 1);
        }
    }
}
```

1. 재귀 호출의 escape case로 현재 노드가 리프노드일 때 추가한 노드의 리스트를 전체 리스트에 추가해 반환합니다.
2. 현재 노드의 left 노드를 추가하고 재귀호출을 합니다. 끝나면 마지막에 추가한 노드를 리스트에서 제거합니다.
3. 현재 노드의 right 노드를 추가하고 재귀호출을 합니다. 끝나면 마지막에 추가한 노드를 리스트에서 제거합니다.
4. 중첩 리스트에서 안쪽에 리스트를 문자열로 바꾼 뒤 다시 숫자로 바꿔 전체 합을 구해 반환합니다.

---

제출하고 보니 훨씬 더 간단한 답을 발견해서 소개합니다.

기존 값에 10배씩 곱해 앞 자리 수가 되도록 해주고 현재 노드의 value 값을 더해주면서 leaf 노드가 될 때까지 탐색하는 방법입니다.

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode node, int value, int sum) {
        if (node == null) {
            return 0;
        }
        value = value * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += value;
            return sum;
        }
        return dfs(node.left, value, sum) + dfs(node.right, value, sum);
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.sum_root_to_leaf_numbers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void givenTreeNode_whenSumRootToLeaf_thenCorrect() {
        assertAll(
            () -> test(TreeNode.of(1, 2, 3), 25),
            () -> test(TreeNode.of(4, 9, 0, 5, 1), 1026)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution sumRootToLeafNumbers = new Solution();
        int actual = sumRootToLeafNumbers.sumNumbers(given);

        // then
        assertEquals(expected, actual);
    }
}
```
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/binary_tree_zigzag=level_order_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/binary-tree-zigzag=level-order-traversal/) 있습니다.

## Problem

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)

```text
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
```

**Example 2:**

```text
Input: root = [1]
Output: [[1]]
```

**Example 3:**

```text
Input: root = []
Output: []
```

**Constraints:**

* The number of nodes in the tree is in the range [0, 2000].
* -100 <= Node.val <= 100

## Solution

이진 트리의 루트 노드를 입력받아 "지그재그" 형태로 레벨 순서대로 노드 값을 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.binary_tree_zigzag_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> orders = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> order;
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            order = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.remove();
                if (level % 2 == 1) {
                    order.add(poll.val);
                } else {
                    order.add(0, poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            orders.add(order);
            level++;
        }
        return orders;
    }
}

```

주어진 이진 트리를 레벨 순서대로 탐색하기 위해 큐(Queue)를 사용합니다. 큐는 BFS(Breadth-First Search) 알고리즘을 구현하기 위해 활용됩니다.

먼저, 주어진 루트 노드가 null인 경우, 빈 리스트를 반환합니다.

그렇지 않은 경우, 결과를 저장할 리스트인 orders와 노드를 저장할 큐인 queue를 생성합니다. 또한, 현재 레벨의 순서에 따라 노드 값을 저장할 리스트인 order를 초기화합니다. 루트 노드를 큐에 추가한 후, 레벨을 나타내는 변수 level을 1로 초기화합니다.

큐가 비어 있지 않은 동안 반복합니다.

1. order 리스트를 초기화합니다.
1. 큐의 현재 크기를 저장한 후, 해당 크기만큼 반복하면서 큐에서 노드를 하나씩 제거합니다.
1. 현재 레벨이 홀수인 경우, 노드 값을 order 리스트에 추가합니다.
1. 현재 레벨이 짝수인 경우, 노드 값을 order 리스트의 맨 앞에 추가합니다.
1. 현재 노드의 왼쪽 자식이 존재하는 경우, 왼쪽 자식을 큐에 추가합니다.
1. 현재 노드의 오른쪽 자식이 존재하는 경우, 오른쪽 자식을 큐에 추가합니다.
1. 현재 레벨의 order 리스트를 orders 리스트에 추가합니다.
1. 다음 레벨로 넘어가기 위해 level을 증가시킵니다.

모든 반복이 완료되면 orders 리스트를 반환합니다.

이 알고리즘은 BFS를 통해 이진 트리를 레벨 순서대로 탐색하며, 각 레벨에 대해 지그재그 형태로 노드 값을 저장합니다.

## Test

```java
package io.lcalmsky.leetcode.binary_tree_zigzag_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), List.of(List.of(3), List.of(20, 9), List.of(15, 7))),
                () -> test(TreeNode.of(1), List.of(List.of(1)))
        );
    }

    private void test(TreeNode root, List<List<Integer>> expected) {
        // when
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.zigzagLevelOrder(root);
        // then
        assertEquals(expected, actual);
    }
}
```
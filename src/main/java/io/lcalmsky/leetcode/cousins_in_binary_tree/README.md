> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/cousins_in_binary_tree/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/cousins-in-binary-tree/) 있습니다.

## Problem

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return
true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/02/12/q1248-01.png)

```text
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2019/02/12/q1248-02.png)

```text
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2019/02/13/q1248-03.png)

```text
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
```

**Constraints:**

* The number of nodes in the tree is in the range [2, 100].
* 1 <= Node.val <= 100
* Each node has a unique value.
* x != y
* x and y are exist in the tree.

## Solution

이진 트리가 주어졌을 때 사로 사촌 노드인지 판단하는 문제입니다.

부모가 다르고 깊이가 같으면 사촌(cousins) 노드입니다.

깊이(depth)와 부모노드의 값을 저장해 마지막에 비교하는 방식으로 풀어보았습니다.

```java
import io.lcalmsky.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        dfs(depthMap, parentMap, root, null, 1); // (1)
        return depthMap.get(x).equals(depthMap.get(y)) && // (6)
                !parentMap.get(x).equals(parentMap.get(y));
    }

    private void dfs(Map<Integer, Integer> depthMap, Map<Integer, Integer> parentMap,
                     TreeNode currentNode, TreeNode parentNode, int depth) {
        if (currentNode == null) { // (2)
            return;
        }
        depthMap.put(currentNode.val, depth); // (3)
        parentMap.put(currentNode.val, parentNode == null ? null : parentNode.val); // (4)
        dfs(depthMap, parentMap, currentNode.left, currentNode, depth + 1); // (5)
        dfs(depthMap, parentMap, currentNode.right, currentNode, depth + 1); // (5)
    }
}
```

1. 모든 노드를 다 탐색할 것이기 때문에 dfs 알고리즘을 사용했습니다.
2. 현재 전달된 노드가 null이면 아무것도 하지 않습니다.
3. 현재 노드의 값과 깊이를 저장합니다.
4. 현재 노드의 값과 부모 노드의 값을 저장합니다.
5. 왼쪽, 오른쪽 노드에 대해 동일한 과정을 반복합니다.
6. 깊이를 저장한 맵에서 x, y 값을 비교하고, 부모 노드의 값을 저장한 맵에서 x, y의 값을 비교합니다. 이 때 부모 노드의 값은 서로 달라야 사촌입니다.

## Test

```java
package io.lcalmsky.leetcode.cousins_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void givenBinaryTreeAndTwoIntegers_whenFindThemCousins_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4), 4, 3, false),
                () -> test(TreeNode.of(1, 2, 3, null, 4, null, 5), 5, 4, true),
                () -> test(TreeNode.of(1, 2, 3, null, 4), 2, 3, false)
        );
    }

    private void test(TreeNode node, int x, int y, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.isCousins(node, x, y);
        // then
        assertEquals(expected, actual);
    }
}
```

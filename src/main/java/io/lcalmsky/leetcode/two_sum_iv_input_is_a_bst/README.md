> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/two_sum_iv_input_is_a_bst/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/) 있습니다.

## Problem

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/21/sum_tree_1.jpg)

```text
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/09/21/sum_tree_2.jpg)

```text
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
```

**Example 3:**

```text
Input: root = [2,1,3], k = 4
Output: true
```

**Example 4:**

```text
Input: root = [2,1,3], k = 1
Output: false
```

**Example 5:**

```text
Input: root = [2,1,3], k = 3
Output: true
```

**Constraints:**

* The number of nodes in the tree is in the range [1, 10^4].
* -10^4 <= Node.val <= 10^4
* root is guaranteed to be a valid binary search tree.
* -10^5 <= k <= 10^5

## Solution

BST (Binary Search Tree)가 주어지고 K라는 수가 주어졌을 때 BST 내 두 수의 합이 K가 되는지 확인하는 간단한 문제입니다.

트리 문제이므로 재귀 호출을 사용하여 풀 수 있는데 종료 조건은 다음과 같습니다.

> (1) 현재 노드가 null이면 false 반환  
> (2) K에서 현재 노드의 값을 뺀 값이 현재까지 탐색한 노드 중 존재하면 true 반환  

위의 두 조건을 충족시킬 때까지 `inorder traversal`을 이용해 트리를 탐색하면서 `Set`에 노드의 값을 추가해줍니다.

`inorder traversal`를 구현하기 위해선 `(3)left node 탐색을 위한 재귀 호출` - `(4)타겟 노드에 도달했을 때 비즈니스 로직 구현` - `(5)right node 탐색을 위한 재귀 호출` 순으로 구현하면 됩니다.

```java
public class Solution {
    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) { // (1) 조건
            return false;
        }
        if (findTarget(root.left, k)) { // (3)
            return true;
        }
        if (set.contains(k - root.val)) { // (2) 조건
            return true;
        }
        set.add(root.val); // (4)
        return findTarget(root.right, k); // (5)
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.two_sum_iv_input_is_a_bst;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenBinaryTree_whenFindTwoSum_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 3, 6, 2, 4, 7), 9, true),
                () -> test(TreeNode.of(5, 3, 6, 2, 4, 7), 28, false)
        );
    }

    private void test(TreeNode given, int k, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.findTarget(given, k);

        // then
        assertEquals(expected, actual);
    }
}
```

> `TreeNode` 클래스 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/TreeNode.java) 있습니다.
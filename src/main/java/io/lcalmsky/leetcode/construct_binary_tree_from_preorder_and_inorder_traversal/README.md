> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/construct_binary_tree_from_preorder_and_inorder_traversal/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) 있습니다.

## Problem

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/tree.jpg)

```text
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```

**Example 2:**

```text
Input: preorder = [-1], inorder = [-1]
Output: [-1]
```

**Constraints:**

* 1 <= preorder.length <= 3000
* inorder.length == preorder.length
* -3000 <= preorder[i], inorder[i] <= 3000
* preorder and inorder consist of unique values.
* Each value of inorder also appears in preorder.
* preorder is guaranteed to be the preorder traversal of the tree.
* inorder is guaranteed to be the inorder traversal of the tree.

## Solution

주어진 preorder와 inorder 배열은 이진 트리의 전위 순회(preorder traversal)와 중위 순회(inorder traversal)입니다. 이 두 순회 결과를 기반으로 이진 트리를 구성하고 반환하는 문제입니다. 

```java
package io.lcalmsky.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pStart = 0, pEnd = preorder.length - 1, iStart = 0, iEnd = inorder.length - 1;
        return construct(preorder, inorder, pStart, pEnd, iStart, iEnd);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int value = preorder[pStart];
        TreeNode node = new TreeNode(value);
        int parentIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                parentIndex = i;
                break;
            }
        }
        node.left = construct(preorder, inorder, pStart + 1, pStart + parentIndex - iStart, iStart, parentIndex - 1);
        node.right = construct(preorder, inorder, pStart + parentIndex - iStart + 1, pEnd, parentIndex + 1, iEnd);
        return node;
    }
}

```

`buildTree()` 메서드는 전체 이진 트리를 구성하는데 사용됩니다. `construct()` 메서드는 재귀적으로 이진 트리의 각 서브트리를 구성하는 역할을 수행합니다.

`construct()` 메서드에서는 다음과 같은 작업을 수행합니다:

1. 베이스 케이스: 만약 `pStart` > `pEnd`이거나 `iStart` > `iEnd`인 경우, 즉 유효한 구간이 아니면 `null`을 반환하여 빈 서브트리를 표현합니다.
2. `preorder[pStart]` 값을 가져와서 새로운 `TreeNode` 객체를 생성합니다. 이 값은 현재 서브트리의 루트 노드의 값입니다.
3. `preorder[pStart]` 값을 `inorder` 배열에서 찾아서 해당 값의 인덱스를 `parentIndex` 변수에 저장합니다. 이 인덱스는 현재 서브트리의 루트 노드의 중위 순회에서의 위치를 나타냅니다.
4. 현재 노드의 왼쪽 서브트리를 재귀적으로 구성하기 위해 `construct()` 메서드를 호출합니다. 전위 순회에서는 `pStart` + 1부터 `pStart` + `parentIndex` - `iStart`까지의 범위가 해당 왼쪽 서브트리에 해당합니다. 중위 순회에서는 `iStart`부터 `parentIndex` - 1까지의 범위가 해당 왼쪽 서브트리에 해당합니다. 이 범위는 현재 노드 다음에 나오는 요소들이 현재 노드의 왼쪽 서브트리에 속한다는 것을 의미합니다.
5. 현재 노드의 오른쪽 서브트리를 재귀적으로 구성하기 위해 `construct()` 메서드를 호출합니다. 전위 순회에서는 `pStart` + `parentIndex` - `iStart` + 1부터 `pEnd`까지의 범위가 해당 오른쪽 서브트리에 해당합니다. 중위 순회에서는 `parentIndex` + 1부터 `iEnd`까지의 범위가 해당 오른쪽 서브트리에 해당합니다. 이 범위는 현재 노드 다음에 나오는 요소들이 현재 노드의 오른쪽 서브트리에 속한다는 것을 의미합니다.
6. 현재 노드의 왼쪽 서브트리와 오른쪽 서브트리를 설정하고, 구성된 노드를 반환합니다.

이렇게 재귀적으로 서브트리를 구성하면 전체 이진 트리가 구성되며, 최종적으로 루트 노드를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}, TreeNode.of(3, 9, 20, null, null, 15, 7)),
                () -> test(new int[]{-1}, new int[]{-1}, TreeNode.of(-1))
        );
    }

    private void test(int[] preorder, int[] inorder, TreeNode expected) {
        // when
        Solution solution = new Solution();
        TreeNode actual = solution.buildTree(preorder, inorder);
        // then
        assertEquals(expected, actual);
    }
}
```
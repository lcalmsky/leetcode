## Problem

One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's
value. If it is a null node, we record using a sentinel value such as '#'.

![](https://assets.leetcode.com/uploads/2021/03/12/pre-tree.jpg)

For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a
null node.

Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid.

For example, it could never contain two consecutive commas, such as "1,,3".

**Note**: You are not allowed to reconstruct the tree.

**Example 1:**
```text
Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
```

**Example 2:**
```text
Input: preorder = "1,#"
Output: false
```

**Example 3:**
```text
Input: preorder = "9,#,#,1"
Output: false
```

**Constraints:**

* 1 <= preorder.length <= 10^4
* preorder consist of integers in the range [0, 100] and '#' separated by commas ','.

## Solution

이진 트리를 `preorder`로 탐색하면서 노드의 값을 `serialize`한 문자열이 주어지는데, 이 문자열이 유효한지 확인하는 문제입니다.

노드가 없을 경우 `#`이 추가됩니다.

문자열을 다시 트리로 `deserialize` 하는 것은 허용되지 않는다고 나와있습니다.

`preorder`로 탐색한다는 것은 루트 노드부터 `자기 자신 노드` - `왼쪽 자식 노드` - `오른쪽 자식 노드` 순으로 탐색한다는 것을 의미합니다.

따라서 마지막 자식 노드의 오른쪽 자식 노드가 마지막이 되고 이 때 그 노드는 반드시 null 이므로 `#`으로 끝나야 합니다.

마지막으로 탐색한 노드를 검사하면서 하나씩 제외하는 방식으로 코딩하기 위해 `Stack` 자료구조를 사용했습니다.

```java
package io.lcalmsky.leetcode.verify_preorder_serialization_of_a_binary_tree;

import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] preorderArray = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : preorderArray) {
            if (stack.isEmpty() || !node.equals("#")) { // (1)
                stack.push(node);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().equals("#")) { // (2)
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
            stack.push(node); // (3)
        }
        return stack.size() == 1 && stack.peek().equals("#"); // (4)
    }
}
```

> (1) `#` 노드를 만날 때까지 `Stack`에 `push` 합니다.  
> (2) `Stack`이 비어있지 않고 `top` 엘리먼트가 `#` 노드일 때 `pop` 하여 `#` 노드를 제거하고 `Stack`이 비어있지 않은 경우 `pop`을 한 번 더 수행합니다. 이 때 제거되는 노드는 `#`의 부모(또는 부모의 부모 중 한 노드) 노드 입니다. 만약에 `Stack`이 비어있다면 부모 노드가 없다는 뜻이기 때문에 유효하지 않은 이진 트리로 `false`를 반환합니다.  
> (3) 노드를 `Stack`에 `push`합니다.  
> (4) `Stack`에 `#`노드 하나만 남아있는지 여부를 반환합니다.

`Example 1`을 대입해서 `Stack`의 엘리먼트를 확인해보면,

```text
[1] 9, 3, 4, # // (1), (3)  
9,3,4,#,#,1,#,#,2,#,6,#,#
      ^
[2] 9, 3, #  // (2), (3)  
9,3,4,#,#,1,#,#,2,#,6,#,#
        ^
[3] 9, 1 // (3)
9,3,4,#,#,1,#,#,2,#,6,#,#
          ^
[4] 2 // (2), (3)
9,3,4,#,#,1,#,#,2,#,6,#,#
                ^
[5] 2, # // (3)
9,3,4,#,#,1,#,#,2,#,6,#,#
                  ^
[6] 6 // (2), (3)
9,3,4,#,#,1,#,#,2,#,6,#,#
                    ^
[7] 6, # // (3)
9,3,4,#,#,1,#,#,2,#,6,#,#
                      ^
[8] # // (2), (3)
9,3,4,#,#,1,#,#,2,#,6,#,#
                        ^
```

이런 순서로 Stack의 엘리먼트가 제거되고 최종적으로는 `#`노드 하나만 남게 됩니다.

## Test

```java
package io.lcalmsky.leetcode.verify_preorder_serialization_of_a_binary_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPreorderSerializedString_whenCheckIsValid_thenCorrect() {
        assertAll(
                () -> test("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
                () -> test("1, #", false),
                () -> test("9, #, #, 1", false)
        );
    }

    private void test(String given, boolean expected) {
        // when
        Solution verifyPreorderSerializationOfABinaryTree = new Solution();
        boolean actual = verifyPreorderSerializationOfABinaryTree.isValidSerialization(given);

        // then
        assertEquals(expected, actual);
    }
}
```
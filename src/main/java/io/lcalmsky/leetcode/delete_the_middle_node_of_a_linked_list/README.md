> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/delete_the_middle_node_of_a_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/) 있습니다.

## Problem

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.


**Example 1:**

![](https://assets.leetcode.com/uploads/2021/11/16/eg1drawio.png)

```text
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/11/16/eg2drawio.png)

```text
Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2021/11/16/eg3drawio.png)

```text
Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
```

**Constraints:**

* The number of nodes in the list is in the range [1, 10^5].
* 1 <= Node.val <= 10^5

## Solution

연결 리스트에서 중간 노드를 삭제하는 문제입니다.

```java
package io.lcalmsky.leetcode.delete_the_middle_node_of_a_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev == slow) {
            return null;
        }
        if (slow != null) {
            prev.next = slow.next;
        }
        return head;
    }
}
```

1. prev, slow, fast라는 세 개의 노드 포인터를 생성합니다. 모두 초기값으로 head를 가리킵니다. 이 포인터들은 연결 리스트를 탐색하면서 중간 노드를 찾기 위해 사용됩니다.
1. while 루프를 통해 빠른 포인터 fast가 끝에 도달하거나 끝에서 두 번째 노드에 도달할 때까지, 빠른 포인터를 2 스텝씩 전진시키고 느린 포인터를 1 스텝씩 전진시킵니다. 이렇게 함으로써 빠른 포인터가 끝에 도달할 때, 느린 포인터는 중간에 도달하게 됩니다.
1. prev는 slow의 이전 노드를 가리키고 있게 됩니다. 이는 slow가 중간 노드를 가리키고 있을 때, 해당 노드를 삭제하기 위해 사용됩니다.
1. 중간 노드가 없는 경우, 즉 prev와 slow가 같은 경우 (연결 리스트의 노드 개수가 0 또는 1인 경우)에는 null을 반환합니다.
1. 그렇지 않은 경우, 중간 노드가 존재하며 해당 노드를 삭제합니다. prev.next를 slow.next로 변경함으로써 중간 노드를 건너뛰도록 설정합니다.
1. head 노드를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.delete_the_middle_node_of_a_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(ListNode.of(1, 3, 4, 7, 1, 2, 6), ListNode.of(1, 3, 4, 1, 2, 6)),
                () -> test(ListNode.of(1, 2, 3, 4), ListNode.of(1, 2, 4)),
                () -> test(ListNode.of(2, 1), ListNode.of(2))
        );
    }

    private void test(ListNode head, ListNode expected) {
        // when
        Solution solution = new Solution();
        ListNode actual = solution.deleteMiddle(head);
        // then
        assertEquals(expected, actual);
    }

}
```

<details>
<summary>ListNode.java 보기</summary>

```java
package io.lcalmsky.leetcode;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode of(int... integers) {
        if (integers == null || integers.length == 0) throw new IllegalArgumentException();

        ListNode head = new ListNode(0);
        ListNode last = head;
        ListNode p;
        for (int integer : integers) {
            p = new ListNode(integer);
            last.next = p;
            last = last.next;
        }

        return head.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListNode)) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}

```

</details>
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/linked_list_cycle/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/linked-list-cycle/) 있습니다.

## Problem

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)
```text
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
```
**Example 2:**
```text
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
```
**Example 3:**
```text
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
```


**Constraints:**

* The number of the nodes in the list is in the range [0, 104].
* -105 <= Node.val <= 105
* pos is -1 or a valid index in the linked-list.

## Solution

연결 리스트의 head 노드가 주어질 때 리스트 내에 사이클이 존재하는지 판별하는 문제입니다.

두 개의 포인터를 이용해 간단히 해결할 수 있습니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.linked_list_cycle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> {
          ListNode head = ListNode.of(3);
          ListNode next = ListNode.of(2, 0);
          ListNode last = ListNode.of(-4);
          head.next = next;
          next.next = last;
          last.next = next;
          test(head, true);
        },
        () -> {
          ListNode head = ListNode.of(1);
          ListNode last = ListNode.of(2);
          head.next = last;
          last.next = head;
          test(head, true);
        },
        () -> {
          ListNode head = ListNode.of(1);
          test(head, false);
        }
    );
  }

  private void test(ListNode given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.hasCycle(given);
    // then
    assertEquals(expected, actual);
  }
}
```

<details>
<summary>ListNode.java 전체 보기</summary>

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
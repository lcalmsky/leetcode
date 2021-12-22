> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reorder_list/Solution.java) 있습니다.  
> 문제는 [여기](https://github.com/lcalmsky/leetcode/issues/83) 있습니다.

## Problem

You are given the head of a singly linked-list. The list can be represented as:

```
L0 → L1 → … → Ln - 1 → Ln
```
Reorder the list to be on the following form:

```
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
```
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



**Example 1:**

```text
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

**Example 2:**

```text
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
```

**Constraints:**

* The number of nodes in the list is in the range [1, 5 * 104].
* 1 <= Node.val <= 1000

## Solution

단일 연결 리스트가 주어질 때 문제에서 주어진 순서대로 재배열하는 문제입니다.

순서는 아래와 같습니다.

```
0 -> n -> 1 -> n - 1 -> ...
```

여기서 리스트 내 값을 수정하는 것은 안 되고 노드를 재배치하여 구현해야 합니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode previous = null, slow = head, fast = head;
    while (fast != null && fast.next != null) { // (1)
      previous = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    previous.next = null;
    ListNode reversedListNode = reverse(slow); // (2)
    merge(head, reversedListNode); // (3)
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private void merge(ListNode listNode, ListNode reversedListNode) {
    while (listNode != null) {
      ListNode n1 = listNode.next, n2 = reversedListNode.next;
      listNode.next = reversedListNode;
      if (n1 == null) {
        break;
      }
      reversedListNode.next = n1;
      listNode = n1;
      reversedListNode = n2;
    }
  }
}
```

1. 두 개의 포인터를 이용해 ListNode를 두 개로 나눠줍니다.
2. ListNode를 역순으로 정렬합니다.
3. 두 ListNode를 순서에 맞게 합쳐줍니다.

## Test

```java
package io.lcalmsky.leetcode.reorder_list;

import static org.junit.jupiter.api.Assertions.*;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4), ListNode.of(1, 4, 2, 3)),
        () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(1, 5, 2, 4, 3))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    solution.reorderList(given);
    // then
    assertEquals(expected, given);
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
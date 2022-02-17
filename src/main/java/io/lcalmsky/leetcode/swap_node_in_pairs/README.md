> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/swap_nodes_in_pairs/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/swap-nodes-in-pairs/) 있습니다.

## Problem

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

**Example 1:**
![](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

```text
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```
**Example 2:**
```text
Input: head = []
Output: []
```
**Example 3:**
```text
Input: head = [1]
Output: [1]
```


**Constraints:**

* The number of nodes in the list is in the range [0, 100].
* 0 <= Node.val <= 100

## Solution

연결 리스트가 주어질 때 모든 인접한 두 노드를 swap 시켜서 반환하는 문제입니다.

두 개의 포인터를 이용해 간단하게 구현할 수 있습니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode result = new ListNode(0);
    result.next = head;
    ListNode current = result;
    ListNode slow;
    ListNode fast;
    while (current.next != null && current.next.next != null) {
      slow = current;
      current = current.next;
      slow.next = current.next;
      fast = current.next.next;
      current.next.next = current;
      current.next = fast;
    }
    return result.next;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.swap_node_in_pairs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4), ListNode.of(2, 1, 4, 3)),
        () -> test(ListNode.of(), ListNode.of()),
        () -> test(ListNode.of(1), ListNode.of(1))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.swapPairs(given);
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
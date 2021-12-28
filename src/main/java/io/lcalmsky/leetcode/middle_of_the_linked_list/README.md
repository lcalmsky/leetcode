> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/middle_of_the_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/middle-of-the-linked-list/) 있습니다.

## Problem

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg)

```text
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg)

```text
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
```

**Constraints:**

* The number of nodes in the list is in the range [1, 100].
* 1 <= Node.val <= 100

## Solution

단일 연결 리스트가 주어졌을 때 가운데 노드를 반환하는 문제입니다. 가운데 두 노드가 존재할 때는 뒤에있는 노드를 반환해야 합니다.

연결 리스트계 문제 중 가장 기본이 되는 문제라고 할 수 있는데 두 개의 포인터를 이용해 하나는 빠르게 하나는 천천히 이동한 뒤 천천히 이동한 노드 또는 그 다음 노드를 반환하면 됩니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return fast.next == null ? slow : slow.next;
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.middle_of_the_linked_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(3, 4, 5)),
        () -> test(ListNode.of(1, 2, 3, 4, 5, 6), ListNode.of(4, 5, 6))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.middleNode(given);
    // then
    assertEquals(expected, actual);
  }
}
```
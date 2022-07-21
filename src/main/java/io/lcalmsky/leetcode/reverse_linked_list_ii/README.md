> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reverse_linked_list_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/reverse-linked-list-ii/) 있습니다.

## Problem

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

## Solution

단방향 연결리스트의 head와 왼쪽, 오른쪽 노드의 값이 주어질 때 왼쪽, 오른쪽에 해당하는 범위 내 노드를 reverse 시키는 문제입니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode result = new ListNode(0);
    result.next = head;
    ListNode prevLeftNode = result;
    for (int i = 0; i < left - 1; i++) {
      prevLeftNode = prevLeftNode.next;
    }
    ListNode leftNode = prevLeftNode.next;
    ListNode rightNode = leftNode;
    for (int i = 0; i < right - left; i++) {
      rightNode = rightNode.next;
    }
    ListNode postRightNode = rightNode.next;
    ListNode previous = prevLeftNode;
    ListNode node = leftNode;
    while (previous != rightNode) {
      ListNode next = node.next;
      node.next = previous;
      previous = node;
      node = next;
    }
    prevLeftNode.next = rightNode;
    leftNode.next = postRightNode;
    return result.next;
  }
}
```

먼저 left 전 노드와 right 이후 노드를 찾은 뒤 그 사이에 해당하는 노드를 뒤집어주면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.reverse_linked_list_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenLinkedList_whenReverse_thenCorrect() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), 2, 4, ListNode.of(1, 4, 3, 2, 5)),
        () -> test(ListNode.of(3, 5), 1, 1, ListNode.of(3, 5))
    );
  }

  private void test(ListNode given, int m, int n, ListNode expected) {
    // when
    Solution reverseLinkedList2 = new Solution();
    ListNode actual = reverseLinkedList2.reverseBetween(given, m, n);

    // then
    assertEquals(expected, actual);
  }
}
```
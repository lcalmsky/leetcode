> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/remove_linked_list_elements/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/remove-linked-list-elements/) 있습니다.

## Problem

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg)

```text
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
```

**Example 2:**

```text
Input: head = [], val = 1
Output: []
```

**Example 3:**

```text
Input: head = [7,7,7,7], val = 7
Output: []
```

**Constraints:**

* The number of nodes in the list is in the range [0, 104].
* 1 <= Node.val <= 50
* 0 <= val <= 50

## Solution

LinkedList가 주어졌을 때 특정 값을 가진 노드를 제거한 LinkedList를 반환하는 문제입니다.

Easy 레벨이기도 하고 너무 LinkedList를 구현하는 정도의 아주 쉬운 난이도라 바로 소스 코드 첨부로 설명을 대체하겠습니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode removeElements(ListNode head, int val) {
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode current = root;
    while (current.next != null) {
      if (current.next.val != val) {
        current = current.next;
        continue;
      }
      current.next = current.next.next;
    }
    return root.next;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.remove_linked_list_elements;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenLinkedList_whenRemoveElements_thenCorrect() {
    assertAll(
        () -> test(ListNode.of(1, 2, 6, 3, 4, 5, 6), 6, ListNode.of(1, 2, 3, 4, 5))
    );
  }

  private void test(ListNode given, int val, ListNode expected) {
    // when
    Solution removeLinkedListElements = new Solution();
    ListNode actual = removeLinkedListElements.removeElements(given, val);

    // then
    assertEquals(expected, actual);
  }
}
```
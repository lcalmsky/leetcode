> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/odd_even_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/odd-even-linked-list/) 있습니다.

## Problem

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg)

```text
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/10/oddeven2-linked-list.jpg)

```text
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
```

**Constraints:**

* The number of nodes in the linked list is in the range [0, 10^4].
* -10^6 <= Node.val <= 10^6

## Solution

단일 연결 리스트의 head가 주어질 때, 모든 홀수 인덱스를 모든 짝수 인덱스 뒤로 다시 정렬하는 문제입니다.

```java
package io.lcalmsky.leetcode.odd_even_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.odd_even_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(1, 3, 5, 2, 4)),
                () -> test(ListNode.of(2, 1, 3, 5, 6, 4, 7), ListNode.of(2, 3, 6, 7, 1, 5, 4))
        );
    }

    private void test(ListNode head, ListNode expected) {
        Solution solution = new Solution();
        ListNode actual = solution.oddEvenList(head);
        assertEquals(expected, actual);
    }
}
```
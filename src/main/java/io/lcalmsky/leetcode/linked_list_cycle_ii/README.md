> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/linked_list_cycle_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/linked_list_cycle_ii/) 있습니다.

## Problem

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

**Example 1:**
```text
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```
**Example 2:**
```text
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```
**Example 3:**
```text
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
```

**Constraints:**

* The number of the nodes in the list is in the range [0, 10^4].
* -10^5 <= Node.val <= 10^5
* pos is -1 or a valid index in the linked-list.

## Solution

Linked List의 head 노드가 주어질 때 순환이 시작되는 node를 찾는 문제입니다. 순환 구간이 없다면 null을 반환합니다.

```java
package io.lcalmsky.leetcode.linked_list_cycle_ii;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) { // (1)
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) { // (2) 
      return null;
    }
    slow = head; // (3)
    while (slow != fast) { // (4) 
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
```

1. 두 개의 포인터를 이용해 두 포인터가 같은 노드를 가리킬 때까지 노드를 이동시킵니다.
2. 같은 노드를 찾지 못하고 마지막노드까지 이동했다면 cycle이 존재하지 않습니다.
3. 느린 포인터를 다시 head로 변경해줍니다.
4. head부터 출발하여 다시 같아지는 지점이 cycle이 시작되는 지점이 됩니다.
> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/merge_k_sorted_lists/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/merge-k-sorted-lists/) 있습니다.

## Problem

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

**Example 1:**
```text
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```
**Example 2:**
```text
Input: lists = []
Output: []
```
**Example 3:**
```text
Input: lists = [[]]
Output: []
```

**Constraints:**

* k == lists.length
* 0 <= k <= 10^4
* 0 <= lists[i].length <= 500
* -10^4 <= lists[i][j] <= 10^4
* lists[i] is sorted in ascending order.
* The sum of lists[i].length won't exceed 10^4.

## Solution

k개의 오름차순으로 정렬된 연결리스트가 주어질 때, 모든 연결 리스트를 하나의 정렬된 연결리스트로 합쳐서 반환하는 문제입니다.

우선순위 큐(Priority Queue)를 이용해 문제를 해결할 수 있습니다.

```java
import io.lcalmsky.leetcode.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val)); // (1) 
    ListNode head = new ListNode(0);
    ListNode current = head;
    for (ListNode list : lists) { // (2)
      if (list != null) {
        queue.offer(list);
      }
    }
    while (!queue.isEmpty()) { // (3)
      ListNode node = queue.poll();
      current.next = node;
      current = current.next;
      if (node.next != null) {
        queue.offer(node.next);
      }
    }
    return head.next;
  }
}
```

1. 노드의 값을 기준으로 정렬된 큐를 선언 및 초기화합니다.
2. 모든 연결리스트의 노드를 큐에 추가합니다.
3. Queue가 빌 때까지 노드를 꺼내 새로운 노드 뒤에 연결합니다.

## Test

```java
package io.lcalmsky.leetcode.merge_k_sorted_lists;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new ListNode[]{ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)},
            ListNode.of(1, 1, 2, 3, 4, 4, 5, 6)),
        () -> test(new ListNode[]{}, null)
    );
  }

  private void test(ListNode[] given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.mergeKLists(given);
    // then
    assertEquals(expected, actual);
  }
}
```
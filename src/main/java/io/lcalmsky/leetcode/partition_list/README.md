> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/partition_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/partition-list/) 있습니다.

## Problem

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/04/partition.jpg)

```text
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
```

**Example 2:**
```text
Input: head = [2,1], x = 2
Output: [1,2]
```

**Constraints**:

* The number of nodes in the list is in the range [0, 200].
* -100 <= Node.val <= 100
* -200 <= x <= 200

## Solution

연결 리스트의 head 노드와 값 x가 주어질 때, x보다 작은 모든 노드가 x보다 크거나 같은 노드 앞에 오도록 분할하는 문제입니다.

이 때 기존의 상대적인 순서는 유지되어야 합니다.

```java
package io.lcalmsky.leetcode.partition_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode partition(ListNode head, int x) {
    // (1)
    ListNode beforeHead = new ListNode(0);
    ListNode before = beforeHead;
    ListNode afterHead = new ListNode(0);
    ListNode after = afterHead;
    // (2)
    while (head != null) {
      // (3)
      if (head.val < x) {
        before.next = head;
        before = before.next;
      } else {
        // (4)
        after.next = head;
        after = after.next;
      }
      // (5)
      head = head.next;
    }
    // (6)
    after.next = null;
    // (7)
    before.next = afterHead.next;
    // (8)
    return beforeHead.next;
  }
}
```

1. 두 개의 포인터를 생성합니다.
2. 연결 리스트를 순차적으로 탐색하면서
3. x보다 작은 경우 before 리스트에 추가합니다.
4. x보다 크거나 같은 경우 after 리스트에 추가합니다.
5. 다음 노드로 이동합니다.
6. after 리스트의 다음 노드를 null로 설정하여 연결을 끊어줍니다.
7. before 리스트의 마지막을 after 리스트의 head와 연결합니다.
8. before 리스트의 head를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.partition_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 4, 3, 2, 5, 2), 3, ListNode.of(1, 2, 2, 4, 3, 5)),
        () -> test(ListNode.of(2, 1), 2, ListNode.of(1, 2))
    );
  }

  private void test(ListNode given, int x, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.partition(given, x);
    // then
    assertEquals(expected, actual);
  }
}
```
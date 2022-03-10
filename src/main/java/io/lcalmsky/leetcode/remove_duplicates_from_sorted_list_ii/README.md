> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/remove_duplicates_from_sorted_list_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) 있습니다.

## Problem

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.


**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg)
```text
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
```
**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg)
```text
Input: head = [1,1,1,2,3]
Output: [2,3]
```

**Constraints:**

* The number of nodes in the list is in the range [0, 300].
* -100 <= Node.val <= 100
* The list is guaranteed to be sorted in ascending order.

## Solution

오름차순으로 정렬된 연결 리스트의 head 노드가 주어질 때, 중복된 값을 가진 노드를 모두 제거하는 문제입니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0); // (1)
    dummy.next = head;
    ListNode current = dummy;
    int duplicated;
    while (current.next != null && current.next.next != null) {
      if (current.next.val == current.next.next.val) { // (2)
        duplicated = current.next.val; // (3)
        while (current.next != null && current.next.val == duplicated) { // (4)
          current.next = current.next.next;
        }
      } else { // (4)
        current = current.next;
      }
    }
    return dummy.next; // (5)
  }
}
```

1. 첫 노드부터 중복 값을 가질 수 있으므로 dummy를 생성해 head 노드를 붙여줍니다.
2. 다음 노드와 다다음 노드가 같을 때
3. 중복 값을 갱신하고
4. 중복 값이 계속되는 동안 현재 노드의 다음 노드를 다다음 노드로 계속 이동시킵니다.
4. 중복 값이 아닐 때 현재 노드의 포인터를 이동시킵니다.
5. dummy 노드를 그대로 반환하면 안 되므로 다음 노드를 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 3, 4, 4, 5), ListNode.of(1, 2, 5)),
        () -> test(ListNode.of(1, 1, 1, 2, 3), ListNode.of(2, 3))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.deleteDuplicates(given);
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
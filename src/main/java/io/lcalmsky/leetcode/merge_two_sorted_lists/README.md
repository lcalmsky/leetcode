> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/merge_two_sorted_lists/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/merge-two-sorted-lists/) 있습니다.

## Problem

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


**Example 1:**
```text
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```
**Example 2:**
```text
Input: list1 = [], list2 = []
Output: []
```
**Example 3:**
```text
Input: list1 = [], list2 = [0]
Output: [0]
```

**Constraints:**

* The number of nodes in both lists is in the range [0, 50].
* -100 <= Node.val <= 100
* Both list1 and list2 are sorted in non-decreasing order.

## Solution

두 개의 정렬된 연결 리스트가 주어질 때 하나의 리스트로 합병하는 문제입니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode result = new ListNode(0); // (1)
    ListNode head = result;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) { // (2)
        head.next = list1;
        list1 = list1.next;
      } else {
        head.next = list2;
        list2 = list2.next;
      }
      head = head.next;
    }
    if (list1 != null) { // (3)
      head.next = list1;
    } else {
      head.next = list2;
    }
    return result.next;
  }
}

```

1. 결과로 반환할 리스트를 생성합니다.
2. 두 리스트를 비교하여 더 작은 쪽을 먼저 추가하고 해당 리스트의 포인터를 다음으로 이동시킵니다.
3. while문을 벗어난 뒤에도 list가 남아있으면 뒤에 나머지 전부를 이어 붙입니다.

## Test

```java
package io.lcalmsky.leetcode.merge_two_sorted_lists;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4), ListNode.of(1, 1, 2, 3, 4, 4)),
        () -> test(null, null, null),
        () -> test(null, ListNode.of(0), ListNode.of(0))
    );
  }

  private void test(ListNode list1, ListNode list2, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.mergeTwoLists(list1, list2);
    // then
    assertEquals(expected, actual);
  }
}
```

<details>
<summary>ListNode.java 보기</summary>

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
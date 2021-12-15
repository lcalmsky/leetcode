> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/insertion_sort_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/insertion-sort-list/) 있습니다.

## Problem

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

1. Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
3. It repeats until no input elements remain.

The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

![](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/04/sort1linked-list.jpg)

```text
Input: head = [4,2,1,3]
Output: [1,2,3,4]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/04/sort2linked-list.jpg)

```text
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```

**Constraints:**

* The number of nodes in the list is in the range [1, 5000].
* -5000 <= Node.val <= 5000

## Solution

연결리스트가 주어질 때 삽입정렬을 이용해 정렬하고 해당 리스트의 head 노드를 반환하는 문제입니다.

문제에 설명된 알고리즘대로 구현하시면 됩니다.

연결리스트를 사용한다는 특수한 상황이기 때문에 나중에 반환하기 위한 리스트를 임시로 만들어놓고 임시 리스트 뒤로 정렬한 값들을 추가한 뒤 마지막에는 head 노드의 다음 노드를 반환하도록 해주면 됩니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode result = new ListNode(0);
    ListNode previous = result;
    ListNode current = head;
    ListNode next;
    while (current != null) {
      next = current.next;
      while (previous.next != null && previous.next.val < current.val) {
        previous = previous.next;
      }
      current.next = previous.next;
      previous.next = current;
      previous = result;
      current = next;
    }
    return result.next;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.insertion_sort_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(4, 2, 1, 3), ListNode.of(1, 2, 3, 4)),
        () -> test(ListNode.of(-1, 5, 3, 4, 0), ListNode.of(-1, 0, 3, 4, 5))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.insertionSortList(given);
    // then
    assertEquals(expected, actual);
  }
}
```

---

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
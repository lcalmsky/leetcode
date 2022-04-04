> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/swapping_nodes_in_a_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/) 있습니다.

## Problem

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/09/21/linked1.jpg)

```text
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
```

**Example 2:**
```text
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
```

**Constraints:**

* The number of nodes in the list is n.
* 1 <= k <= n <= 10^5
* 0 <= Node.val <= 100

## Solution

연결 리스트와 정수 k가 주어질 때 처음부터 k번째 원소와 뒤에서부터 k번째 원소를 swap하는 문제입니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode swapNodes(ListNode head, int k) {
    k = k - 1;
    ListNode forward = head; 
    while (k > 0) { // (1)
      forward = forward.next;
      k--;
    }
    ListNode remain = forward; // (2)
    ListNode backward = head; // (3)
    while (remain.next != null) { // (4)
      backward = backward.next;
      remain = remain.next;
    }
    // (5)
    int temp = forward.val;
    forward.val = backward.val;
    backward.val = temp;
    return head;
  }
}
```
1. 앞쪽 방향으로 진행하면서 k 번째 원소를 찾습니다.
2. k번째부터 앞쪽 방향으로 이동할 노드입니다.
3. 뒤쪽에서부터 k번째 원소를 찾기 위한 노드 입니다.
4. 2번의 노드를 끝까지 이동시키는동안 3번의 노드도 같이 이동시킵니다. 그럼 뒤에서 k번째 노드를 구할 수 있습니다.
5. 두 노드를 swap해 줍니다.

## Test

```java
package io.lcalmsky.leetcode.swapping_nodes_in_a_linked_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(1, 4, 3, 2, 5)),
        () -> test(ListNode.of(7, 9, 6, 6, 7, 8, 3, 0, 9, 5), 5,
            ListNode.of(7, 9, 6, 6, 8, 7, 3, 0, 9, 5))
    );
  }

  private void test(ListNode head, int k, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.swapNodes(head, k);
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
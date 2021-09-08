> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/reverse_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3966/) 있습니다.

## Problem
Given the head of a singly linked list, reverse the list, and return the reversed list.


**Example 1:**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg)

```
Input: head = [1,2]
Output: [2,1]
```

**Example 3:**

```
Input: head = []
Output: []
```

**Constraints:**

* The number of nodes in the list is the range [0, 5000].
* -5000 <= Node.val <= 5000

**Follow up**: A linked list can be reversed either iteratively or recursively. Could you implement both?

## Solution

LinkedList를 역순으로 뒤집는 단순한 문제 입니다.

문제에서 요구하는대로 반복문과 재귀호출을 이용해 각각 풀어보겠습니다.

먼저 가장 쉽게 할 수 있는 방법은 LinkedList의 tail 노드로 이동해 거꾸로 탐색하면서 새로운 노드에 추가하는 방법이겠지만, 노드가 엄청 많을 경우 이 방법은 굉장히 비효율적입니다.

재귀호출을 이용할 경우 Stack을 사용할 때와 동일하게 가장 나중에 반환한 값을 가장 먼저 처리할 수 있다는 점을 이용해 간단히 구현할 수 있습니다.

계속 다음 노드를 찾아 다시 자기 자신을 호출하게 되면 마지막 노드까지 다다랐을 때 가장 마지막에 호출한 노드(마지막 노드)를 이용해 재귀호출 시점 이후가 진행됩니다.

이 때 주의해야 할 점은 현재 노드가 다음 노드 뒤에 연결되어야 하므로 현재 노드의 next를 null로 설정해줘야 합니다.

```java
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null; // 여기서 null로 설정하지 않으면
        ListNode node = reverseList(nextNode);
        nextNode.next = head; // nextNode.next.next가 null이 아님
        return node;
    }
}
```

반복문을 이용할 경우 두 개의 포인터를 이용해 매번 현재 노드를 다음 노드로 갱신해주는 방법을 이용해야 합니다.

```java
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        head.next = null;
        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        return p1;
    }
}
```

## Test

```java
package io.lcalmsky.leetcode.reverse_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenListNode_whenReverse_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(5, 4, 3, 2, 1))
        );
    }

    private void test(ListNode given, ListNode expected) {
        // when
        Solution reverseLinkedList = new Solution();
        ListNode actual = reverseLinkedList.reverseList(given);

        // then
        assertEquals(expected, actual);
    }
}
```

```java
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
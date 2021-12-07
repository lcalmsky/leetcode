> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/convert_binary_number_in_a_linked_list_to_integer/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/) 있습니다.

## Problem

Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/12/05/graph-1.png)

```text
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
```

**Example 2:**

```text
Input: head = [0]
Output: 0
```

**Example 3:**

```text
Input: head = [1]
Output: 1
```

**Example 4:**

```text
Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
```

**Example 5:**

```text
Input: head = [0,0]
Output: 0
```

Constraints:

* The Linked List is not empty.
* Number of nodes will not exceed 30.
* Each node's value is either 0 or 1.

## Solution

0과 1로 구성된 연결리스트가 주어지고 이 연결리스트가 이진수를 나타낼 때 십진수로 변환하는 문제입니다.

먼저 가장 간단한 방법은 연결리스트의 값들을 그대로 문자열로 만들어서 이진수를 십진수로 변환하는 방법입니다.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public int getDecimalValue(ListNode head) {
    StringBuilder stringBuilder = new StringBuilder();
    while (head != null) {
      stringBuilder.append(head.val);
      head = head.next;
    }
    return Integer.valueOf(stringBuilder.toString(), 2);
  }
}
```

당연히 쉽게 통과과되는데 성능을 개선시킬 방법이 있을 거 같아서 찾아보았습니다.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public int getDecimalValue(ListNode head) {
    int result = 0;
    while (head != null) {
      result = result * 2 + head.val;
      head = head.next;
    }
    return result;
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.convert_binary_number_in_a_linked_list_to_integer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 0, 1), 5),
        () -> test(ListNode.of(0), 0),
        () -> test(ListNode.of(1), 1),
        () -> test(ListNode.of(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0), 18880),
        () -> test(ListNode.of(0, 0), 0)
    );
  }

  private void test(ListNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.getDecimalValue(given);
    // then
    assertEquals(expected, actual);
  }
}
```

<details>
<summary>ListNode 클래스 보기</summary>

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
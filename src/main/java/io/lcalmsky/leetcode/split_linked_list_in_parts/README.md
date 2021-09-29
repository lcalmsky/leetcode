> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/split_linked_list_in_parts/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3992/) 있습니다.

## Problem

Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

**Example 1:**

```text
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].
```

**Example 2:**

```text
Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
```

**Explanation:**
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.

**Constraints:**

* The number of nodes in the list is in the range [0, 1000].
* 0 <= Node.val <= 1000
* 1 <= k <= 50

## Solution

LinkedList가 주어졌을 때 최대한 비슷하게 나누는 문제입니다.

딱 나누어 떨어지지 않는 경우 나눠진 노드의 크기가 1을 초과해서 차이나면 안 됩니다.

> 예제 2번 처럼 4, 3, 3 으로 나눠져야 합니다.

주어진 리스트의 사이즈보다 큰 수로 나누게 되면 나눠진 리스트의 배열 뒷부분은 null이 될 수 있습니다.

> 예쩨 1번처럼 1, 1, 1, null, null로 나눠져야 합니다.

먼저 주어진 리스트의 길이를 구해야하고, K로 나눴을 때의 몫과 나머지를 알아야 최대한 균등하게 나눌 수 있습니다.

나머지가 무조건 몫보다 1이상 작거나 같기 때문에 리스트 노드 배열에 담을 때 앞에서부터 하나씩만 추가해주면 원하는 답을 얻을 수 있습니다.

> 예제 2번의 경우 10 / 3 = 3, 10 % 3 = 1 이므로 균등하게 3, 3, 3으로 나눈 뒤 앞에서부터 1씩 더해주면 4, 3, 3이 됩니다.  
> 11개일 경우 3, 3, 3으로 나눈 뒤 앞에서 부터 1씩 추가해 4, 4, 3을 만들 수 있습니다.

나누는 방법은 배열에 head를 먼저 넣고 갯수만큼 카운트 한 다음 노드의 다음 노드를 끊어주는 방식을 사용하면 됩니다.

계속 위치를 파악해야 하기 때문에 이전 위치를 기록할 노드를 추가로 사용합니다.

소스 코드를 먼저 확인한 뒤 자세히 설명하도록 하겠습니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = getLength(head);
        int each = length / k;
        int extra = length % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode prev = null;
        for (int i = 0; i < k; i++, extra--) { // (1)
            listNodes[i] = head; // (2)
            for (int j = 0; j < each + (extra > 0 ? 1 : 0); j++) { // (3)
                prev = head; // (4)
                head = head.next; // (5)
            }
            if (prev != null) { // (6)
                prev.next = null;
            }
        }
        return listNodes;
    }

    private int getLength(ListNode node) {
        int length = 0;
        ListNode current = node;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
}
```

(1) k번 반복문을 돌면서 반복될 때마다 나머지 값을 1씩 줄여줍니다.  
(2) 배열에 현재 head 노드를 저장합니다.  
(3) 균등하게 나눈 뒤 나머지가 0보다 한 번 더 반복될 수 있게 1을 더해줍니다.  
(4) 이전 위치를 기록합니다. 매 번 head의 이전 위치로 갱신됩니다.  
(5) 반복 횟수만큼 다음 노드로 이동합니다.  
(6) 이동이 모두 끝난 뒤 이전 위치가 null이 아니면 다음 노드를 null로 지정해 끊어줍니다.  

위 과정이 반복되면서 배열에 균등한 사이즈를 가진 리스트 노드가 저장되게 됩니다.

소스 코드에 사용된 ListNode 클래스는 [여기](https://jaime-note.tistory.com/66)서 확인할 수 있습니다.

실제로는 주석으로

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
```

이렇게 주어지는데 여러 문제 및 테스트 코드에서 사용하기위해 따로 사용하였습니다.

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

## Test

```java
package io.lcalmsky.leetcode.split_linked_list_in_parts;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void givenListNode_whenSplitInParts_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3), 5, new ListNode[]{
                        ListNode.of(1),
                        ListNode.of(2),
                        ListNode.of(3),
                        null,
                        null
                }),
                () -> test(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3, new ListNode[]{
                        ListNode.of(1, 2, 3, 4),
                        ListNode.of(5, 6, 7),
                        ListNode.of(8, 9, 10)
                })
        );
    }

    private void test(ListNode head, int k, ListNode[] expected) {
        // when
        Solution solution = new Solution();
        ListNode[] actual = solution.splitListToParts(head, k);

        // then
        assertArrayEquals(expected, actual);
    }
}
```
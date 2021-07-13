> 모든 소스 코드는 [여기](https://github.com/lcalmsky/leetcode)서 확인 가능합니다.  
> 문제 링크는 [여기](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) 있습니다.

## Problem
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

![](https://raw.githubusercontent.com/lcalmsky/leetcode/master/src/main/java/io/lcalmsky/leetcode/remove_nth_node_from_end_of_list/remove_ex1.jpeg)

```text
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

Example 2:
```text
Input: head = [1], n = 1
Output: []
```

Example 3:
```text
Input: head = [1,2], n = 1
Output: [1]
```

Constraints:
* The number of nodes in the list is sz.
* 1 <= sz <= 30
* 0 <= Node.val <= 100
* 1 <= n <= sz

Follow up: Could you do this in one pass?

## Solution

주어진 `ListNode`의 마지막에서 `N` 번 째 있는 `Node`를 제거한 뒤 head를 반환하는 문제입니다.

처음 보자마자 든 생각은 `Stack`을 활용하는 것 이었습니다.

`ListNode`를 `head`부터 순차적으로 탐색(next)하면서 `Stack`에 넣게되면 `Node`는 역순으로 나오게되니 `N` 번 째 `Node`만 제거해주면 되겠다는 생각이 들었습니다.

역방향 `Node` `Stack`에서 하나씩 뺄 때마다 N 번 째 `Node`를 제외하고 정방향 `Node` `Stack` 다시 넣고, 다시 정방향 노드 스택에서 꺼내면서 `head` `Node`의 다음 `Node`에 할당해주면 되겠다는 생각이 들어 코딩을 시작했습니다.

진행하면서 몇 가지 예외 처리를 해줘야 했는데 소스 코드 내에 주석처리 하였습니다.

```java
package io.lcalmsky.leetcode.remove_nth_node_from_end_of_list;

import io.lcalmsky.leetcode.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> reverseOrderNodes = new Stack<>();
        Stack<ListNode> naturalOrderNodes = new Stack<>();
        while (head != null) { // (1)
            reverseOrderNodes.push(head);
            head = head.next;
        }
        ListNode current = null;
        while (n-- > 0) { // (2)
            current = reverseOrderNodes.pop();
            naturalOrderNodes.push(current);
        }
        naturalOrderNodes.pop(); // (3)
        while (!reverseOrderNodes.isEmpty()) { // (4)
            naturalOrderNodes.push(reverseOrderNodes.pop());
        }
        if (naturalOrderNodes.isEmpty()) { // (5)
            return null;
        }
        head = naturalOrderNodes.pop(); // (6)
        head.next = null;
        current = head;
        while (!naturalOrderNodes.isEmpty()) { // (7)
            current.next = naturalOrderNodes.pop();
            current = current.next;
        }
        current.next = null; // (8)
        return head;
    }
}
```

> (1) `head` 부터 다음 `Node`를 탐색하면서 `Stack`에 `Node`를 추가하여 `Stack`에서 다시 꺼낼 때 역방향이 되도록 합니다.   
> (2) 역방향 `Node` `Stack`에서 `N`개의 `Node`를 꺼내면서 정방향 `Node` `Stack`에 다시 넣습니다.  
> (3) 정방향 `Node` `Stack`에 마지막으로 추가된 `Node`를 꺼냅니다. 이 때 꺼내는 `Node`가 `N` 번 째 `Node`입니다.  
> (4) 역방향 `Node` `Stack`이 완전히 비워질 때까지 남은 `Node`들을 꺼내 다시 정방향 `Node` `Stack`에 추가합니다.  
> (5) 이 때 정방향 `Node` `Stack`이 비어있다면 앞에서 제거된 `Node`가 유일한 `Node`였던 것으로 `head`가 `null`이 됩니다.  
> (6) 정방향 `Node` `Stack`에서 `Node`를 하나 꺼내 `head`에 할당합니다.  
> (7) 정방향 `Node` `Stack`이 완전히 비워질 때까지 남은 `Node`들을 꺼내 `head` `Node` 뒤로 추가합니다.  
> (8) 마지막 `Node`의 `next` `Node`를 `null`로 바꿔줍니다.

일단 제가 생각한 알고리즘대로 구현했고, 테스트 소스 코드를 작성하여 테스트해봤습니다.

```java
class SolutionTest {

    Solution solution;

    @Test
    void testAll() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(1, 2, 3, 5)),
                () -> test(ListNode.of(1), 1, null),
                () -> test(ListNode.of(1, 2), 1, ListNode.of(1)),
                () -> test(ListNode.of(1, 2), 2, ListNode.of(2)),
                () -> test(ListNode.of(1, 2, 3), 1, ListNode.of(1, 2))
        );
    }

    private void test(ListNode head, int n, ListNode expected) {
        // when
        solution = new Solution();
        ListNode actual = solution.removeNthFromEnd(head, n);

        // then
        assertEquals(expected, actual);
    }
}
```

보시면 아시겠지만 1, 2, 3번 째 테스트는 예시에 나와있지만 4, 5번은 나와있지 않습니다.

예외처리가 빠져서 `LeetCode`에 제출했을 때 실패한 케이스들을 추가하면서 테스트한 것인데요, 결과적으로는 Success를 받았습니다.

그러나..

```text
Runtime: 3 ms, faster than 19.28% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 38.9 MB, less than 15.12% of Java online submissions for Remove Nth Node From End of List.
```

결과가 너무 아쉽습니다.

사실 `Stack`을 두 개나 사용하였고 끝까지 탐색한 뒤에 기존 포인터 정보는 전혀 활용하지 않은채로 진행했기 때문에 어떻게 보면 당연한 결과라고 할 수 있으나 그나마 `ListNode` 문제를 혼자 힘으로 풀었다는데 위안 삼고 더 나은 답을 검색해보았습니다.

```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head, previous = head;
        while (n-- > 0) { // (1)
            current = current.next;
        }
        if (current == null) { // (2)
            return head.next;
        }
        while (current.next != null) { // (3)
            current = current.next;
            previous = previous.next;
        }
        previous.next = previous.next.next; // (4)
        return head;
    }
}
```

이럴수가..

당연히 이런 방식이 있을 거라고는 생각했지만 처음부터 이 방법이 어려울 거라고 지레 겁먹은 제 자신이 너무 부끄럽네요 🥲

> (1) `head` 에서 `N` 번 이동합니다.    
> (2) 현재 `Node`가 `null`이면 head의 다음 `Node`를 반환합니다.    
> 예를 들어 2개의 `Node`중 뒤에서 2번째 `Node`를 제거해야 한다고하면 1, 2 이후 `null`이므로 1이 없어져야하고 1은 현재 `head`이므로 `head.next`를 반환하면 됩니다.  
> (3) 현재 `Node`가 `null`이 아니면 현재 `Node`가 `null`이 될 때까지 다음 `Node`를 탐색합니다. 이 때 다른 `Node`가 동시에 `head`에서 출발해 동일한 `Node` 갯수만큼 탐색하게 됩니다.    
> (4) 현재 `Node`가 `null`이 됐을 때 다른 `Node`(previous)는 뒤에 `N`개의 `Node`를 남기게 됩니다.  
> (5) 답은 `N` 번 째 `Node`를 제거한 `head` `Node`를 반환하는 것이므로, `previous` `Node`의 다음 `Node`인 `N` 번 째 `Node`와의 연결을 끊어주고 그 다음 `Node`로 할당해 줍니다.

이렇게 수정해서 제출했더니

```text
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 39.1 MB, less than 9.36% of Java online submissions for Remove Nth Node From End of List.
```

메모리는 조금 더 사용하지만 거의 의미 없는 수치 차이였고, 수행 시간은 매우매우 빨라졌습니다.

---

결과적으로는 허무한 마음도 들었지만 직접 시도해서 풀긴(?) 풀었고, 그 이후 새로운 방법을 찾아보는 과정에서 얻은 지식이다보니 조금 더 머리속에 오래 남아있지 않을까 싶습니다.

한편으로는 언제 쯤 머리가 저렇게 비상하게 굴러갈까(사실 대단한 것도 아니지만 두 개의 노드를 이동시켜서 뒤에서 N 번 째를 확인한다는 건 제 머리로는 평생을 소모해도 떠올리지 못했을 거 같은..)하는 마음에 속상하기도 하네요 😭


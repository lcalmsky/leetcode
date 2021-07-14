> 모든 소스 코드는 [여기](https://github.com/lcalmsky/leetcode) 있습니다.

`LeetCode`에서 알고리즘 문제를 풀다보면 `ListNode`를 이용해 테스트 해야할 일이 많이 있습니다.

테스트 코드나 `main` 메서드 내에서 객체를 생성하고 `ListNode`를 파라미터로 넘겨주다보면 매우 불편한 경우가 많이 있습니다.

먼저 `LeetCode`에서 주어지는 `ListNode`를 살펴보면

```java
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```

이렇게 되어있습니다.

단순하게 생성자를 통해 `value`를 주입하고 다음 노드를 세팅하는 방식으로 사용하거나 생성자에서 다음 노드를 함께 받아 처리할 수 있는 구조입니다.

하지만 예시에서는 `ListNode`를 표현할 때 `[0 -> 2 -> 1 -> 4 -> 5] `이런식으로 head Node에서 시작해 연결된 노드들을 화살표 등으로 표현하거나 단순히 배열 처럼 `[0, 2, 1, 4, 5]` 이런식으로 표현하기도 합니다.

내가 짠 알고리즘이 맞는지 온라인으로 직접하기 전에 `IDE`로 확인하고 싶은 게 우리 개발자들에겐 인지상정 아니겠습니까?

하지만 이를 테스트하려면 굉장한 노가다 작업이 필요합니다.

```java
import io.lcalmsky.leetcode.ListNode;

class Solution {
    public static void main(String[] args) {
        // 0 - 2 - 1 - 4 - 5 순으로 입력
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.solution(listNode);
    }

    // 알고리즘을 풀기 위한 메서드가 있다고 가정
    public Something solution(ListNode head) {
        // 
        return Something;
    }
}
```

위의 예시는 다소 극단적이긴 합니다만 마음이 급할 때는 몇 개 안 되니까 저런식으로(?) 구현할 때도 있습니다.

하지만 이제 겨우 예시 하나를 입력해서 테스트 해 볼 수 있는 상태이고, 예시에 주어진 `ListNode`의 길이가 어마어마하게 길다면 차마 엄두를 낼 수가 없습니다. (그저 온라인 테스트에서 바로 통과하길 바랄 수 밖에..)

그래서 저는 `LeetCode`에서 자주 사용하는 자료구조의 경우 테스트하기 편하게 추가로 생성자나 메서드를 구현하여 바로바로 테스트하고 결과를 확인할 수 있게 공통 클래스로 정의해 따로 사용하고 있습니다.

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

`static` 생성자인 `of()`를 이용해 `ListNode`의 값들을 순차적으로 입력하면 `ListNode`를 생성해 `head` 노드를 반환하는 내용과 `toString`, `equals`, `hashCode` 메서드가 추가로 `override` 되어있습니다.

`of()` 메서드는 실제로 `ListNode`를 생성하는 알고리즘이 그대로 구현되어 있어 별 다른 설명은 필요 없을 거 같습니다.

이렇게 구현한 `ListNode`를 활용해서 테스트 코드를 작성하면,

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

이런식으로 `ListNode`를 초기화하여 바로 사용할 수 있습니다.👻

다음에는 `TreeNode`를 쉽게 초기화 하고 이쁘게(?) 출력할 수 있는 구현체를 소개하겠습니다.
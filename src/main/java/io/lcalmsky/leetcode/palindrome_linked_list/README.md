> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/palindrome_linked_list/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/palindrome-linked-list/) 있습니다.

## Problem

Given the head of a singly linked list, return true if it is a palindrome.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg)

```text
Input: head = [1,2,2,1]
Output: true
```
**Example 2:**

![](https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg)

```text
Input: head = [1,2]
Output: false
```

**Constraints:**

* The number of nodes in the list is in the range [1, 10^5].
* 0 <= Node.val <= 9


**Follow up:** Could you do it in O(n) time and O(1) space?


## Solution

연결 리스트가 주어졌을 때 연결 리스트가 회문(기러기 토마토 스위스 인도인 별똥별 우영우)인지 확인하는 문제입니다.

```java
import io.lcalmsky.leetcode.ListNode;

public class Solution {

  private ListNode left;

  public boolean isPalindrome(ListNode head) {
    left = head;
    return helper(head);
  }

  private boolean helper(ListNode right) {
    if (right == null) {
      return true;
    }
    boolean rightResult = helper(right.next);
    if (!rightResult) {
      return false;
    }
    boolean equals = left.val == right.val;
    left = left.next;
    return equals;
  }
}

```

재귀호출을 이용하면 노드 끝까지 간 뒤 첫 노드와 비교하고 결과를 반환하고, 그 이후로는 첫 노드는 뒤로, 맨 끝 노드는 앞으로 이동하면서 비교하여 결과를 구할 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.palindrome_linked_list;

import static org.junit.jupiter.api.Assertions.*;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  public void givenListNode_whenCheckIsPalindrome_thenCorrect() {
    assertAll(
        () -> test(ListNode.of(1, 2), false),
        () -> test(ListNode.of(1, 2, 2, 1), true)
    );
  }

  private void test(ListNode given, boolean expected) {
    // when
    Solution palindromeLinkedList = new Solution();
    boolean actual = palindromeLinkedList.isPalindrome(given);

    // then
    assertEquals(expected, actual);
  }
}
```
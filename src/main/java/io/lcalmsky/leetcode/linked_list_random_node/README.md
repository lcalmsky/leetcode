> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/linked_list_random_node/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/linked-list-random-node/) 있습니다.

## Problem

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.


**Example 1:**

```text
Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
```

**Constraints:**

* The number of nodes in the linked list will be in the range [1, 10^4].
* -10^4 <= Node.val <= 10^4
* At most 10^4 calls will be made to getRandom.


Follow up:

What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

## Solution

LinkedList가 주어졌을 때 랜덤으로 노드의 값을 반환하는 기능을 구현하는 문제입니다.

> 예전에 쿠팡 라이브 코딩테스트 볼 때 유사한 문제를 풀었던 기억이 있는데, 그 때 가장 중요하게 취급했던 부분은 **시간, 공간 복잡도**였으니 이런 문제를 풀 때 한 번 쯤 고려해 볼 만한 것 같습니다.

Map을 사용하여 간단히 구현하였습니다.

```java
import io.lcalmsky.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

  private final Map<Integer, ListNode> map;
  private final Random random;

  public Solution(ListNode head) {
    map = new HashMap<>();
    random = new Random();
    int i = 0;
    while (head != null) {
      map.put(i++, head);
      head = head.next;
    }
  }

  public int getRandom() {
    return map.get(random.nextInt(map.size())).val;
  }
}

```

## Test

```java
package io.lcalmsky.leetcode.linked_list_random_node;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.lcalmsky.leetcode.ListNode;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void test() {
    Solution solution = new Solution(ListNode.of(1, 2, 3));
    List<Integer> list = List.of(1, 2, 3);
    assertTrue(list.contains(solution.getRandom()));
    assertTrue(list.contains(solution.getRandom()));
    assertTrue(list.contains(solution.getRandom()));
  }
}
```
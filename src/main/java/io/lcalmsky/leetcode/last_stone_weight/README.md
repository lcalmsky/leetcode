> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/last_stone_weight/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/last-stone-weight/) 있습니다.

## Problem

You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

* If x == y, both stones are destroyed, and
* If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.

**Example 1:**
```text
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
```
**Example 2:**
```text
Input: stones = [1]
Output: 1
```

**Constraints:**

* 1 <= stones.length <= 30
* 1 <= stones[i] <= 1000

## Solution

돌의 무게를 나타내는 정수 배열이 주어집니다.

각 턴마다 가장 무거운 두 개의 돌을 집어 두 개를 부술 수 있습니다.

두 돌의 무게가 같으면 둘 다 부서지고 무게가 다른 경우 더 가벼운 돌은 부서지고 더 무거운 돌은 원래 무게에서 가벼운 돌의 무게를 뺀만큼만 남습니다.

하나의 돌이 남을 때까지 반복해서 위의 작업을 거쳤을 때 남는 돌의 무게를 구하는 문제입니다.

우선순위 큐를 이용해 매 번 돌의 무게가 내림차순으로 정렬되게하면 간단하게 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.last_stone_weight;

import java.util.PriorityQueue;

public class Solution {

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1)); // (1)
    for (int stone : stones) { // (2)
      queue.offer(stone);
    }
    while (queue.size() >= 2) { // (3)
      Integer first = queue.poll();
      Integer second = queue.poll();
      if (first == second) { // (4)
        continue;
      }
      queue.offer(first - second); // (5)
    }
    return queue.isEmpty() ? 0 : queue.poll(); // (6)
  }
}
```

1. 내림 차순으로 정렬하는 우선순위 큐를 생성합니다.
2. 모든 돌을 큐 안에 넣습니다.
3. 큐에 두 개 이상의 원소가 남아있을 동안 반복합니다.
4. 두 개의 돌을 꺼내 둘 다 부서진 경우 다음 돌을 선택합니다.
5. 두 크기가 달라 부서진 경우 부서지고 남은 돌을 다시 큐에 넣습니다.
6. 큐가 비어있으면 0을, 남아있으면 해당 돌을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.last_stone_weight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 7, 4, 1, 8, 1}, 1),
        () -> test(new int[]{1}, 1),
        () -> test(new int[]{1, 3}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.lastStoneWeight(given);
    // then
    assertEquals(expected, actual);
  }
}
```
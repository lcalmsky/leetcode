> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/boats_to_save_people/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/boats-to-save-people/) 있습니다.

## Problem

You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

**Example 1:**
```text
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
```
**Example 2:**
```text
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
```
**Example 3:**
```text
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
```

**Constraints:**

* 1 <= people.length <= 5 * 10^4
* 1 <= people[i] <= limit <= 3 * 10^4

## Solution

people[i]이 i번째 사람의 무게인 배열 people과 각 보트가 최대 한계 무게를 실을 수 있는 무한한 수의 보트가 주어집니다. 각 보트에는 최대 2명이 동시에 탑승할 수 있습니다. 단, 해당 인원의 무게 합이 최대 제한입니다.

주어진 모든 사람을 태울 최소 보트 수를 반환하는 문제입니다.

```java
import java.util.Arrays;

public class Solution {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people); // (1)
    int count = 0, left = 0, right = people.length - 1;
    while (left <= right) { // (2)
      if (people[left] + people[right] <= limit) { // (3)
        left++;
      }
      right--; // (4)
      count++; // (5)
    }
    return count;
  }
}

```

1. 몸무게 순으로 정렬합니다.
2. 가장 가벼운 사람과 가장 무거운 사람을 각각 가리키는 포인터가 서로 같아질 때까지 반복합니다.
3. 현재 가장 가벼운 사람과 가장 무거운 사람의 무게의 합이 무게 제한보다 작거나 같을 때 가장 가벼운 사람의 포인터를 이동시킵니다.
4. 가장 무거운 사람의 포인터를 이동시킵니다.
5. 보트의 개수를 증가시킵니다.

## Test

```java
package io.lcalmsky.leetcode.boats_to_save_people;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2}, 3, 1),
        () -> test(new int[]{3, 2, 2, 1}, 3, 3),
        () -> test(new int[]{3, 5, 3, 4}, 5, 4)
    );
  }

  private void test(int[] people, int limit, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numRescueBoats(people, limit);
    // then
    assertEquals(expected, actual);
  }
}
```
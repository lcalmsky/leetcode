> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximize_distance_to_closest_person/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximize-distance-to-closest-person/) 있습니다.

## Problem

You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to the closest person.

**Example 1:**
![](https://assets.leetcode.com/uploads/2020/09/10/distance.jpg)
```text
Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
```
**Example 2:**
```text
Input: seats = [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
```
**Example 3:**
```text
Input: seats = [0,1]
Output: 1
```

**Constraints:**

* 2 <= seats.length <= 2 * 10^4
* seats[i] is 0 or 1.
* At least one seat is empty.
* At least one seat is occupied.

## Solution

좌석을 나타내는 배열이 주어지는데 사람이 앉아있으면 1, 비어있으면 0으로 나타냅니다.

최소 하나의 빈 좌석과 최소 하나의 사람이 앉아있는 좌석이 주어지고, Alex가 자리를 골라 앉으려고 할 때 다른 사람과 가장 멀리 떨어진 곳의 좌표를 구하는 문제입니다.

```java
public class Solution {

  public int maxDistToClosest(int[] seats) {
    int leftMax = 0;
    int rightMax = 0;
    for (int seat : seats) { // (1)
      if (seat != 0) {
        break;
      }
      leftMax++;
    }
    for (int i = seats.length - 1; i >= 0; i--) { // (2)
      if (seats[i] != 0) {
        break;
      }
      rightMax++;
    }
    int max = Math.max(leftMax, rightMax);
    int count = 0;
    for (int i = leftMax; i < seats.length - rightMax; i++) { // (3)
      count++;
      if (seats[i] == 1) {
        max = Math.max(max, count / 2);
        count = 0;
      }
    }
    return max;
  }
}
```

1. 좌석의 왼쪽부터 사람이 앉은 좌석이 나타날 때까지의 거리를 계산합니다.
2. 좌석의 오른쪽부터 사람이 앉은 좌석이 나타날 때까지의 거리를 계산합니다.
3. 1, 2번과 마찬가지로 사람이 나타날때까지의 거리를 구하는데 이미 좌, 우에 사람이 있기 때문에 중간까지의 거리가 실제 거리가 됩니다.

## Test

```java
package io.lcalmsky.leetcode.maximize_distance_to_closest_person;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSeats_whenFindMaxDistanceToClosestPerson_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 0, 0, 0, 1, 0, 1}, 2),
        () -> test(new int[]{1, 0, 0, 0}, 3),
        () -> test(new int[]{0, 1}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxDistToClosest(given);
    // then
    assertEquals(expected, actual);
  }
}
```
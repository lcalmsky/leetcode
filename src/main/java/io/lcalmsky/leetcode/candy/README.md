> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/candy/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/candy/) 있습니다.

## Problem

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.

**Example 1:**
```text
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
```

**Example 2:**
```text
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
```

**Constraints:**

* n == ratings.length
* 1 <= n <= 2 * 10^4
* 0 <= ratings[i] <= 2 * 10^4

## Solution

n명의 아이가 한 줄로 서있고 각각의 아이는 평가 점수를 가지고 있습니다.

캔디를 이 아이들에게 나눠줘야하는데 다음과 같은 요구사항을 만족시켜야 합니다.

* 최소 하나의 캔디를 나눠 줄 것
* 인접한 학생들 중 더 높은 점수를 가진 아이에게 더 많은 캔디를 줄 것

나눠줘야 할 최소한의 캔디 갯수를 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.candy;

public class Solution {

  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    int[] candies = new int[ratings.length];
    candies[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) { // (1)
        candies[i] = candies[i - 1] + 1;
      } else {
        candies[i] = 1; // (2)
      }
    }
    int sum = candies[ratings.length - 1];
    for (int i = ratings.length - 2; i >= 0; i--) { // (3)
      int current = 1; // (4)
      if (ratings[i] > ratings[i + 1]) { // (5)
        current = candies[i + 1] + 1; // (6)
      }
      sum += Math.max(current, candies[i]); // (7)
      candies[i] = current; // (8)
    }
    return sum;
  }
}

```

1. 점수가 더 높은 아이에게 이전 아이보다 캔디를 하나 더 줍니다.
2. 점수가 더 낮은 경우 캔디를 한 개만 줍니다.
3. 뒤에서부터 아이들을 탐색하면서
4. 최소 한 개를 주는데
5. 뒤의 아이보다 앞에 아이가 점수가 더 높으면
6. 현재 캔디의 갯수를 뒷 아이가 가져야할 캔디의 갯수보다 한 개 더 많이 줍니다.
7. 현재 캔디 갯수와 원래 주기로 했던 캔디의 갯수중 큰 수를 계속 더합니다.
8. 현재 캔디의 갯수를 업데이트 합니다.

누적 캔디갯수를 계산하는데 뒷쪽 방향으로 한 번, 앞쪽 방향으로 한 번 두 번을 반복하면서 둘 중 더 높은 값을 택해 합을 구해주면 됩니다.

## Test

```java
package io.lcalmsky.leetcode.candy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenRatings_whenAllocateCandies_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 0, 2}, 5),
        () -> test(new int[]{1, 2, 2}, 4)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution candy = new Solution();
    int actual = candy.candy(given);

    // then
    assertEquals(expected, actual);
  }
}
```
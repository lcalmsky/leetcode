> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/delete_and_earn/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/delete-and-earn/) 있습니다.

## Problem

You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

* Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.

Return the maximum number of points you can earn by applying the above operation some number of times.


**Example 1:**
```text
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
```

**Example 2:**
```text
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
  You earn a total of 9 points.
```

**Constraints:**

1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^4

## Solution

정수 배열이 주어지고 아래 연산을 원하는 만큼 수행했을 때 얻을 수 있는 최대 포인트를 반환하는 문제입니다.

* 아무 숫자를 골라 지우면 포인트를 획득합니다.
* 그러고나면 반드시 지운 숫자보다 +1 또는 -1인 요소가 같이 삭제됩니다.

```java
public class Solution {

  public int deleteAndEarn(int[] nums) {
    // (1)
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    // (2)
    int[] points = new int[max + 1];
    for (int num : nums) {
      points[num] += num;
    }
    return rob(points);
  }

  private int rob(int[] points) {
    long rob = 0, notRob = 0;
    // (3)
    for (int point : points) {  
      long current = notRob + point;
      notRob = Math.max(notRob, rob);
      rob = current;
    }
    return (int) Math.max(rob, notRob);
  }
}
```

1. 배열의 가장 큰 원소를 구합니다.
2. 가장 큰 원소보다 1 큰 배열을 만들고 각 원소가 해당하는 인덱스에 해당 값을 더해줍니다. 중복된 원소의 경우 원소의 값 * 중복된 횟수만큼의 값을 가집니다.
3. 각 원소가 가지는 값을 순차적으로 탐색하면서 현재 값을 구합니다. 현재 값은 현재 포인트에 이전에 삭제되지 않은 값을 더한 값이고, 삭제되지 않은 값은 삭제된 값과 비교하여 더 큰 수로 지정합니다. 값이 1씩 차이가 나는 경우 어떤 값을 삭제했는지 비교하여 더 높은 수가 남게 되고, 1 이상 차이날 경우 이전 값이 0이 되기 때문에 계산에 영향을 주지 않습니다. 마지막으로 삭제된 값에 현재 값을 할당해주면 다음 차수에 비교하는데 사용될 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.delete_and_earn;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenIntegers_whenPickAndDelete_thenReturnMaximumValue() {
    assertAll(
        () -> test(new int[]{3, 4, 2}, 6),
        () -> test(new int[]{2, 2, 3, 3, 3, 4}, 9)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.deleteAndEarn(given);
    // then
    assertEquals(expected, actual);
  }
}

```
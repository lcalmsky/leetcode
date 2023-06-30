> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/jump_game_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/jump-game-ii/) 있습니다.

## Problem

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

* 0 <= j <= nums[i] and
* i + j < n

Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

**Example 1:**

```text
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```text
Input: nums = [2,3,0,1,4]
Output: 2
```

**Constraints:**

* 1 <= nums.length <= 10^4
* 0 <= nums[i] <= 1000
* It's guaranteed that you can reach nums[n - 1].

## Solution

정수 배열이 주어지는데 정수 배열의 값은 최대 점프할 수 있는 거리입니다. 정수 배열의 0번째 인덱스에 위치해서 마지막 인덱스까지 도달하는데 최소 점프 횟수를 구하는 문제입니다.

```java
package io.lcalmsky.leetcode.jump_game_ii;

public class Solution {

    public int jump(int[] nums) {
        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        return step;
    }
}
```

이 코드는 "점프 게임"을 풀기 위한 그리디(Greedy) 알고리즘을 사용한 구현입니다. 이 알고리즘은 주어진 배열 nums를 통해 최소한의 점프 횟수를 구하는 것을 목표로 합니다.

코드의 주요 아이디어는 다음과 같습니다.

1. lastReach는 이전에 도달한 가장 멀리 갈 수 있는 인덱스를 나타내는 변수입니다. 초기에는 0으로 설정됩니다.
2. reach는 현재까지 도달할 수 있는 가장 멀리 갈 수 있는 인덱스를 나타내는 변수입니다. 초기에는 0으로 설정됩니다.
3. step은 현재까지 수행한 점프 횟수를 나타내는 변수입니다. 초기에는 0으로 설정됩니다.

반복문에서는 다음을 반복합니다.

1. i가 lastReach보다 크다면, lastReach를 reach로 업데이트하고 step을 증가시킵니다. 이는 이전에 도달할 수 있는 가장 멀리 갈 수 있는 인덱스(lastReach)보다 더 멀리 갈 수 있는 인덱스(reach)를 만났으므로, 점프가 필요하다는 의미입니다.
1. 현재 인덱스 i에서의 도달 가능한 가장 멀리 갈 수 있는 인덱스(reach)를 Math.max()를 사용하여 업데이트합니다. nums[i] + i는 현재 인덱스에서의 점프 거리(nums[i])와 현재 인덱스(i)를 더한 값으로, 현재 위치에서 얼마나 멀리 갈 수 있는지를 나타냅니다.

반복문이 종료되면 step은 최소한의 점프 횟수를 나타내며, 이를 반환합니다.

이 알고리즘은 각 단계에서 현재 위치에서 가장 멀리 갈 수 있는 인덱스를 선택하는 그리디한 접근 방식을 사용하여 최소한의 점프 횟수를 구하는 데에 효과적입니다.

## Test

```java
package io.lcalmsky.leetcode.jump_game_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{2, 3, 1, 1, 4}, 2),
                () -> test(new int[]{2, 3, 0, 1, 4}, 2)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.jump(nums);
        // then
        assertEquals(expected, actual);
    }
}
```
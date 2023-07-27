> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/asteroid_collision/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/asteroid-collision/) 있습니다.

## Problem

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

**Example 1:**

```text
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
```

**Example 2:**

```text
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
```

**Example 3:**

```text
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
```

**Constraints:**

* 2 <= asteroids.length <= 10^4
* -1000 <= asteroids[i] <= 1000
* asteroids[i] != 0

## Solution

운석의 질량과 움직임 정보가 담긴 배열이 주어질 때 최종 운석 상태를 반환하는 문제입니다.

운석의 질량은 각 원소의 절대값이고, 방향은 음수/양수로 표현합니다.

서로 마주보는 방향일 경우 충돌이 발생해 운석이 큰 쪽만 남게 되고, 질량이 같을 경우 두 운석 모두 소멸합니다.

```java
package io.lcalmsky.leetcode.asteroid_collision;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            int abs = Math.abs(asteroid);
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < abs) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == abs) {
                stack.pop();
            } else if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

```

1. asteroids 배열을 순회하면서 각 운석에 대해 다음을 수행합니다:
   1. 만약 운석의 크기가 양수이거나 스택이 비어있는 경우, 해당 운석을 스택에 추가합니다(stack.push(asteroid)). 이렇게 함으로써, 현재까지 별 대치가 없는 양수 크기의 운석들을 스택에 저장합니다.
   1. 운석의 크기가 음수인 경우, 운석의 크기를 절대값으로 변경하여 abs 변수에 저장합니다.
   1. 스택이 비어있지 않고, 스택의 맨 위에 있는 운석이 양수이며 그 크기가 abs보다 작은 경우, 충돌이 발생합니다. 이 경우에는 스택의 맨 위에 있는 운석을 제거합니다(stack.pop()). 이러한 과정을 반복하여 abs보다 작은 양수 크기의 운석들을 스택에서 제거합니다.
   1. 충돌이 발생했을 때, 스택의 맨 위에 있는 운석의 크기와 abs가 동일하다면 두 운석은 서로 파괴되므로 스택에서 해당 운석을 제거합니다(stack.pop()).
   1. 충돌이 발생하지 않았거나 스택이 비어있는 경우, 현재 운석을 스택에 추가합니다(stack.push(asteroid)). 이는 음수 크기의 운석이 스택에 살아남은 경우입니다.
1. stack에는 충돌을 피해남으로써 남아 있는 운석들이 저장되어 있습니다. 이들을 새로운 배열에 저장하여 반환합니다.
1. stack.size()를 통해 남아 있는 운석들의 개수를 알아냅니다.
1. result 배열을 생성하고, 스택에서 운석들을 꺼내어 뒤에서부터 result 배열에 저장합니다.
1. 최종적으로 result 배열을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.asteroid_collision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void givenAsteroids_whenCollide_thenFindOutTheStateOfTheAsteroids() {
        assertAll(
                () -> test(new int[]{5, 10, -5}, new int[]{5, 10}),
                () -> test(new int[]{8, -8}, new int[]{}),
                () -> test(new int[]{10, 2, -5}, new int[]{10}),
                () -> test(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.asteroidCollision(given);
        // then
        assertArrayEquals(expected, actual);
    }

}

```
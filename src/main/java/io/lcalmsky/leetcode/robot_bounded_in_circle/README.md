> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/robot_bounded_in_circle/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/robot-bounded-in-circle/) 있습니다.

## Problem

On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

* "G": go straight 1 unit;
* "L": turn 90 degrees to the left;
* "R": turn 90 degrees to the right.

The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

**Example 1:**
```text
Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
```

**Example 2:**
```text
Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
```

**Example 3:**
```text
Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
```

**Constraints:**

* 1 <= instructions.length <= 100
* instructions[i] is 'G', 'L' or, 'R'.

## Solution

세 가지 명령을 반복적으로 영원히 수행하는 로봇이 있는데 명령이 로봇을 순환하게 만드는 경우 true를 반환하는 문제입니다.

```java
package io.lcalmsky.leetcode.robot_bounded_in_circle;

public class Solution {

  public boolean isRobotBounded(String instructions) {
    int x = 0;
    int y = 0;
    int index = 0;
    int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // (1)
    for (char instruction : instructions.toCharArray()) {
      if (instruction == 'R') { // (2)
        index = (index + 1) % 4;
        continue;
      }
      if (instruction == 'L') { // (3)
        index = (index + 3) % 4;
        continue;
      }
      x += directions[index][0]; // (4)
      y += directions[index][1]; // (5)
    }
    return (x == 0 && y == 0) || index != 0; // (6)
  }
}
```

1. 각각 (x, y) 좌표를 나타내고 각 좌표는 북, 동, 남, 서를 나타냅니다.
2. 명령이 R일 때 방향을 설정해줍니다. 처음 R일 때 1이므로 동, 그 다음은 2가 되어 남, 3이 되어 서, 0이 되어 북 순입니다.
3. 명령이 L일 때 방향을 설정해줍니다. 처음 L일 때 3이므로 서, 그 다음은 6이라 2가 되어 남, 다음은 5라 1이되고 동, 다음은 4라 0이되어 북 순입니다.
4. 정해진 방향에 해당하는만큼 x 좌표를 이동시킵니다.
5. 정해진 방향에 해당하는만큼 y 좌표를 이동시킵니다.
6. 최종적으로 x, y좌표가 0이 되면 순환합니다. x, y좌표가 아닌 경우 위치가 이동했다는 것을 나타내고 이 때는 방향이 중요해집니다. index가 0이면 북쪽을 나타내는데 초기 방향이 북쪽이므로 위치는 이동한 상태에서 계속 같은 방향으로 이동하기 때문에 순환하지 않습니다. 반면 index가 1, 2, 3이 나온다면 각각 90도, 180도, 270도를 나타내고, 90도는 4번 반복, 180도는 2번 반복, 270도는 마찬가지로 4번 반복하면 초기 위치로 돌아올 수 있습니다.

## Test

```java
package io.lcalmsky.leetcode.robot_bounded_in_circle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    Solution solution = new Solution();
    assertAll(
        () -> assertTrue(solution.isRobotBounded("GGLLGG")),
        () -> assertFalse(solution.isRobotBounded("GG")),
        () -> assertTrue(solution.isRobotBounded("GL"))
    );
  }
}
```
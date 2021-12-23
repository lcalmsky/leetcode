> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/course_schedule_ii/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/course-schedule-ii/) 있습니다.

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

**Example 1:**

```text
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
```

**Example 2:**

```text
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
```

**Example 3:**
```text
Input: numCourses = 1, prerequisites = []
Output: [0]
```

**Constraints:**

* 1 <= numCourses <= 2000
* 0 <= prerequisites.length <= numCourses * (numCourses - 1)
* prerequisites[i].length == 2
* 0 <= ai, bi < numCourses
* ai != bi
* All the pairs [ai, bi] are distinct.

## Solution

총 수강해야하는 강의 갯수가 주어지고, 강의를 수강하기위한 선 수강과목 정보가 주어질 때 수강해야하는 강의 순서를 반환하는 문제입니다.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] subsequentCourses = new int[numCourses]; // (1)  
    for (int[] prerequisite : prerequisites) {
      subsequentCourses[prerequisite[0]]++; // (2) 
      map.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]); // (3) 
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) { // (4) 
      if (subsequentCourses[i] == 0) {
        queue.offer(i);
      }
    }
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int course = queue.poll();
      result.add(course); // (5) 
      if (!map.containsKey(course)) { // (6) 
        continue;
      }
      for (Integer next : map.get(course)) { // (7) 
        if (--subsequentCourses[next] == 0) { // (8) 
          queue.offer(next); // (9)  
        }
      }
    }
    if (result.size() != numCourses) { // (10)
      return new int[0];
    }
    int[] answer = new int[result.size()]; // (11)
    for (int i = 0; i < answer.length; i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }
}

```

1. 후 수강 과목이 선 수강 과목을 몇 개나 이수해야 수강 가능한지 저장하기 위한 배열을 생성합니다.
2. 후 수강 과목 당 수강해야하는 선 수강 과목의 갯수를 계산합니다.
3. 선 수강 과목을 수강했을 때 수강할 수 있는 후 수강 과목을 저장합니다.
4. 선 수강 과목이 필요하지 않은 과목을 queue에 추가합니다.
5. 먼저 수강해야 하는 과목을 결과에 추가합니다.
6. 위에서 추가한 과목을 수강했을 때 다음에 수강할 수 있는 과목이 없는 경우 아무 것도 하지 않습니다.
7. 선 수강 과목을 수강했을 때 다음으로 수강할 수 있는 과목들을 next라고 하면,
8. next에 해당하는 강의를 수강하기 위해 필요한 선 수강 과목의 갯수를 차감시킵니다.
9. next에 해당하는 강의를 다시 queue에 추가합니다.
10. 결과의 크기가 전체 수강해야 할 강의 수와 같지 않으면 모든 강의를 이수할 수 없으므로 빈 배열을 반환합니다.
11. 결과를 배열로 변환해 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.course_schedule_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, new int[][]{{1, 0}}, new int[]{0, 1}),
        () -> test(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}, new int[]{0, 2, 1, 3}),
        () -> test(1, new int[][]{}, new int[]{0})
    );
  }

  private void test(int numCourses, int[][] prerequisites, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.findOrder(numCourses, prerequisites);
    // then
    Arrays.sort(actual);
    Arrays.sort(expected);
    assertArrayEquals(expected, actual);
  }
}
```
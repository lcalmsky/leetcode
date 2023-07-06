> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/course_schedule/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/course-schedule/) 있습니다.

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

**Example 1:**

```text
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**

```text
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
```

**Constraints:**

* 1 <= numCourses <= 2000
* 0 <= prerequisites.length <= 5000
* prerequisites[i].length == 2
* 0 <= ai, bi < numCourses
* All the pairs prerequisites[i] are unique.

## Solution

코스 수강 순서를 확인하기 위한 그래프를 사용하여, 주어진 선수과목(prerequisites)에 따라 코스를 수강할 수 있는지 판별하는 문제입니다.

```java
package io.lcalmsky.leetcode.course_schedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses]; // 1
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) { // 2
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        int[] visited = new int[numCourses]; // 3
        for (int i = 0; i < numCourses; i++) { // 4
            if (!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int[] visited, List<Integer>[] graph) {
        if (visited[node] == 1) { // 5
            return false;
        }
        if (visited[node] == 2) { // 5
            return true;
        }
        visited[node] = 1; // 6
        for (Integer course : graph[node]) {
            if (!dfs(course, visited, graph)) {
                return false;
            }
        }
        visited[node] = 2; // 7
        return true;
    }
}

```

1. 우선 주어진 코스의 수(numCourses)를 기반으로 그래프(graph)를 생성합니다. 그래프는 각 코스를 노드로 표현하고, 각 코스가 어떤 선수과목을 가지는지 인접 리스트로 표현합니다. 그래프의 크기는 코스의 수(numCourses)와 동일하며, ArrayList 배열로 초기화됩니다.
1. 다음으로, 선수과목(prerequisites) 배열을 순회하면서 그래프에 간선을 추가합니다. 각 선수과목 배열의 요소는 [선수과목, 해당 코스] 형태로 주어지며, 이를 그래프의 인접 리스트에 추가합니다. 예를 들어, prerequisites 배열의 요소 [1, 0]은 0번 코스의 선수과목이 1번 코스임을 의미하므로, 그래프의 1번 인덱스에 0을 추가합니다.
1. 그 다음으로, 방문 상태를 나타내는 visited 배열을 생성합니다. 이 배열은 각 노드의 방문 상태를 저장하는 데 사용됩니다. 방문하지 않은 노드는 0, 방문 중인 노드는 1, 방문이 완료된 노드는 2로 표시됩니다.
1. 마지막으로, 주어진 코스의 수(numCourses)만큼 반복문을 실행하면서 모든 노드에 대해 깊이 우선 탐색(DFS)을 수행합니다. dfs 메서드는 현재 노드와 방문 상태 배열, 그래프를 인자로 받아 재귀적으로 호출됩니다.
1. DFS 함수 내에서는 먼저 현재 노드의 방문 상태를 체크합니다. 만약 방문 중인 노드(visited[node] == 1)라면, 순환 구조가 발견된 것이므로 false를 반환합니다. 이미 방문이 완료된 노드(visited[node] == 2)라면, 이전에 수행한 탐색 결과를 그대로 반환합니다.
1. 방문 상태를 1로 설정한 후, 현재 노드와 연결된 모든 선수과목을 순회하면서 재귀적으로 DFS를 호출합니다. 만약 어떤 선수과목에서 false를 반환받는다면, 해당 코스를 수강할 수 없는 것이므로 false를 반환합니다.
1. 모든 선수과목의 탐색이 완료되었고 순환이 발견되지 않았다면, 현재 노드의 방문 상태를 2로 설정하여 방문 완료를 표시하고 true를 반환합니다.
1. 이렇게 모든 노드에 대해 DFS를 수행하고 나면, 그래프 상에서 순환이 발생하지 않는 경우에만 true를 반환하게 됩니다. 순환 구조가 존재한다면 false를 반환하게 됩니다.

## Test

```java
package io.lcalmsky.leetcode.course_schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(2, new int[][]{{1, 0}}, true),
                () -> test(2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }

    private void test(int numCourses, int[][] prerequisites, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.canFinish(numCourses, prerequisites);
        // then
        assertEquals(expected, actual);
    }

}
```
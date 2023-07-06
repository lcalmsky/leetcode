package io.lcalmsky.leetcode.course_schedule;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int[] visited, List<Integer>[] graph) {
        if (visited[node] == 1) {
            return false;
        }
        if (visited[node] == 2) {
            return true;
        }
        visited[node] = 1;
        for (Integer course : graph[node]) {
            if (!dfs(course, visited, graph)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
}

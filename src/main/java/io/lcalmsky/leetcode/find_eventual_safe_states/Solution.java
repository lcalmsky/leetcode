package io.lcalmsky.leetcode.find_eventual_safe_states;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        byte[] visited = new byte[graph.length];
        for (int i = 0; i < graph.length; i++) if (dfs(graph, i, visited)) result.add(i);
        return result;
    }

    private boolean dfs(int[][] graph, int index, byte[] visited) {
        if (visited[index] == -1) return false;
        if (visited[index] == 1) return true;

        visited[index] = -1;
        for (int neighbor : graph[index]) if (!dfs(graph, neighbor, visited)) return false;
        visited[index] = 1;
        return true;
    }
}

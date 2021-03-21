package io.lcalmsky.leetcode.shortest_path_visiting_all_nodes;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n <= 1) return 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }
        int target = (1 << n) - 1;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int position = current[0], state = current[1];
                for (int neigh : graph[position]) {
                    int nextState = state | (1 << neigh);
                    if (nextState == target) return step + 1;
                    if (visited[neigh][nextState]) continue;
                    visited[neigh][nextState] = true;
                    queue.offer(new int[]{neigh, state | (1 << neigh)});
                }
            }
            step++;
        }
        return -1;
    }
}

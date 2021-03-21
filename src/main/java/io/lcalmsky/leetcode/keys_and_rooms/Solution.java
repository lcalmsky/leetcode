package io.lcalmsky.leetcode.keys_and_rooms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        int numberOfRooms = rooms.size();
        boolean[] visited = new boolean[numberOfRooms];
        for (int key : rooms.get(0)) keys.offer(key);
        visited[0] = true;
        int visitedRooms = 1;
        while (!keys.isEmpty()) {
            int key = keys.poll();
            if (!visited[key]) {
                visited[key] = true;
                List<Integer> room = rooms.get(key);
                visitedRooms++;
                for (int k : room) keys.offer(k);
            }
        }

        return visitedRooms == numberOfRooms;
    }
}

package io.lcalmsky.leetcode.race_car;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int raceCar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        visited.add("0_1");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int pos = cur[0];
                int speed = cur[1];
                if (pos == target) return step;
                // A
                int pos1 = pos + speed;
                int speed1 = speed * 2;
                queue.offer(new int[]{pos1, speed1});
                // R
                int speed2 = speed > 0 ? -1 : 1;
                if (visited.add(pos + "_" + speed2)) {
                    queue.offer(new int[]{pos, speed2});
                }
            }
            step++;
        }
        return -1;
    }
}

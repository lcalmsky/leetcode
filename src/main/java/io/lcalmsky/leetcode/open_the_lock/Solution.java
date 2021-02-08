package io.lcalmsky.leetcode.open_the_lock;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target) || deadSet.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return step;
                for (int pos = 0; pos < 4; pos++) {
                    char[] chars = curr.toCharArray();
                    chars[pos] = (char) ((chars[pos] + 11 - '0') % 10 + '0');
                    String nextString = String.valueOf(chars);
                    if (!visited.contains(nextString) && !deadSet.contains(nextString)) {
                        queue.offer(nextString);
                        visited.add(nextString);
                    }
                    chars[pos] = (char) ((chars[pos] + 8 - '0') % 10 + '0');
                    nextString = String.valueOf(chars);
                    if (!visited.contains(nextString) && !deadSet.contains(nextString)) {
                        queue.offer(nextString);
                        visited.add(nextString);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}

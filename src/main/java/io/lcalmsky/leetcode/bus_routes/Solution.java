package io.lcalmsky.leetcode.bus_routes;

import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int stop : route) {
                stopToRoutes.computeIfAbsent(stop, x -> new LinkedList<>()).add(i);
            }
        }
        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int times = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                for (int routeId : stopToRoutes.get(currentStop)) {
                    if (!visitedRoutes.contains(routeId)) {
                        visitedRoutes.add(routeId);
                        for (int stop : routes[routeId]) {
                            if (stop == target) {
                                return times + 1;
                            }
                            queue.offer(stop);
                        }
                    }
                }
            }
            times++;
        }
        return -1;
    }
}
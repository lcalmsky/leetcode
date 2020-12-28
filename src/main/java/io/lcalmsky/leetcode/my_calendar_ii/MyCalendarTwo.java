package io.lcalmsky.leetcode.my_calendar_ii;

import java.util.TreeMap;

public class MyCalendarTwo {

    private final TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int values : map.values()) {
            active += values;
            if (active >= 3) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                if (map.get(start) == 0) map.remove(start);
                return false;
            }
        }
        return true;
    }
}

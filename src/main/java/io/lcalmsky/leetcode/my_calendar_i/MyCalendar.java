package io.lcalmsky.leetcode.my_calendar_i;

import java.util.TreeMap;

class MyCalendar {

  private final TreeMap<Integer, Integer> calendar;

  public MyCalendar() {
    this.calendar = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    Integer previousStart = calendar.floorKey(start);
    Integer previousEnd = calendar.get(previousStart);
    Integer nextStart = calendar.ceilingKey(start);
    if ((previousStart == null || previousEnd <= start) && (nextStart == null || end <= nextStart)) {
      calendar.put(start, end);
      return true;
    }
    return false;
  }
}
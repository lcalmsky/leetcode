package io.lcalmsky.leetcode.my_calendar_i;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyCalendarTest {

  @Test
  void test() {
    MyCalendar myCalendar = new MyCalendar();
    assertTrue(myCalendar.book(10, 20));
    assertFalse(myCalendar.book(15, 25));
    assertTrue(myCalendar.book(20, 30));
  }
}
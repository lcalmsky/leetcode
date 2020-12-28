package io.lcalmsky.leetcode.my_calendar_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCalendarTwoTest {
    @Test
    public void givenSchedules_whenAddToCalendar_thenCorrect() {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        assertTrue(myCalendarTwo.book(10, 20));
        assertTrue(myCalendarTwo.book(50, 60));
        assertTrue(myCalendarTwo.book(10, 40));
        assertFalse(myCalendarTwo.book(5, 15));
        assertTrue(myCalendarTwo.book(5, 10));
        assertTrue(myCalendarTwo.book(25, 55));
    }
}

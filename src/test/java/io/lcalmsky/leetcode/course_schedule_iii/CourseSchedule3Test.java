package io.lcalmsky.leetcode.course_schedule_iii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseSchedule3Test {
    @Test
    public void givenCourses_whenFindMaximalNumberOfCoursesCanBeTaken_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {100, 200},
                        {200, 1300},
                        {1000, 1250},
                        {2000, 3200}
                }, 3)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution courseSchedule3 = new Solution();
        int actual = courseSchedule3.scheduleCourse(given);

        // then
        assertEquals(expected, actual);
    }
}

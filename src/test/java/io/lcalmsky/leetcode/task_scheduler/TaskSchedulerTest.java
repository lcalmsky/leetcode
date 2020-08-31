package io.lcalmsky.leetcode.task_scheduler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskSchedulerTest {
    @Test
    public void givenTasks_whenSchedule_thenCorrect() {
        assertAll(
                () -> test(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8),
                () -> test(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0, 6),
                () -> test(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2, 16)
        );
    }

    private void test(char[] given, int n, int expected) {
        // when
        TaskScheduler taskScheduler = new TaskScheduler();
        int actual = taskScheduler.leastInterval(given, n);

        // then
        assertEquals(expected, actual);
    }
}
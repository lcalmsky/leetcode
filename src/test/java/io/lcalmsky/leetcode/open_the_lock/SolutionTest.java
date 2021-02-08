package io.lcalmsky.leetcode.open_the_lock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenDeadEndsAndTargetNumber_whenFindStepToUnLock_thenCorrect() {
        assertAll(
                () -> test(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
                () -> test(new String[]{"8888"}, "0009", 1),
                () -> test(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888", -1),
                () -> test(new String[]{"0000"}, "8888", -1)
        );
    }

    private void test(String[] deadends, String target, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.openLock(deadends, target);

        // then
        assertEquals(expected, actual);
    }
}
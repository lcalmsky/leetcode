package io.lcalmsky.leetcode.robot_return_to_origin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotReturnToOriginTest {
    @Test
    public void givenString_whenMakeSureTheRobotReturnsToItsPlace_thenCorrect() {
        assertAll(
                () -> test("UD", true),
                () -> test("LL", false),
                () -> test("RRDD", false),
                () -> test("LDRRLRUULR", false)
        );
    }

    private void test(String given, boolean expected) {
        // when
        Solution robotReturnToOrigin = new Solution();
        boolean actual = robotReturnToOrigin.judgeCircle(given);

        // then
        assertEquals(expected, actual);
    }
}

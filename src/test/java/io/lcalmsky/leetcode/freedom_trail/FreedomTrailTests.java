package io.lcalmsky.leetcode.freedom_trail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreedomTrailTests {
    @Test
    public void givenRingAndKey_whenFindRotateSteps_thenCorrect() {
        assertAll(
                () -> test("godding", "gd", 4)
        );
    }

    private void test(String ring, String key, int expected) {
        // when
        FreedomTrail freedomTrail = new FreedomTrail();
        int actual = freedomTrail.findRotateSteps(ring, key);

        // then
        assertEquals(expected, actual);
    }
}

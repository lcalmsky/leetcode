package io.lcalmsky.leetcode.keys_and_rooms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenRoomsAndKeys_whenWalkBetweenRooms_thenEnterEveryRoom() {
        assertAll(
                () -> test(Arrays.asList(
                        Collections.singletonList(1),
                        Collections.singletonList(2),
                        Collections.singletonList(3),
                        Collections.emptyList()
                ), true),
                () -> test(Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(3, 0, 1),
                        Collections.singletonList(2),
                        Collections.singletonList(0)
                ), false)
        );
    }

    private void test(List<List<Integer>> given, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.canVisitAllRooms(given);

        // then
        assertEquals(expected, actual);
    }
}

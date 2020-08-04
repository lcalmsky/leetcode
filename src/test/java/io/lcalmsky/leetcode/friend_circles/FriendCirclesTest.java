package io.lcalmsky.leetcode.friend_circles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FriendCirclesTest {
    @Test
    public void givenMatrix_whenFindFriendCircles_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }, 2),
                () -> test(new int[][]{
                        {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}
                }, 1)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        FriendCircles friendCircles = new FriendCircles();
        int actual = friendCircles.findCircleNum(given);

        // then
        assertEquals(expected, actual);
    }
}
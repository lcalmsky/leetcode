package io.lcalmsky.leetcode.knight_probability_in_chessboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightProbabilityInChessboardTest {
    @Test
    public void givenChessBoardSizeAndKMovesAndXY_whenFindProbability_thenCorrect() {
        assertAll(
                () -> test(3, 2, 0, 0, 0.0625)
        );
    }

    private void test(int n, int k, int x, int y, double expected) {
        // when
        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        double actual = knightProbabilityInChessboard.knightProbability(3, 2, 0, 0);

        // then
        assertEquals(expected, actual);
    }

}
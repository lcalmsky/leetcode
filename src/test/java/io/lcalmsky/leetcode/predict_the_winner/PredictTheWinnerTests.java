package io.lcalmsky.leetcode.predict_the_winner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredictTheWinnerTests {
    @Test
    public void givenArray_whenPredictTheWinner_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 5, 2}, false),
                () -> test(new int[]{1, 5, 233, 7}, true)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        Solution predictTheWinner = new Solution();
        boolean actual = predictTheWinner.predictTheWinner(given);

        // then
        assertEquals(expected, actual);
    }
}

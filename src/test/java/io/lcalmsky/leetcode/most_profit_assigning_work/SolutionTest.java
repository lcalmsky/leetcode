package io.lcalmsky.leetcode.most_profit_assigning_work;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenWorks_whenGetMostProfit_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}, 100)
        );
    }

    private void test(int[] difficulty, int[] profit, int[] worker, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxProfitAssignment(difficulty, profit, worker);

        // then
        assertEquals(expected, actual);
    }
}

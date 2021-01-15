package io.lcalmsky.leetcode.evaluate_division;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EvaluateDivisionTests {
    @Test
    public void givenEquationsValuesQueries_whenFindAnswer_thenCorrect() {
        assertAll(
                () -> test(
                        Arrays.asList(
                                Arrays.asList("a", "b"),
                                Arrays.asList("b", "c")),
                        new double[]{2.0, 3.0},
                        Arrays.asList(
                                Arrays.asList("a", "c"),
                                Arrays.asList("b", "a"),
                                Arrays.asList("a", "e"),
                                Arrays.asList("a", "a"),
                                Arrays.asList("x", "x")
                        ),
                        new double[]{6.0, 0.5, -1.0, 1.0, -1.0})
        );
    }

    private void test(List<List<String>> equations, double[] values, List<List<String>> queries, double[] expected) {
        // when
        Solution evaluateDivision = new Solution();
        double[] actual = evaluateDivision.calcEquation(equations, values, queries);

        // then
        assertArrayEquals(expected, actual);
    }
}

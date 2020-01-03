package io.lcalmsky.leetcode.pascals_triangle_ii;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PascalsTriangle2Tests {
    @Test
    public void givenIndex_whenGetARowFromPascalsTriangle_thenCorrect() {
        assertAll(
                () -> test(3, Arrays.asList(1, 3, 3, 1))
        );
    }

    private void test(int given, List<Integer> expected) {
        // when
        PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
        List<Integer> actual = pascalsTriangle2.getRow(given);

        // then
        assertEquals(expected, actual);
    }
}

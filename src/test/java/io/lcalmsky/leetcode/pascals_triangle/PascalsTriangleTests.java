package io.lcalmsky.leetcode.pascals_triangle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PascalsTriangleTests {
    @Test
    public void givenNumber_whenGeneratePascalsTriangle_thenCorrect() {
        assertAll(
                () -> test(5, Arrays.asList(
                        Collections.singletonList(1),
                        Arrays.asList(1, 1),
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(1, 3, 3, 1),
                        Arrays.asList(1, 4, 6, 4, 1)
                ))
        );
    }

    private void test(int given, List<List<Integer>> expected) {
        // when
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> actual = pascalsTriangle.generate(given);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}

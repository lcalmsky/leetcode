package io.lcalmsky.leetcode.combinations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

public class CombinationsTests {

    @Test
    public void givenN_whenCombineKNumbers_thenCorrect() {
        assertAll(
                () -> test(4, 2, Arrays.asList(
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 4),
                        Arrays.asList(2, 3),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 3),
                        Arrays.asList(1, 4)
                ))
        );
    }

    private void test(int givenN, int givenK, List<List<Integer>> expected) {
        // when
        Combinations combinations = new Combinations();
        List<List<Integer>> actual = combinations.combine(givenN, givenK);

        // then
        Assertions.assertThat(actual).containsAll(expected);
    }
}

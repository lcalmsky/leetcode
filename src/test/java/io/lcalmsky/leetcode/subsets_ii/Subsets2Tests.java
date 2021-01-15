package io.lcalmsky.leetcode.subsets_ii;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Subsets2Tests {

    @Test
    public void givenNumbers_whenGetSubsetsWithDuplicates_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 2}, Arrays.asList(
                        Collections.singletonList(2),
                        Collections.singletonList(1),
                        Arrays.asList(1, 2, 2),
                        Arrays.asList(2, 2),
                        Arrays.asList(1, 2),
                        Collections.emptyList()
                ))
        );
    }

    private void test(int[] given, List<List<Integer>> expected) {
        // when
        Solution subsets2 = new Solution();
        List<List<Integer>> actual = subsets2.subsetsWithDup(given);

        // then
        assertThat(actual).containsAnyElementsOf(expected);
    }
}

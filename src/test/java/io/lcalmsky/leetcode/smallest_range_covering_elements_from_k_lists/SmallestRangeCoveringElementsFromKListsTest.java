package io.lcalmsky.leetcode.smallest_range_covering_elements_from_k_lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestRangeCoveringElementsFromKListsTest {
    @Test
    public void givenKLists_whenFindSmallestRangeIncludesAtLeastOneNumberFromEachOfKLists_thenCorrect() {
        assertAll(
                () -> test(
                        Arrays.asList(
                                Arrays.asList(4, 10, 15, 24, 26),
                                Arrays.asList(0, 9, 12, 20),
                                Arrays.asList(5, 18, 22, 30)
                        ),
                        new int[]{20, 24}),
                () -> test(
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(1, 2, 3)
                        ),
                        new int[]{1}
                ),
                () -> test(
                        Arrays.asList(
                                Arrays.asList(10, 10),
                                Arrays.asList(11, 11)
                        ),
                        new int[]{10, 11}
                ),
                () -> test(
                        Arrays.asList(
                                Collections.singletonList(10),
                                Collections.singletonList(11)
                        ),
                        new int[]{10, 11}
                ),
                () -> test(
                        Arrays.asList(
                                Collections.singletonList(1),
                                Collections.singletonList(2),
                                Collections.singletonList(3),
                                Collections.singletonList(4),
                                Collections.singletonList(5),
                                Collections.singletonList(6),
                                Collections.singletonList(7)
                        ),
                        new int[]{1, 2, 3, 4, 5, 6, 7}
                )
        );
    }

    private void test(List<List<Integer>> given, int[] expected) {
        //when
        SmallestRangeCoveringElementsFromKLists smallestRangeCoveringElementsFromKLists = new SmallestRangeCoveringElementsFromKLists();
        int[] actual = smallestRangeCoveringElementsFromKLists.smallestRange(given);

        // then
        assertEquals(expected, actual);
    }

}
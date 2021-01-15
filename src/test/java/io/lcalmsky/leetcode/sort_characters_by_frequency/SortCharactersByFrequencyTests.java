package io.lcalmsky.leetcode.sort_characters_by_frequency;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortCharactersByFrequencyTests {
    @Test
    public void givenString_whenSortByFrequency_thenCorrect() {
        assertAll(
                () -> test("tree", "eert"),
                () -> test("cccaaa", "cccaaa", "aaaccc"),
                () -> test("Aabb", "bbAa")
        );
    }

    private void test(String given, String... expected) {
        // when
        Solution sortCharactersByFrequency = new Solution();
        String actual = sortCharactersByFrequency.frequencySort(given);

        // then
        assertTrue(Arrays.asList(expected).contains(actual));
    }
}

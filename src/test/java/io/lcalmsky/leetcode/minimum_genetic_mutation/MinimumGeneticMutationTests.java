package io.lcalmsky.leetcode.minimum_genetic_mutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumGeneticMutationTests {
    @Test
    public void givenGeneStrings_whenMutate_thenCorrectMinimally() {
        assertAll(
                () -> test("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}, 1),
                () -> test("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}, 2),
                () -> test("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}, 3)
        );
    }

    private void test(String start, String end, String[] bank, int expected) {
        // when
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        int actual = minimumGeneticMutation.minMutation(start, end, bank);

        // then
        assertEquals(expected, actual);
    }
}

package io.lcalmsky.leetcode.permutation_sequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationSequenceTests {

    @Test
    public void givenInteger_whenGetPermutation_thenCorrect() {
        Assertions.assertAll(
                () -> test(3, 3, "213"),
                () -> test(4, 9, "2314")
        );
    }

    private void test(int givenN, int givenK, String expected) {
        // when
        PermutationSequence permutationSequence = new PermutationSequence();
        String actual = permutationSequence.getPermutation(givenN, givenK);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}

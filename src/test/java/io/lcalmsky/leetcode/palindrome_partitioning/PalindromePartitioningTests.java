package io.lcalmsky.leetcode.palindrome_partitioning;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromePartitioningTests {
    @Test
    public void givenString_whenGetPalindromePartition_thenCorrect() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> test("aab", Arrays.asList(
                        Arrays.asList("aa", "b"),
                        Arrays.asList("a", "a", "b")
                ))
        );
    }

    private void test(String given, List<List<String>> expected) {
        // when
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> actual = palindromePartitioning.partition(given);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}

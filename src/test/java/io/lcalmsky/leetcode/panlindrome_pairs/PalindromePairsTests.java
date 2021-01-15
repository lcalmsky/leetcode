package io.lcalmsky.leetcode.panlindrome_pairs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromePairsTests {
    @Test
    public void givenWords_whenCheckPairsArePalindrome_thenAddToList() {
        assertAll(
                () -> test(new String[]{"abcd", "dcba", "lls", "s", "sssll"}, Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0),
                        Arrays.asList(3, 2),
                        Arrays.asList(2, 4)
                )),
                () -> test(new String[]{"bat", "tab", "cat"}, Arrays.asList(
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0)
                ))
        );
    }

    private void test(String[] given, List<List<Integer>> expected) {
        // when
        Solution palindromePairs = new Solution();
        List<List<Integer>> actual = palindromePairs.palindromePairs(given);

        // then
        assertEquals(expected, actual);
    }
}

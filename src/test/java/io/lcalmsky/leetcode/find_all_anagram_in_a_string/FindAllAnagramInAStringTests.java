package io.lcalmsky.leetcode.find_all_anagram_in_a_string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllAnagramInAStringTests {
    @Test
    public void givenTwoStrings_whenFindAnagram_thenCorrect() {
        assertAll(
                () -> test("cbaebabacd", "abc", Arrays.asList(0, 6)),
                () -> test("abab", "ab", Arrays.asList(0, 1, 2))
        );
    }

    private void test(String s, String p, List<Integer> expected) {
        // when
        FindAllAnagramInAString findAllAnagramInAString = new FindAllAnagramInAString();
        List<Integer> actual = findAllAnagramInAString.findAnagrams(s, p);

        // then
        assertEquals(expected, actual);
    }
}

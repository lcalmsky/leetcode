package io.lcalmsky.leetcode.group_anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"))),
                () -> test(new String[]{""}, List.of(List.of(""))),
                () -> test(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    private void test(String[] strs, List<List<String>> expected) {
        // when
        Solution solution = new Solution();
        List<List<String>> actual = solution.groupAnagrams(strs);
        // then
        assertTrue(actual.stream().flatMap(List::stream).collect(Collectors.toList())
                .containsAll(expected.stream().flatMap(List::stream).collect(Collectors.toList())));
    }
}
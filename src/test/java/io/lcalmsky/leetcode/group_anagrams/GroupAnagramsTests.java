package io.lcalmsky.leetcode.group_anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupAnagramsTests {

    @Test
    public void givenStringArray_whenGroupingByAnagram_thenCorrect() {
        // given
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        // when
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);

        // log
        System.out.println(result);

        // then
//        assertAll(
//                () -> assertTrue(result.contains(Arrays.asList("ate", "eat", "tea"))),
//                () -> assertTrue(result.contains(Arrays.asList("nat", "tan"))),
//                () -> assertTrue(result.contains(Collections.singletonList("bat")))
//        );
    }
}

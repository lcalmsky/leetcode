package io.lcalmsky.leetcode.replace_words;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceWordsTest {
    @Test
    public void givenDictionary_whenReplaceWords_thenCorrect() {
        assertAll(
                () -> test(
                        Arrays.asList("cat", "bat", "rat"),
                        "the cattle was rattled by the battery",
                        "the cat was rat by the bat"),
                () -> test(
                        Arrays.asList("a", "b", "c"),
                        "aadsfasf absbs bbab cadsfafs",
                        "a a b c"),
                () -> test(
                        Arrays.asList("a", "aa", "aaa", "aaaa"),
                        "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa",
                        "a a a a a a a a bbb baba a"),
                () -> test(
                        Arrays.asList("catt", "cat", "bat", "rat"),
                        "the cattle was rattled by the battery",
                        "the cat was rat by the bat"),
                () -> test(
                        Arrays.asList("ac", "ab"),
                        "it is abnormal that this solution is accepted",
                        "it is ab that this solution is ac")
        );
    }

    private void test(List<String> dictionary, String sentence, String expected) {
        // when
        Solution replaceWords = new Solution();
        String actual = replaceWords.replaceWords(dictionary, sentence);

        // then
        assertEquals(expected, actual);
    }
}

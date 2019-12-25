package io.lcalmsky.leetcode.word_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearchTests {
    @Test
    public void givenCharacters_whenSearchWord_thenCorrect() {
        char[][] givenArray = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertAll(
                () -> test(givenArray, "ABCCED", true),
                () -> test(givenArray, "SEE", true),
                () -> test(givenArray, "ABCB", false),
                () -> test(new char[][]{
                        {'a'}
                }, "a", true),
                () -> test(new char[][]{
                        {'a', 'b'},
                        {'c', 'd'}
                }, "abcd", false)
        );

    }

    private void test(char[][] givenArray, String givenWord, boolean expected) {
        // when
        WordSearch wordSearch = new WordSearch();
        boolean actual = wordSearch.exist(givenArray, givenWord);

        // then
        assertEquals(expected, actual);
    }
}
package io.lcalmsky.leetcode.top_k_frequent_words;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TopKFrequentWordsTest {
    @Test
    public void givenWords_whenFindKMostFrequentElements_thenCorrect() {
        assertAll(
                () -> test(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2, Arrays.asList("i", "love")),
                () -> test(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4, Arrays.asList("the", "is", "sunny", "day"))
        );
    }

    private void test(String[] words, int k, List<String> expected) {
        // when
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> actual = topKFrequentWords.topKFrequent(words, k);

        // then
        assertEquals(expected, actual);
    }

}
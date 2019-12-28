package io.lcalmsky.leetcode.letter_combinations_of_a_phone_number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LetterCombinationsOfAPhoneNumberTests {

    @Test
    public void givenLetters_whenGetCombinationOfPhoneNumbers_thenCorrect() {
        assertAll(
                () -> test("234", Arrays.asList("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi")),
                () -> test("", Collections.emptyList())
        );
    }

    private void test(String given, List<String> expected) {
        // when
        LetterCombinationsOfAPhoneNumbers letterCombinationsOfAPhoneNumbers = new LetterCombinationsOfAPhoneNumbers();
        List<String> actual = letterCombinationsOfAPhoneNumbers.letterCombinations(given);

        // then
        assertThat(expected).containsAll(actual);
    }
}
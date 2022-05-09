package io.lcalmsky.leetcode.letter_combinations_of_a_phone_number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenLetters_whenGetCombinationOfPhoneNumbers_thenCorrect() {
    assertAll(
        () -> test("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
        () -> test("", Collections.emptyList()),
        () -> test("234",
            List.of("adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg",
                "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg",
                "ceh", "cei", "cfg", "cfh", "cfi")),
        () -> test("2", List.of("a", "b", "c"))
    );
  }

  private void test(String given, List<String> expected) {
    // when
    Solution letterCombinationsOfAPhoneNumbers = new Solution();
    List<String> actual = letterCombinationsOfAPhoneNumbers.letterCombinations(given);

    // then
    assertThat(expected).containsAll(actual);
  }
}
package io.lcalmsky.leetcode.delete_operation_for_two_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteOperationForTwoStringsTest {
    @Test
    public void givenTwoWords_whenDeleteCharacters_thenWordsAreSame() {
        assertAll(
                () -> test("sea", "eat", 2)
        );
    }

    private void test(String s1, String s2, int expected) {
        // when
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        int actual = deleteOperationForTwoStrings.minDistance(s1, s2);

        // then
        assertEquals(expected, actual);
    }

}
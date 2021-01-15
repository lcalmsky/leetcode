package io.lcalmsky.leetcode.add_binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBinaryTests {
    @Test
    public void givenBinaryNumbers_whenAdd_thenCorrect() {
        assertAll(
                () -> test("11", "1", "100"),
                () -> test("1010", "1011", "10101"),
                () -> test("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011",
                        "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000")
        );
    }

    private void test(String givenA, String givenB, String expected) {
        // when
        Solution addBinary = new Solution();
        String actual = addBinary.addBinary(givenA, givenB);

        // then
        assertEquals(expected, actual);
    }
}

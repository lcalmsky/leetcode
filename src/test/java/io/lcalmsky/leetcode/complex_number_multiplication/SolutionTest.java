package io.lcalmsky.leetcode.complex_number_multiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenComplexes_whenMultiply_thenCorrect() {
        assertAll(
                () -> test("1+1i", "1+1i", "0+2i"),
                () -> test("1+-1i", "1+-1i", "0+-2i")
        );
    }

    private void test(String num1, String num2, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.complexNumberMultiply(num1, num2);

        // then
        assertEquals(expected, actual);
    }
}
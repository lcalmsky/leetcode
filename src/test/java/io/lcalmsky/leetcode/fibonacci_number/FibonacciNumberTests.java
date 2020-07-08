package io.lcalmsky.leetcode.fibonacci_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTests {
    @Test
    public void givenNumber_whenFindFibonacciNumber_thenCorrect() {
        assertAll(
                () -> test(2, 1),
                () -> test(3, 2),
                () -> test(4, 3),
                () -> test(30, 832040)
        );
    }

    private void test(int given, int expected) {
        // when
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int actual = fibonacciNumber.fib(given);

        // then
        assertEquals(expected, actual);
    }
}

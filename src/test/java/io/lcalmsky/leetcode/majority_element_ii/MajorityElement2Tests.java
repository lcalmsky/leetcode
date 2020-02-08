package io.lcalmsky.leetcode.majority_element_ii;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElement2Tests {
    @Test
    public void givenArray_whenFindMajorityElements_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 2, 3}, Collections.singletonList(3)),
                () -> test(new int[]{1, 1, 1, 3, 3, 2, 2, 2}, Arrays.asList(1, 2))
        );
    }

    private void test(int[] given, List<Integer> expected) {
        // when
        MajorityElement2 majorityElement2 = new MajorityElement2();
        List<Integer> actual = majorityElement2.majorityElement(given);

        // then
        assertEquals(expected, actual);
    }
}

package io.lcalmsky.leetcode.find_k_closest_elements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKClosestElementsTest {
    @Test
    public void givenArray_whenFindClosestElements_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4, 5}, 4, 3, Arrays.asList(1, 2, 3, 4)),
                () -> test(new int[]{1, 2, 3, 4, 5}, 4, -1, Arrays.asList(1, 2, 3, 4))
        );
    }

    private void test(int[] arr, int k, int x, List<Integer> expected) {
        // when
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> actual = findKClosestElements.findClosestElements(arr, k, x);

        // then
        assertEquals(expected, actual);
    }

}

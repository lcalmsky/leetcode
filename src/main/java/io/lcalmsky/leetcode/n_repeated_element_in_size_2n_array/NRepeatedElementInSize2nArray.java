package io.lcalmsky.leetcode.n_repeated_element_in_size_2n_array;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2nArray {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int value : A) if (!set.add(value)) return value;
        return -1; // unreachable
    }
}

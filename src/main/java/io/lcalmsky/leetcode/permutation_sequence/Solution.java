package io.lcalmsky.leetcode.permutation_sequence;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        int mod = IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
        StringBuilder stringBuilder = new StringBuilder();
        k--;
        int idx;
        for (int i = 0; i < n; i++) {
            mod /= (n - i);
            idx = k / mod;
            k %= mod;
            stringBuilder.append(numbers.remove(idx));
        }
        return stringBuilder.toString();
    }
}

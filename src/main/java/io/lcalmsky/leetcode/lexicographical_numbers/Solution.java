package io.lcalmsky.leetcode.lexicographical_numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 * </pre>
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(String.valueOf(i));
        numbers.sort(String::compareTo);
        return numbers.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}

package io.lcalmsky.leetcode.minimum_genetic_mutation;

import java.util.*;

/**
 * <pre>
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 *
 *
 * Example 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * return: 1
 *
 *
 * Example 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 *
 *
 * Example 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 * </pre>
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        int steps = 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        queue.offer(start);
        bankSet.remove(start);
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                char[] curr = queue.poll().toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char ori = curr[i];
                    for (char c : gene) {
                        if (c == ori) continue;
                        curr[i] = c;
                        String mutated = new String(curr);
                        if (bankSet.contains(mutated)) {
                            if (mutated.equals(end)) return steps;
                            queue.offer(mutated);
                            bankSet.remove(mutated);
                        }
                    }
                    curr[i] = ori;
                }
            }
        }
        return -1;
    }
}

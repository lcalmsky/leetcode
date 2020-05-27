package io.lcalmsky.leetcode.minimum_genetic_mutation;

import java.util.LinkedList;
import java.util.Queue;

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
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        int count = 0;
        if (start.length() != end.length()) return -1;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Queue<String> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                String tmp = q.poll();
                if (tmp.equals(end)) return count;
                for (String s : bank) {
                    if (mutation(tmp, s) == 1) {
                        temp.add(s);
                    }
                }
            }
            q = temp;
            count++;
        }
        return -1;
    }

    public int mutation(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) if (s1.charAt(i) != s2.charAt(i)) count++;
        return count;
    }
}

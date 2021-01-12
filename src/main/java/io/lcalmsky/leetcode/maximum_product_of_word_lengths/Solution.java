package io.lcalmsky.leetcode.maximum_product_of_word_lengths;

import java.util.Arrays;

/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 */
public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        int[] marks = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            char[] array = words[i].toCharArray();
            for (char c : array) marks[i] |= 1 << (c - 'a');
        }
        for (int i = 0; i < marks.length; i++) {
            if (words[i].length() * words[i].length() <= max) break;
            for (int j = i + 1; j < marks.length; ++j) {
                if ((marks[j] & marks[i]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().maxProduct(new String[]{"abcw"});
    }
}

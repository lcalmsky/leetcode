package io.lcalmsky.leetcode.panlindrome_pairs;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * </pre>
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                addListIfPalindrome(results, j, list, i, combineWord(words[i], words[j]));
                addListIfPalindrome(results, i, list, j, combineWord(words[j], words[i]));
            }
        }

        return results;
    }

    private void addListIfPalindrome(List<List<Integer>> results, int i, List<Integer> list, int j, String word) {
        if (isPalindrome(word)) {
            list.add(j);
            list.add(i);
            results.add(new ArrayList<>(list));
            list.clear();
        }
    }

    private String combineWord(String word1, String word2) {
        return String.format("%s%s", word1, word2);
    }

    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) return false;
        }
        return true;
    }
}

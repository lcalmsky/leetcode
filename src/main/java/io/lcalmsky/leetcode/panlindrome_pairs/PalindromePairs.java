package io.lcalmsky.leetcode.panlindrome_pairs;

import java.util.*;

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
        if (words == null || words.length < 2) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int k = 0; k <= s.length(); k++) {
                String left = s.substring(0, k);
                String right = s.substring(k);
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversedRight) && map.get(reversedRight) != i) {
                        List<Integer> l = new ArrayList<>();
                        l.add(map.get(reversedRight));
                        l.add(i);
                        result.add(l);
                    }
                }
                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft)
                            && map.get(reversedLeft) != i
                            && right.length() != 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(i);
                        l.add(map.get(reversedLeft));
                        result.add(l);
                    }
                }
            }
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) if (s.charAt(i++) != s.charAt(j--)) return false;

        return true;
    }
}

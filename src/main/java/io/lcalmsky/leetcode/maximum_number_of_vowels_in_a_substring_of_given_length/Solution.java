package io.lcalmsky.leetcode.maximum_number_of_vowels_in_a_substring_of_given_length;

import java.util.Set;

public class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (VOWELS.contains(charArray[i])) {
                currentVowels++;
            }
            int diff = (i + 1) - k;
            if (diff >= 0) {
                maxVowels = Math.max(maxVowels, currentVowels);
                if (VOWELS.contains(charArray[diff])) {
                    currentVowels--;
                }
            }
        }
        return maxVowels;
    }
}

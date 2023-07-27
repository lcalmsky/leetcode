package io.lcalmsky.leetcode.maximum_number_of_vowels_in_a_substring_of_given_length;

public class Solution2 {
    public int maxVowels(String s, int k) {
        int[] vowels = new int[26];
        vowels[0] = 1;
        vowels['e' - 'a'] = 1;
        vowels['i' - 'a'] = 1;
        vowels['o' - 'a'] = 1;
        vowels['u' - 'a'] = 1;
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            vowelCount += vowels[s.charAt(i) - 'a'];
        }
        int maxVowels = vowelCount;
        for (int i = k; i < s.length(); i++) {
            vowelCount += vowels[s.charAt(i) - 'a'] - vowels[s.charAt(i - k) - 'a'];
            maxVowels = Math.max(maxVowels, vowelCount);
            if (maxVowels == k) {
                return maxVowels;
            }
        }
        return maxVowels;
    }
}

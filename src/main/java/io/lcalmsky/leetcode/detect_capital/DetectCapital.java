package io.lcalmsky.leetcode.detect_capital;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            word = word.substring(1);
            return word.toUpperCase().equals(word) || word.toLowerCase().equals(word);
        }
        return word.toLowerCase().equals(word);
    }
}
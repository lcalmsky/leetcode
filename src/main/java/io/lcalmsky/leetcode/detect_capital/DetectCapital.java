package io.lcalmsky.leetcode.detect_capital;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.toUpperCase().equals(word) || word.toLowerCase().equals(word) || (Character.isUpperCase(word.charAt(0)) && word.substring(1).toLowerCase().equals(word.substring(1)));
    }
}
package io.lcalmsky.leetcode.wildcard_matching;

public class WildcardMatchingTests {
    public static void main(String[] args) {
        WildcardMatchingTests wildcardMatchingTests = new WildcardMatchingTests();
        System.out.println(wildcardMatchingTests.isMatch("aa", "a"));
        System.out.println(wildcardMatchingTests.isMatch("aa", "*"));
        System.out.println(wildcardMatchingTests.isMatch("cb", "?a"));
        System.out.println(wildcardMatchingTests.isMatch("adceb", "*a*b"));
        System.out.println(wildcardMatchingTests.isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;
                ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }

        return j == p.length();
    }
}

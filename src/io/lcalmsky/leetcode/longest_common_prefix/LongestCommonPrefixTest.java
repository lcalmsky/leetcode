package io.lcalmsky.leetcode.longest_common_prefix;

public class LongestCommonPrefixTest {

    public static void main(String[] args) {
        LongestCommonPrefixTest longestCommonPrefixTest = new LongestCommonPrefixTest();
        System.out.println(longestCommonPrefixTest.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefixTest.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) return "";

        StringBuilder sb = new StringBuilder();

        int min = 0;
        for (int i = 0; i < strs.length; i++) {
            if ((min = Math.min(strs[i].length(), min)) == 0) return "";
        }


        for (int i = 0; i < min; i ++){
            for (int j = 0; j < strs.length; j++){

            }
        }

        return sb.toString();
    }
}

package io.lcalmsky.leetcode.longest_common_prefix;

public class LongestCommonPrefixTest {

    public static void main(String[] args) {
        LongestCommonPrefixTest longestCommonPrefixTest = new LongestCommonPrefixTest();
        System.out.println(longestCommonPrefixTest.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefixTest.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length < 2) return strs[0];

        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if ((min = Math.min(strs[i].length(), min)) == 0) return "";
        }

        boolean flag = false;
        char c = 0;
        for (int i = 0; i < min; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (flag = !(c == strs[j].charAt(i))) break;
            }
            if (!flag) sb.append(c);
            else break;
        }

        return sb.toString();
    }
}

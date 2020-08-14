package io.lcalmsky.leetcode.reverse_words_in_a_string_iii;

import java.util.StringTokenizer;

/**
 * <pre>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * </pre>
 */
public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
        }

        String result = sb.toString();

        return result.length() == s.length() ? result : result.substring(0, result.length() - 1);
    }
}

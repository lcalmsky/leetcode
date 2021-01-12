package io.lcalmsky.leetcode.zigzag_conversion;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        int k, step1, step2;
        boolean flag;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    sb.append(s.charAt(j));
                }
            } else {
                k = i;
                flag = true;
                step1 = 2 * (numRows - 1 - i);
                step2 = step - step1;
                while (k < s.length()) {
                    sb.append(s.charAt(k));
                    if (flag) k = k + step1;
                    else k = k + step2;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }
}

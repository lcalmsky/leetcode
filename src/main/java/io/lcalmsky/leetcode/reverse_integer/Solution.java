package io.lcalmsky.leetcode.reverse_integer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(reverseInteger.reverse(123));
//        System.out.println(reverseInteger.reverse(-123));
//        System.out.println(reverseInteger.reverse(120));
        System.out.println(solution.reverse(1534236469));

    }

    public int reverse(int x) {
        String s = String.valueOf(Math.abs(x));
        int len = s.length();
        double result = 0;
        for (int i = 0; i < len; i++) {
            result += (int) (x % 10 * Math.pow(10, len - i - 1));
            x /= 10;
        }
        return result == (int) result ? (int) result : 0;
    }
}

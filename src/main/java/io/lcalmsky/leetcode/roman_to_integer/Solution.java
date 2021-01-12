package io.lcalmsky.leetcode.roman_to_integer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));

    }

    public int romanToInt(String roman) {
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // C X I 일 때 다음 character 확인
        int result = 0;
        int offset = 0;
        for (int i = 0; i < romans.length; i++) {
            while (roman.startsWith(romans[i], offset)) {
                result += ints[i];
                offset += romans[i].length();
            }
        }

        return result;
    }
//    public int romanToInt(String roman) {
//        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//
//        // C X I 일 때 다음 character 확인
//        int result = 0;
//        for (int i = 0; i < romans.length; i++) {
//            while (roman.startsWith(romans[i])) {
//                result += ints[i];
//                roman = roman.substring(romans[i].length());
//            }
//        }
//
//        return result;
//    }
}

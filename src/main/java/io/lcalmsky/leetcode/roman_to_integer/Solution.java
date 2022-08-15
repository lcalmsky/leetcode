package io.lcalmsky.leetcode.roman_to_integer;

public class Solution {

  private static final String[] ROMANS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL",
      "X", "IX", "V", "IV", "I"};
  private static final int[] VALUES = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
      1};

  public int romanToInt(String roman) {
    int result = 0;
    int offset = 0;
    for (int i = 0; i < ROMANS.length; i++) {
      while (roman.startsWith(ROMANS[i], offset)) {
        result += VALUES[i];
        offset += ROMANS[i].length();
      }
    }
    return result;
  }
}

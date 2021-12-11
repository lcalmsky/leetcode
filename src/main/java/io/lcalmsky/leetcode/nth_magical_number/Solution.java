package io.lcalmsky.leetcode.nth_magical_number;

public class Solution {

  private static final int MODULO = 1000000007;

  public int nthMagicalNumber(int n, int a, int b) {
    long lcm = (long) a * b / gcd(a, b);
    long left = 0, right = (long) n * a * b;
    while (left + 1 < right) {
      long mid = (left + right) / 2;
      long magicalNumber = mid / a + mid / b - mid / lcm;
      if (magicalNumber >= n) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return (int) (right % MODULO);
  }

  private int gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }
}
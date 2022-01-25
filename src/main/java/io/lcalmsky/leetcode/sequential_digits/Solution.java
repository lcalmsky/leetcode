package io.lcalmsky.leetcode.sequential_digits;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> sequentialDigits(int low, int high) {
    String digits = "123456789";
    List<Integer> result = new ArrayList<>();
    int lowLength = String.valueOf(low).length();
    int highLength = String.valueOf(high).length();
    for (int i = lowLength; i <= highLength; i++) {
      for (int j = 0; j < 10 - i; j++) {
        int num = Integer.parseInt(digits.substring(j, j + i));
        if (num >= low && num <= high) {
          result.add(num);
        }
      }
    }
    return result;
  }
}

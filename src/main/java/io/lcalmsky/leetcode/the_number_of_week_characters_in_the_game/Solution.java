package io.lcalmsky.leetcode.the_number_of_week_characters_in_the_game;

import java.util.Arrays;

public class Solution {

  public int numberOfWeakCharacters(int[][] properties) {
    Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
    for (int[] property : properties) {
      System.out.println(Arrays.toString(property));
    }
    System.out.println();
    int maxDefence = 0;
    int count = 0;
    for (int[] property : properties) {
      if (property[1] < maxDefence) {
        count++;
        continue;
      }
      maxDefence = property[1];
    }
    return count;
  }
}

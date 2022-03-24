package io.lcalmsky.leetcode.boats_to_save_people;

import java.util.Arrays;

public class Solution {

  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int count = 0, left = 0, right = people.length - 1;
    while (left <= right) {
      if (people[left] + people[right] <= limit) {
        left++;
      }
      right--;
      count++;
    }
    return count;
  }
}

package io.lcalmsky.leetcode.pairs_of_songs_with_total_durations_divisible_by_60;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numPairsDivisibleBy60(int[] time) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int t : time) {
      int duration = (60 - t % 60) % 60;
      if (map.containsKey(duration)) {
        result += map.get(duration);
      }
      map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
    }
    return result;
  }
}

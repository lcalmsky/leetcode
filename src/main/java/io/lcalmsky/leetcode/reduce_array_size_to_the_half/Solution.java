package io.lcalmsky.leetcode.reduce_array_size_to_the_half;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {

  public int minSetSize(int[] arr) {
    Map<Integer, Integer> frequencies = new HashMap<>();
    for (int element : arr) {
      frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
    }
    List<Entry<Integer, Integer>> sortedEntries = frequencies.entrySet().stream()
        .sorted((a, b) -> b.getValue() - a.getValue())
        .collect(Collectors.toUnmodifiableList());
    int count = 0;
    int index = 0;
    while (count * 2 < arr.length) {
      count = count + sortedEntries.get(index).getValue();
      index++;
    }
    return index;
  }
}
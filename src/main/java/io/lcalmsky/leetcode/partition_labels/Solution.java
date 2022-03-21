package io.lcalmsky.leetcode.partition_labels;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<Integer> partitionLabels(String S) {
    List<Integer> result = new LinkedList<>();
    char[] array = S.toCharArray();
    int length = array.length;
    int[] lastIndices = new int[26];
    for (int i = 0; i < length; i++) {
      lastIndices[array[i] - 'a'] = i;
    }
    int max = lastIndices[array[0] - 'a'];
    int s = 0;
    for (int i = 0; i < length; i++) {
      if (i == max) {
        result.add(max - s + 1);
        s = max + 1;
        if (i + 1 < length) {
          max = lastIndices[array[i + 1] - 'a'];
        }
      } else {
        max = Math.max(lastIndices[array[i] - 'a'], max);
      }
    }
    return result;
  }
}

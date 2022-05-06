package io.lcalmsky.leetcode.remove_all_adjacent_duplicates_in_string_ii;

import java.util.Stack;

public class Solution {

  public String removeDuplicates(String s, int k) {
    Stack<CharacterWithFrequency> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek().c == ch) {
        stack.peek().frequency++;
      } else {
        stack.push(new CharacterWithFrequency(ch, 1));
      }
      if (stack.peek().frequency == k) {
        stack.pop();
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) {
      CharacterWithFrequency popped = stack.pop();
      stringBuilder.append(String.valueOf(popped.c).repeat(Math.max(0, popped.frequency)));
    }
    return stringBuilder.reverse().toString();
  }

  private static class CharacterWithFrequency {

    char c;
    int frequency;

    public CharacterWithFrequency(char c, int frequency) {
      this.c = c;
      this.frequency = frequency;
    }
  }
}

class AnotherSolution extends Solution {

  @Override
  public String removeDuplicates(String s, int k) {
    char[] array = s.toCharArray();
    int[] duplicates = new int[array.length];
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      array[slow] = array[fast];
      duplicates[slow] = slow != 0 && array[slow - 1] == array[slow]
          ? duplicates[slow - 1] + 1
          : 1;
      if (duplicates[slow] == k) {
        slow -= k;
      }
      slow++;
      fast++;
    }
    return new String(array, 0, slow);
  }
}
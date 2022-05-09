package io.lcalmsky.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public static final String[] TABLE = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno",
      "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return Collections.emptyList();
    }
    char[] digitChars = digits.toCharArray();
    int[] numbers = new int[digitChars.length];
    for (int i = 0; i < digitChars.length; i++) {
      numbers[i] = digitChars[i] - '0';
    }
    int length = numbers.length;
    return letterCombinationsUtil(numbers, length);
  }

  public List<String> letterCombinationsUtil(int[] numbers, int length) {
    List<String> list = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    queue.add("");
    String letterCombination, letters;
    while (!queue.isEmpty()) {
      letterCombination = queue.poll();
      if (letterCombination.length() == length) {
        list.add(letterCombination);
        continue;
      }
      letters = TABLE[numbers[letterCombination.length()]];
      for (int i = 0; i < letters.length(); i++) {
        queue.add(letterCombination + letters.charAt(i));
      }
    }
    return list;
  }
}

class AnotherSolution {

  public static String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    dfs(digits, 0, new StringBuilder(), result);
    return result;
  }

  public void dfs(String digits, int index, StringBuilder stringBuilder, List<String> result) {
    if (index == digits.length()) {
      result.add(stringBuilder.toString());
      return;
    }
    String letters = TABLE[digits.charAt(index) - '0'];
    for (int i = 0; i < letters.length(); i++) {
      stringBuilder.append(letters.charAt(i));
      dfs(digits, index + 1, stringBuilder, result);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
  }
}

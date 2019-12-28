package io.lcalmsky.leetcode.letter_combinations_of_a_phone_number;

import java.util.*;

public class LetterCombinationsOfAPhoneNumbers {
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return Collections.emptyList();

        char[] digitChars = digits.toCharArray();
        int[] number = new int[digitChars.length];
        for (int i = 0; i < digitChars.length; i++) {
            number[i] = digitChars[i] - '0';
        }
        int n = number.length;

        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        return letterCombinationsUtil(number, n, table);
    }

    public List<String> letterCombinationsUtil(int[] number, int n, String[] table) {
        List<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        String s, val;
        while (!q.isEmpty()) {
            s = q.remove();

            if (s.length() == n)
                list.add(s);
            else {
                val = table[number[s.length()]];
                for (int i = 0; i < val.length(); i++) {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }
}

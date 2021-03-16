package io.lcalmsky.leetcode.push_dominoes;

public class Solution {
    public String pushDominoes(String dominoes) {
        int right = -1, left = -1;
        char[] array = dominoes.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'L') {
                if (right > left) {
                    int distance = (i - right);
                    int stand = right + distance / 2;
                    if ((distance % 2) == 0) array[stand] = '.';
                    for (int j = stand + 1; j < i; j++) array[j] = 'L';
                } else {
                    for (int j = (left == -1 ? 0 : left); j < i; j++) array[j] = 'L';
                }
                left = i;
            } else {
                if (array[i] == 'R') right = i;
                else {
                    if (right > left) array[i] = 'R';
                }
            }
        }
        return String.valueOf(array);
    }
}
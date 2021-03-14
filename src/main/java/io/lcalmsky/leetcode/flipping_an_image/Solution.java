package io.lcalmsky.leetcode.flipping_an_image;

public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            for (int start = 0, end = row.length - 1; start < end; start++, end--) {
                swap(row, start, end);
            }
        }
        for (int[] row : image) {
            for (int i = 0; i < row.length; i++) {
                inverse(row, i);
            }
        }
        return image;
    }

    private void swap(int[] row, int start, int end) {
        int tmp = row[start];
        row[start] = row[end];
        row[end] = tmp;
    }

    private void inverse(int[] row, int i) {
        row[i] ^= 1;
    }
}

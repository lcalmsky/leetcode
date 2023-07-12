package io.lcalmsky.leetcode.word_search;

public class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int count, int i, int j, boolean[][] visited) {
        if (count == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(count)) {
            return false;
        }
        visited[i][j] = true;
        boolean exist = exist(board, word, count + 1, i, j + 1, visited) ||
                exist(board, word, count + 1, i, j - 1, visited) ||
                exist(board, word, count + 1, i + 1, j, visited) ||
                exist(board, word, count + 1, i - 1, j, visited);
        visited[i][j] = false;
        return exist;
    }
}

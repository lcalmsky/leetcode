package io.lcalmsky.leetcode.word_search;

public class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int n, int i, int j) {
        if (n == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (visited[i][j])
            return false;
        if (word.charAt(n) != board[i][j])
            return false;
        visited[i][j] = true;
        boolean result = search(board, word, n + 1, i - 1, j) || search(board, word, n + 1, i + 1, j) || search(board, word, n + 1, i, j - 1) || search(board, word, n + 1, i, j + 1);
        visited[i][j] = false;
        return result;
    }
}

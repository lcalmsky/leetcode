package io.lcalmsky.leetcode.sudoku_solver;

public class SudokuSolverTests {

    public static void main(String[] args) {
        SudokuSolverTests s = new SudokuSolverTests();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        s.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%s ", board[i][j]);
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    // 중복된 숫자가 없으면
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (helper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true; //return true if all cells are checked
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 같은 열에 .이 아니고 자기 자신과 같은 숫자가 있는지 확인
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            // 같은 행에 .이 아니고 자기 자신과 같은 숫자가 있는지 확인
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            // 3x3 matrix 안에 자기 자신과 같은 숫자가 있는지 확인
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}

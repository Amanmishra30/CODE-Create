import java.util.*;

class Solution {
    private List<List<String>> result;
    private char[][] board;
    private Set<Integer> columns;
    private Set<Integer> diagonal1;
    private Set<Integer> diagonal2;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new char[n][n];

        columns = new HashSet<>();
        diagonal1 = new HashSet<>();
        diagonal2 = new HashSet<>();

        // Initialize the board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n);

        return result;
    }

    private void backtrack(int row, int n) {
        // All queens have been placed
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] currentRow : board) {
                solution.add(new String(currentRow));
            }

            result.add(solution);
            return;
        }

        // Try placing a queen in every column
        for (int col = 0; col < n; col++) {
            int diag1 = row - col;
            int diag2 = row + col;

            // Check whether the position is safe
            if (columns.contains(col)
                    || diagonal1.contains(diag1)
                    || diagonal2.contains(diag2)) {
                continue;
            }

            // Place the queen
            board[row][col] = 'Q';
            columns.add(col);
            diagonal1.add(diag1);
            diagonal2.add(diag2);

            // Move to the next row
            backtrack(row + 1, n);

            // Backtrack
            board[row][col] = '.';
            columns.remove(col);
            diagonal1.remove(diag1);
            diagonal2.remove(diag2);
        }
    }
}
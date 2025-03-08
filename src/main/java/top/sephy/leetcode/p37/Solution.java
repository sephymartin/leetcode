package top.sephy.leetcode.p37;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    static class Cell {
        int row;
        int col;
        int colFrom;
        int colTo;
        int rowFrom;
        int rowTo;
        Set<Character> availableNums;
    }

    static Set<Character> initAvailableNums() {
        Set<Character> availablSet = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            availablSet.add((char)(i + '0'));
        }
        return availablSet;
    }

    static Cell initCell(char[][] board, int row, int col) {
        Cell cell = new Cell();
        cell.row = row;
        cell.col = col;

        cell.colFrom = (col / 3) * 3;
        cell.colTo = cell.colFrom + 2;
        cell.rowFrom = (row / 3) * 3;
        cell.rowTo = cell.rowFrom + 2;

        cell.availableNums = initAvailableNums();
        return cell;
    }

    public void solveSudoku(char[][] board) {
        List<Cell> cells = new ArrayList<>();
        for (int row = 0; row < board[0].length; row++) {
            for (int col = 0; col < board.length; col++) {
                char c = board[row][col];
                if (c == '.') {
                    Cell cell = initCell(board, row, col);
                    computeAvailableNums(board, cell);
                    if (cell.availableNums.size() == 1) {
                        board[cell.row][cell.col] = cell.availableNums.iterator().next();
                    } else {
                        cells.add(cell);
                    }
                }
            }
        }

        tryToGuessCell(board, cells, 0);
    }

    boolean tryToGuessCell(char[][] board, List<Cell> cells, int index) {
        if (index >= cells.size()) {
            return true;
        }

        Cell cellToGuess = cells.get(index);
        for (Character c : cellToGuess.availableNums) {
            board[cellToGuess.row][cellToGuess.col] = c;
            // 验证通过，递归
            if (checkBoard(board, cellToGuess)) {
                if (tryToGuessCell(board, cells, index + 1)) {
                    return true;
                }
            }

            // 还原
            board[cellToGuess.row][cellToGuess.col] = '.'; // set back
        }

        return false;
    }

    boolean checkBoard(char[][] board, Cell cell) {

        // same row check
        for (int col = 0; col < board.length; col++) {
            if (col != cell.col) {
                char c = board[cell.row][col];
                if (c != '.' && c == board[cell.row][cell.col]) {
                    return false;
                }
            }
        }

        // same col check
        for (int row = 0; row < board.length; row++) {
            if (row != cell.row) {
                char c = board[row][cell.col];
                if (c != '.' && c == board[cell.row][cell.col]) {
                    return false;
                }
            }
        }

        // same box check
        for (int row = cell.rowFrom; row <= cell.rowTo; row++) {
            for (int col = cell.colFrom; col <= cell.colTo; col++) {
                if (row != cell.row && col != cell.col) {
                    char c = board[row][col];
                    if (c != '.' && c == board[cell.row][cell.col]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void computeAvailableNums(char[][] board, Cell cell) {
        Set<Character> set = cell.availableNums;
        int row = cell.row;
        int col = cell.col;

        for (int i = 0; i < board.length; i++) {
            if (col == i) {
                continue;
            }
            char c = board[row][i];
            if (c != '.') {
                // System.out.println("remove: " + c);
                set.remove(c);
                if (set.size() == 1) {
                    return;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (row == i) {
                continue;
            }
            char c = board[i][col];
            if (c != '.') {
                set.remove(c);
                if (set.size() == 1) {
                    return;
                }
            }
        }

        for (int i = cell.rowFrom; i <= cell.rowTo; i++) {
            for (int j = cell.colFrom; j < cell.colTo; j++) {
                char c = board[i][j];
                if (c != '.') {
                    set.remove(c);
                    if (set.size() == 1) {
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Solution().solveSudoku(board);
    }
}

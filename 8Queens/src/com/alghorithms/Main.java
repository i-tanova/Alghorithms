package com.alghorithms;

import javax.swing.*;

public class Main {

    static int[][] queens = new int[8][8];

    public static void main(String[] args) {
        // write your code here
        putQueens(0);
        // printQueens();
    }

    public static void putQueens(int row) {
        if (row == 8) {
            printQueens();
            return;
        }

        if (isRowAvailable(row)) {
            for (int i = 0; i < queens.length; i++) {
                if (queens[row][i] == 0) {
                    markPlacesFor(row, i);
                    putQueens(row + 1);
                    unmarkPlacesFor(row, i);
                }
            }
        }
    }

    private static void printQueens() {
        for (int[] i : queens) {
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private static void markPlacesFor(int row, int i) {
        queens[row][i] = -1;
        for (int j = 0; j < queens[row].length; j++) {
            if (j != i) {
                queens[row][j] += 1;
            }
        }

        for (int j = 0; j < queens.length; j++) {
            if (j != row) {
                queens[j][i] += 1;
            }
        }

        markDiagonalUpRight(row, i, true);
        markDiagonalDownLeft(row, i, true);
        markDiagonalDownRight(row, i, true);
        markDiagonalUpLeft(row, i, true);
    }

    private static void markDiagonalUpLeft(int row, int column, boolean mark) {
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (mark) {
                queens[i][j] += 1;
            } else {
                queens[i][j] -= 1;
            }
        }
    }


    private static void markDiagonalDownRight(int row, int column, boolean mark) {
        for (int i = row + 1, j = column + 1; i < queens.length && j < queens.length; i++, j++) {
            if (mark) {
                queens[i][j] += 1;
            } else {
                queens[i][j] -= 1;
            }
        }
    }

    private static void markDiagonalDownLeft(int row, int column, boolean mark) {
        for (int i = row + 1, j = column - 1; i < queens.length && j >= 0; i++, j--) {
            if (mark) {
                queens[i][j] += 1;
            } else {
                queens[i][j] -= 1;
            }
        }
    }

    private static void markDiagonalUpRight(int row, int column, boolean mark) {
        for (int i = row - 1, j = column + 1; i >= 0 && j < queens.length; i--, j++) {
            if (mark) {
                queens[i][j] += 1;
            } else {
                queens[i][j] -= 1;
            }
        }
    }

    private static void unmarkPlacesFor(int row, int i) {
        queens[row][i] = 0;
        for (int j = 0; j < queens[row].length; j++) {
            if (j != i) {
                queens[row][j] -= 1;
            }
        }

        for (int j = 0; j < queens.length; j++) {
            if (j != row) {
                queens[j][i] -= 1;
            }
        }

        markDiagonalUpRight(row, i, false);
        markDiagonalDownLeft(row, i, false);
        markDiagonalDownRight(row, i, false);
        markDiagonalUpLeft(row, i, false);
    }

    private static boolean isRowAvailable(int row) {
        for (int i = 0; i < queens.length; i++) {
            if (queens[row][i] == 0) {
                return true;
            }
        }

        return false;
    }
}

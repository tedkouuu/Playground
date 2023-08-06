package Recursion;

import java.util.Scanner;

public class Eight_Queens_Puzzle {

    public static char[][] board = {
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',},
            {'-', '-', '-', '-', '-', '-', '-', '-',}
    };

    public static boolean[][] freePositions = new boolean[8][8];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                freePositions[r][c] = true;
            }
        }

        findQueenPositions(0);
    }

    private static void findQueenPositions(int row) {
        if (row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 7; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositions(row);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        
    }

    private static void putQueen(int row, int col) {

    }

    private static boolean canPlaceQueen(int row, int col) {

        return freePositions[row][col];
    }

    public static void printSolution() {
        for (char[] chars : board) {
            for (char symbol : chars) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}

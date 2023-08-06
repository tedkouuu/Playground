package Recursion;

import java.util.Scanner;

public class Paths_In_Labyrinth {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPath(labyrinth, 0, 0, ' ');


    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {

        if (isInBounds(labyrinth, row, col)) {
            return;
        }

//      V - visited
        labyrinth[row][col] = 'V';

//      Down
        findPath(labyrinth, row - 1, col, 'D');

//      Up
        findPath(labyrinth, row + 1, col, 'U');

//      Left
        findPath(labyrinth, row, col - 1, 'L');

//      Right
        findPath(labyrinth, row, col + 1, 'R');

    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
    }
}
















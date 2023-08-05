package Recursion;

import java.util.Scanner;

public class Recursive_Drawing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        drawFigure(n);

    }

    public static void drawFigure(int n) {

        if (n == 0) {
            return;
        }

        print(n, "*");

        drawFigure(n - 1);

        print(n, "#");
    }

    private static void print(int n, String pattern) {
        for (int i = 0; i < n; i++) {
            System.out.print(pattern);
        }

        System.out.println();
    }
}

package Recursion;

import java.util.Scanner;

public class Fibonacci_Sequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int result = calculateFactorial(n);
        System.out.println(result);
    }

    public static int calculateFactorial(int n) {

        if (n == 1) {
            return 1;
        }


        return n * calculateFactorial(n - 1);

    }
}

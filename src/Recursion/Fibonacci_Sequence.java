package Recursion;

import java.util.Scanner;

public class Fibonacci_Sequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i = Integer.parseInt(scanner.nextLine());

        int result = calculateFactorial(i);
        System.out.println(result);
    }

    public static int calculateFactorial(int i) {

        if (i == 1) {
            return 1;
        }


        return i * calculateFactorial(i - 1);

    }
}

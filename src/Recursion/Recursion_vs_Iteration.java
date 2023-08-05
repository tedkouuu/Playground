package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion_vs_Iteration {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = sumNumbersLoop(arr);

        System.out.println("Iteration sum: " + sum);

        int sumTwo = sumNumbersRecursion(arr, 0);

        System.out.println("Recursion sum: " + sumTwo);
    }

    //   Iterative method
    private static int sumNumbersLoop(int[] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //  Recursive method
    public static int sumNumbersRecursion(int[] numbers, int index) {

        if (index >= numbers.length) {

            return 0;
        }


        return numbers[index] + sumNumbersRecursion(numbers, index + 1);

    }
}

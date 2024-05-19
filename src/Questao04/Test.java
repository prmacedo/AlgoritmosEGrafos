package Questao04;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arrayA1 = generateSortedArray(10);
        int[] arrayB1 = generateSortedArray(20);
        int[] arrayA2 = generateSortedArray(100);
        int[] arrayB2 = generateSortedArray(200);
        int[] arrayA3 = generateSortedArray(1_000);
        int[] arrayB3 = generateSortedArray(2_000);
        int[] arrayA4 = generateSortedArray(10_000);
        int[] arrayB4 = generateSortedArray(20_000);
        int[] arrayA5 = generateSortedArray(100_000);
        int[] arrayB5 = generateSortedArray(200_000);

        // Warm-up
        analyzeBruteForce(arrayA1, arrayB1, 25);
        System.out.println();

        // 10 + 20
        analyzeBruteForce(arrayA1, arrayB1, 25);
        analyzeDivideAndConquer(arrayA1, arrayB1, 25);
        System.out.println();

        // 100 + 200
        analyzeBruteForce(arrayA2, arrayB2, 250);
        analyzeDivideAndConquer(arrayA2, arrayB2, 250);
        System.out.println();

        // 1_000 + 2_000
        analyzeBruteForce(arrayA3, arrayB3, 2_500);
        analyzeDivideAndConquer(arrayA3, arrayB3, 2_500);
        System.out.println();

        // 10_000 + 20_000
        analyzeBruteForce(arrayA4, arrayB4, 25_000);
        analyzeDivideAndConquer(arrayA4, arrayB4, 25_000);
        System.out.println();

        // 100_000 + 200_000
        analyzeBruteForce(arrayA5, arrayB5, 250_000);
        analyzeDivideAndConquer(arrayA5, arrayB5, 250_000);
        System.out.println();
    }

    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        Random random = new Random(42);

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2 * n + 1) - n;
        }

        Arrays.sort(arr);

        return arr;
    }

    private static void analyzeBruteForce(int[] arrayA, int[] arrayB, int k){
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(FindKthElementInCombinedArray.bruteForceSolution(arrayA, arrayB, k));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }

    private static void analyzeDivideAndConquer(int[] arrayA, int[] arrayB, int k) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(FindKthElementInCombinedArray.divideAndConquerSolution(arrayA, arrayB, k));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }
}

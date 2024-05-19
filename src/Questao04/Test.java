package Questao04;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] arrayA1 = generateSortedArray(100000);
        int[] arrayB1 = generateSortedArray(200000);

        System.out.println(Arrays.toString(arrayA1));
        System.out.println(Arrays.toString(arrayB1));

        analyzeBruteForce(arrayA1, arrayB1, 300000);
        analyzeDivideAndConquer(arrayA1, arrayB1, 300000);

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

        start = System.currentTimeMillis();
        System.out.println(FindKthElementInCombinedArray.bruteForceSolution(arrayA, arrayB, k));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

    private static void analyzeDivideAndConquer(int[] arrayA, int[] arrayB, int k) {
        long start;
        long end;

        start = System.currentTimeMillis();
        System.out.println(FindKthElementInCombinedArray.divideAndConquerSolution(arrayA, arrayB, k));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }
}

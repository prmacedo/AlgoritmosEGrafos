package Questao03;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] array10 = generateSortedArray(10, 2);
        int[] array100 = generateSortedArray(100, 3);
        int[] array1_000 = generateSortedArray(1_000, 1_000);
        int[] array5_000 = generateSortedArray(5_000, 0);
        int[] array10_000 = generateSortedArray(10_000, 0);

        // Warm-up
        analyzeBruteForce(array10);
        System.out.println();

        // 10 Elements
        analyzeBruteForce(array10);
        analyzeDivideAndConquer(array10);
        System.out.println();

        // 100 Elements
        analyzeBruteForce(array100);
        analyzeDivideAndConquer(array100);
        System.out.println();

        // 1_000 Elements
        analyzeBruteForce(array1_000);
        analyzeDivideAndConquer(array1_000);
        System.out.println();

        // 5_000 Elements
        analyzeBruteForce(array5_000);
        analyzeDivideAndConquer(array5_000);
        System.out.println();

        // 10_000 Elements
        analyzeBruteForce(array10_000);
        analyzeDivideAndConquer(array10_000);
        System.out.println();
    }

    public static int[] generateSortedArray(int n, int seed) {
        int[] arr = new int[n];
        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2 * n + 1) - n;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        Arrays.sort(arr);

        return arr;
    }

    private static void analyzeBruteForce(int[] array){
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(SearchIndexEqualsValue.bruteForceSolution(array));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }

    private static void analyzeDivideAndConquer(int[] array) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(SearchIndexEqualsValue.divideAndConquer(array));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }
}

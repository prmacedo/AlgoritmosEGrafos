package Questao03;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] array10 = generateSortedArray(10, 2);
        System.out.println(Arrays.toString(array10));
        System.out.println(SearchIndexEqualsValue.solutionBruteForce(array10));
        System.out.println(Arrays.toString(array10));
        System.out.println(SearchIndexEqualsValue.binarySearch(array10, 0, array10.length - 1));
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
}

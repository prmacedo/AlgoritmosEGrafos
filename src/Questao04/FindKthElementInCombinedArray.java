package Questao04;

import java.util.Arrays;

public class FindKthElementInCombinedArray {
    public static int bruteForceSolution(int[] arrayA, int[] arrayB, int k) {
        int[] arrayC = new int[arrayA.length + arrayB.length];
        System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
        System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);

        Arrays.sort(arrayC); // O(n.log(n))

        return arrayC[k - 1];
    }

    public static int divideAndConquerSolution(int[] arrayA, int[] arrayB, int k) {
        return findKthElement(arrayA, 0, arrayA.length - 1, arrayB, 0, arrayB.length - 1, k);
    }

    private static int findKthElement(int[] arrayA, int arrayAStart, int arrayAEnd, int[] arrayB, int arrayBStart, int arrayBEnd, int k) {
        int sizeA = arrayAEnd - arrayAStart + 1;
        int sizeB = arrayBEnd - arrayBStart + 1;

        if (sizeA > sizeB) {
            return findKthElement(arrayB, arrayBStart, arrayBEnd, arrayA, arrayAStart, arrayAEnd, k);
        }

        if (sizeA == 0) {
            return arrayB[arrayBStart + k - 1];
        }

        if (k == 1) {
            return Math.min(arrayA[arrayAStart], arrayB[arrayBStart]);
        }

        int indexMiddleA = arrayAStart + Math.min(sizeA, k / 2) - 1;
        int indexMiddleB = arrayBStart + Math.min(sizeB, k / 2) - 1;

        if (arrayA[indexMiddleA] <= arrayB[indexMiddleB]) {
            return findKthElement(arrayA, indexMiddleA + 1, arrayAEnd, arrayB, arrayBStart, arrayBEnd, k - (indexMiddleA - arrayAStart + 1));
        } else {
            return findKthElement(arrayA, arrayAStart, arrayAEnd, arrayB, indexMiddleB + 1, arrayBEnd, k - (indexMiddleB - arrayBStart + 1));
        }
    }
}

package Questao03;

public class SearchIndexEqualsValue {
    public static int solutionBruteForce(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] numbers, int start, int end) {
        if (start <= end) {
            int middle = (start + end) / 2;

            if (numbers[middle] == middle) {
                return middle;
            } else if (numbers[middle] > middle) {
                return binarySearch(numbers, start, middle - 1);
            } else {
                return binarySearch(numbers, middle + 1, end);
            }
        }

        return -1;
    }
}

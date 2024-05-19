package Questao05;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] votes = generateArray(10, 43);

        analyzeBruteForce(votes);
        analyzeDivideAndConquer(votes);
    }

    public static int[] generateArray(int size, int seed) {
        int[] arr = new int[size];
        Random random = new Random(seed);

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(5) + 1;
        }

        return arr;
    }

    private static void analyzeBruteForce(int[] votes){
        long start;
        long end;

        start = System.currentTimeMillis();
        System.out.println(MajorityVoting.bruteForceSolution(votes));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

    private static void analyzeDivideAndConquer(int[] votes) {
        long start;
        long end;

        start = System.currentTimeMillis();
        System.out.println(MajorityVoting.divideAndConquerSolution(votes));
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }
}

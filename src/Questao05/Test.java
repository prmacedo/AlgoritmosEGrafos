package Questao05;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] votes1 = generateArray(10, 43);
        int[] votes2 = generateArray(100, 43);
        int[] votes3 = generateArray(1_000, 43);
        int[] votes4 = generateArray(10_000, 43);
        int[] votes5 = generateArray(100_000, 43);

        // Warm-up
        analyzeBruteForce(votes1);
        System.out.println();

        // 10 Votes
        analyzeBruteForce(votes1);
        analyzeDivideAndConquer(votes1);
        System.out.println();

        // 100 Votes
        analyzeBruteForce(votes2);
        analyzeDivideAndConquer(votes2);
        System.out.println();

        // 1_000 Votes
        analyzeBruteForce(votes3);
        analyzeDivideAndConquer(votes3);
        System.out.println();

        // 10_000 Votes
        analyzeBruteForce(votes4);
        analyzeDivideAndConquer(votes4);
        System.out.println();

        // 100_000 Votes
        analyzeBruteForce(votes5);
        analyzeDivideAndConquer(votes5);
        System.out.println();
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

        start = System.nanoTime();
        System.out.println(MajorityVoting.bruteForceSolution(votes));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }

    private static void analyzeDivideAndConquer(int[] votes) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(MajorityVoting.divideAndConquerSolution(votes));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }
}

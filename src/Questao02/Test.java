package Questao02;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        // Warm-up
        analyzeBruteForce("999888777", "999888777");
        analyzeDivideAndConquer(999888777L, 999888777L);
        System.out.println();

        // 9 dígitos
        analyzeBruteForce("999888777", "999888777");
        analyzeDivideAndConquer(999888777L, 999888777L);
        System.out.println();

        // 12 dígitos
        analyzeBruteForce("999888777666", "999888777666");
        analyzeDivideAndConquer(999888777666L, 999888777666L);
        System.out.println();

        // 15 dígitos
        analyzeBruteForce("999888777666555", "999888777666555");
        analyzeDivideAndConquer(999888777666555L, 999888777666555L);
        System.out.println();

        // 18 dígitos
        analyzeBruteForce("999888777666555444", "999888777666555444");
        analyzeDivideAndConquer(999888777666555444L, 999888777666555444L);
        System.out.println();
    }

    private static void analyzeBruteForce(String num1, String num2){
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(MultiplicationOfInteger.bruteForceSolution(num1, num2));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }

    private static void analyzeDivideAndConquer(long num1, long num2) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(MultiplicationOfInteger.karatsuba(num1, num2));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }
}

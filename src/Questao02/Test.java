package Questao02;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        // Warm-up
        analyzeBruteForce("99", "99");
        analyzeDivideAndConquer(99L, 99L);
        System.out.println();

        // 2 dígitos
        analyzeBruteForce("99", "99");
        analyzeDivideAndConquer(99L, 99L);
        System.out.println();

        // 3 dígitos
        analyzeBruteForce("999", "999");
        analyzeDivideAndConquer(999L, 999L);
        System.out.println();

        // 4 dígitos
        analyzeBruteForce("9999", "9999");
        analyzeDivideAndConquer(9999L, 9999L);
        System.out.println();

        // 5 dígitos
        analyzeBruteForce("99996", "99996");
        analyzeDivideAndConquer(99996L, 99996L);
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

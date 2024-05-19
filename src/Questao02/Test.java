package Questao02;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        // 18 dígitos
        analyzeBruteForce("666555444333222111", "111222333444555666");
        analyzeDivideAndConquer(new BigInteger("666555444333222111"), new BigInteger("111222333444555666"));
        System.out.println();

        // 21 dígitos
        analyzeBruteForce("777666555444333222111", "111222333444555666777");
        analyzeDivideAndConquer(new BigInteger("777666555444333222111"), new BigInteger("111222333444555666777"));
        System.out.println();

        // 24 dígitos
        analyzeBruteForce("888777666555444333222111", "111222333444555666777888");
        analyzeDivideAndConquer(new BigInteger("888777666555444333222111"), new BigInteger("111222333444555666777888"));
        System.out.println();

        // 27 dígitos
        analyzeBruteForce("999888777666555444333222111", "111222333444555666777888999");
        analyzeDivideAndConquer(new BigInteger("999888777666555444333222111"), new BigInteger("111222333444555666777888999"));
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

    private static void analyzeDivideAndConquer(BigInteger num1, BigInteger num2) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(MultiplicationOfInteger.karatsuba(num1, num2));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }
}

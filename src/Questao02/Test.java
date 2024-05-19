package Questao02;

public class Test {
    public static void main(String[] args) {
        // Warm-up
        analyzeBruteForce("50", "50");
        System.out.println();

        // 99 x 99
        analyzeBruteForce("99", "99");
        analyzeDivideAndConquer(99, 99);
        System.out.println();

        // 999 x 999
        analyzeBruteForce("999", "999");
        analyzeDivideAndConquer(999, 999);
        System.out.println();

        // 9999 x 9999
        analyzeBruteForce("9999", "9999");
        analyzeDivideAndConquer(9999, 9999);
        System.out.println();

        // 99999 x 99999
        analyzeBruteForce("99999", "99999");
        analyzeDivideAndConquer(99999, 99999);
        System.out.println();

        // 999999 x 999999
        analyzeBruteForce("999999", "999999");
        analyzeDivideAndConquer(999999, 999999);
        System.out.println();

        // 9999999 x 9999999
        analyzeBruteForce("9999999", "9999999");
        analyzeDivideAndConquer(9999999, 9999999);
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

    private static void analyzeDivideAndConquer(int num1, int num2) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(MultiplicationOfInteger.karatsuba(num1, num2));
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1_000_000d + "ms");
    }
}

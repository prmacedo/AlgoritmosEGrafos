package Questao01;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Point[] points10 = generatePoints(10);
        Point[] points100 = generatePoints(100);
        Point[] points250 = generatePoints(250);
        Point[] points500 = generatePoints(500);
        Point[] points1000 = generatePoints(1000);
        Point[] points2000 = generatePoints(2000);

        // Warm-up
        analyzeBruteForce(points10);
        System.out.println();

        // 10 Points
        analyzeBruteForce(points10);
        analyzeDivideAndConquer(points10);
        System.out.println();

        // 100 Points
        analyzeBruteForce(points100);
        analyzeDivideAndConquer(points100);
        System.out.println();

        // 250 Points
        analyzeBruteForce(points250);
        analyzeDivideAndConquer(points250);
        System.out.println();

        // 500 Points
        analyzeBruteForce(points500);
        analyzeDivideAndConquer(points500);
        System.out.println();

        // 1000 Points
        analyzeBruteForce(points1000);
        analyzeDivideAndConquer(points1000);
        System.out.println();

        // 2000 Points
        analyzeBruteForce(points2000);
        analyzeDivideAndConquer(points2000);
        System.out.println();
    }

    private static void analyzeBruteForce(Point[] points) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(Arrays.toString(ClosestPairOfPoints.bruteForceSolution(points)));
        end = System.nanoTime();
        System.out.println(points.length + " points: " + (end - start) / 1_000_000d + "ms");
    }

    private static void analyzeDivideAndConquer(Point[] points) {
        long start;
        long end;

        start = System.nanoTime();
        System.out.println(Arrays.toString(ClosestPairOfPoints.divideAndConquerSolution(points)));
        end = System.nanoTime();
        System.out.println(points.length + " points: " + (end - start) / 1_000_000d + "ms");
    }

    public static Point[] generatePoints(int size) {
        Point[] points = new Point[size];
        Random random = new Random(42);
        for (int i = 0; i < size; i++) {
            int x = random.nextInt(2 * size - 1) - size;
            int y = random.nextInt(2 * size - 1) - size;
            points[i] = new Point(x, y);
        }
        return points;
    }
}

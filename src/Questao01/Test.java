package Questao01;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Point[] points10 = generatePoints(100000);
//        Point[] points100 = generatePoints(100);
//        Point[] points250 = generatePoints(250);
//        Point[] points500 = generatePoints(500);
//        Point[] points1000 = generatePoints(1000);
//        Point[] points2000 = generatePoints(2000);

        System.out.println(Arrays.toString(points10));

//        System.out.println(Arrays.toString(points10.toArray()));
//
//        // Brute Force - Warm Up
        analyzeBruteForce(points10);
        analyzeDivideAndConquer(points10);
//
//        // 100 Points
//        analyzeBruteForce(points100);
//
//        // 250 Points
//        analyzeBruteForce(points250);
//
//        // 500 Points
//        analyzeBruteForce(points500);
//
//        // 1000 Points
//        analyzeBruteForce(points1000);
//
//        // 2000 Points
//        analyzeBruteForce(points2000);
    }

    private static void analyzeBruteForce(Point[] points) {
        long start;
        long end;

        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(ClosestPairOfPoints.bruteForceSolution(points)));
        end = System.currentTimeMillis();
        System.out.println(points.length + " points: " + (end - start) + "ms");
    }

    private static void analyzeDivideAndConquer(Point[] points) {
        long start;
        long end;

        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(ClosestPairOfPoints.divideAndConquerSolution(points)));
        end = System.currentTimeMillis();
        System.out.println(points.length + " points: " + (end - start) + "ms");
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

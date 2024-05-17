package Questao01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        List<Point> points10 = generatePoints(10);
        List<Point> points100 = generatePoints(100);
        List<Point> points250 = generatePoints(250);
        List<Point> points500 = generatePoints(500);
        List<Point> points1000 = generatePoints(1000);
        List<Point> points2000 = generatePoints(2000);

        System.out.println(Arrays.toString(points10.toArray()));

        // Brute Force - Warm Up
        analyzeBruteForce(points10);

        // 100 Points
        analyzeBruteForce(points100);

        // 250 Points
        analyzeBruteForce(points250);

        // 500 Points
        analyzeBruteForce(points500);

        // 1000 Points
        analyzeBruteForce(points1000);

        // 2000 Points
        analyzeBruteForce(points2000);
    }

    private static void analyzeBruteForce(List<Point> points) {
        long start;
        long end;

        start = System.currentTimeMillis();
        ClosestPairOfPoints.solutionBruteForce(points);
        end = System.currentTimeMillis();
        System.out.println(points.size() + " points: " + (end - start) + "ms");
    }

    public static List<Point> generatePoints(int size) {
        List<Point> points = new ArrayList<>();
        Random random = new Random(42);
        for (int i = 0; i < size; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            points.add(new Point(x, y));
        }
        return points;
    }
}

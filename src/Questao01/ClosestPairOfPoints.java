package Questao01;

import java.util.List;

public class ClosestPairOfPoints {
    private static double distanceBetweenPoints(Point p1, Point p2) {
        double squareDiffX = Math.pow(p1.x() - p2.x(), 2);
        double squareDiffY = Math.pow(p1.y() - p2.y(), 2);
        return Math.sqrt(squareDiffX + squareDiffY);
    }

    public static Point[] solutionBruteForce(List<Point> points) {
        Point[] pointsPair = null;
        double minDistance = Double.MAX_VALUE;

        for (int i = 1; i < points.size(); i++) {
            for (int j = 0; j < i; j++) {
                double distance = distanceBetweenPoints(points.get(i), points.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    pointsPair = new Point[] {points.get(i), points.get(j)};
                }
            }
        }

        return pointsPair;
    }

    public static Point[] solutionDivideAndConquer(List<Point> points) {
        Point[] pointsPair = null;
        double minDistance = Double.MAX_VALUE;

        return pointsPair;
    }
}
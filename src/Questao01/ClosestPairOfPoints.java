package Questao01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPairOfPoints {
    private static double distanceBetweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x() - p2.x(), 2) + Math.pow(p1.y() - p2.y(), 2));
    }

    public static Point[] bruteForceSolution(Point[] points) {
        double minDistance = Double.MAX_VALUE;
        Point[] closestPair = new Point[2];

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distanceBetweenPoints(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }

        return closestPair;
    }

    public static Point[] divideAndConquerSolution(Point[] points) {
        Point[] pointsByX = points.clone();
        mergeSortByXCoordinate(pointsByX, 0, points.length - 1);

        Point[] pointsByY = points.clone();
        mergeSortByYCoordinate(pointsByY, 0, points.length - 1);

        return closestPairOfPoints(pointsByX, pointsByY);
    }

    private static Point[] closestPairOfPoints(Point[] pointsX, Point[] pointsY) {
        int size = pointsX.length;

        if (size <= 3) {
            return bruteForceSolution(pointsX);
        }

        int middle = size / 2;

        Point[] pointsXLeft = Arrays.copyOfRange(pointsX, 0, middle);
        Point[] pointsXRight = Arrays.copyOfRange(pointsX, middle, size);

        Point middlePoint = pointsX[middle];

        List<Point> pointsYLeftList = new ArrayList<>();
        List<Point> pointsYRightList = new ArrayList<>();

        for (Point point : pointsY) {
            if (point.x() <= middlePoint.x()) {
                pointsYLeftList.add(point);
            } else {
                pointsYRightList.add(point);
            }
        }

        Point[] pointsYLeft = pointsYLeftList.toArray(new Point[0]);
        Point[] pointsYRight = pointsYRightList.toArray(new Point[0]);

        Point[] closestPairLeft = closestPairOfPoints(pointsXLeft, pointsYLeft);
        Point[] closestPairRight = closestPairOfPoints(pointsXRight, pointsYRight);

        double distanceLeft = distanceBetweenPoints(closestPairLeft[0], closestPairLeft[1]);
        double distanceRight = distanceBetweenPoints(closestPairRight[0], closestPairRight[1]);
        double distance = Math.min(distanceLeft, distanceRight);

        Point[] bestPair = distanceLeft < distanceRight ? closestPairLeft : closestPairRight;

        List<Point> strip = new ArrayList<>();
        for (Point point : pointsY) {
            if (Math.abs(point.x() - middlePoint.x()) < distance) {
                strip.add(point);
            }
        }

        Point[] stripArray = strip.toArray(new Point[0]);

        Point[] stripPair = stripClosest(stripArray, distance);
        if (stripPair != null && distanceBetweenPoints(stripPair[0], stripPair[1]) < distance) {
            return stripPair;
        }

        return bestPair;
    }

    private static Point[] stripClosest(Point[] points, double distance) {
        double min = distance;
        Point[] pairOfPoints = null;

        for (int i = 0; i < points.length - 1; ++i) {
            for (int j = i + 1; j < points.length && (points[j].y() - points[i].y()) < min; ++j) {
                double currentDistance = distanceBetweenPoints(points[i], points[j]);
                if (currentDistance < min) {
                    min = currentDistance;
                    pairOfPoints = new Point[] {points[i], points[j]};
                }
            }
        }

        return pairOfPoints;
    }

    private static void mergeSortByXCoordinate(Point[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSortByXCoordinate(arr, l, m);
            mergeSortByXCoordinate(arr, m + 1, r);

            mergeByXCoordinate(arr, l, m, r);
        }
    }

    private static void mergeByXCoordinate(Point[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Point[] L = new Point[n1];
        Point[] R = new Point[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].x() <= R[j].x()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void mergeSortByYCoordinate(Point[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSortByYCoordinate(arr, l, m);
            mergeSortByYCoordinate(arr, m + 1, r);

            mergeByYCoordinate(arr, l, m, r);
        }
    }

    private static void mergeByYCoordinate(Point[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Point[] L = new Point[n1];
        Point[] R = new Point[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].y() <= R[j].y()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
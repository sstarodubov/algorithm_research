package sorting;

import java.util.ArrayDeque;
import java.util.Deque;

record Point(int x, int y) {

    public static int ccw(final Point a, final Point b, final Point c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0) return -1; //clockwise
        if (area2 > 0) return 1; //counter-clockwise
        return 0; // collinear
    }
}


public class ConvexHull {

    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y() - p.y()) * (r.x() - q.x()) -
                (q.x() - p.x()) * (r.y() - q.y());

        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    public static Deque<Point> convexHull(Point[] points, int n) {
        Deque<Point> hull = new ArrayDeque<>();

        if (n < 3) return hull;

        int l = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x() < points[l].x())
                l = i;
        }

        int p = l, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2) {
                    q = i;
                }
            }

            p = q;

        } while (p != l);

        return hull;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {

        Point points[] = new Point[7];
        points[0] = new Point(0, 3);
        points[1] = new Point(2, 3);
        points[2] = new Point(1, 1);
        points[3] = new Point(2, 1);
        points[4] = new Point(3, 0);
        points[5] = new Point(0, 0);
        points[6] = new Point(3, 3);

        int n = points.length;
        System.out.println(convexHull(points, n));
    }
}
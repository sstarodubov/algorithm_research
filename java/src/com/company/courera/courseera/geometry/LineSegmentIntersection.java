package geometry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LineSegmentIntersection {

    public static void main(String[] args) throws Exception {
        var pq = new PriorityQueue<>(Comparator.comparingInt(Point::x).thenComparing((a, b) -> {
            if (a.type() == Type.HORIZONTAL && b.type() == Type.VERTICAL) return 1;
            if (a.type() == Type.VERTICAL && b.type() == Type.HORIZONTAL) return -1;
            else return 0;
        }));

        pq.add(new Point(3, 5, Position.NONE, Type.VERTICAL, 2));
        pq.add(new Point(5, 2, Position.LEFT, Type.HORIZONTAL));
        pq.add(new Point(8, 2, Position.RIGTH, Type.HORIZONTAL));
        pq.add(new Point(8, 4, Position.LEFT, Type.HORIZONTAL));
        pq.add(new Point(12, 4, Position.RIGTH, Type.HORIZONTAL));
        pq.add(new Point(4, 7, Position.LEFT, Type.HORIZONTAL));
        pq.add(new Point(8, 7, Position.RIGTH, Type.HORIZONTAL));
        pq.add(new Point(6, 6, Position.LEFT, Type.HORIZONTAL));
        pq.add(new Point(8, 6, Position.RIGTH, Type.HORIZONTAL));
        pq.add(new Point(7, 8, Position.NONE, Type.VERTICAL, 6));
        pq.add(new Point(12, 7, Position.NONE, Type.VERTICAL, 3));

        var intersections = compute(pq);
        System.out.println(intersections);
    }

    private static List<Intersection> compute(PriorityQueue<Point> points) {
        var intersections = new ArrayList<Intersection>(points.size());
        var bst = new RangeSet<Integer>();
        while (!points.isEmpty()) {
            final Point point = points.poll();
            if (point.type() == Type.HORIZONTAL) {
                switch (point.position()) {
                    case LEFT -> bst.add(point.y());
                    case RIGTH -> bst.remove(point.y());
                    case NONE -> throw new IllegalStateException("NONE POINT");
                }
            } else if (point.type() == Type.VERTICAL) {
                bst.range(point.lowY(), point.y())
                        .forEach(y -> intersections.add(new Intersection(point.x(), y)));
            }
        }

        return intersections;
    }
}

record Intersection(int x, int y) {
}

record Point(int x, int y, Position position, Type type, int lowY) {
    public Point(int x, int y, Position position, Type type) {
        this(x, y, position, type, -1);
    }
}

enum Type {
    HORIZONTAL, VERTICAL
}

enum Position {
    LEFT, RIGTH, NONE
}

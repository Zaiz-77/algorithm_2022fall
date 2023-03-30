package com.algorithm.lectures.week02;

import java.util.*;

public class ClosestPoints {
    /**
     * Get the distance between point1 and point2
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the distance
     */
    private double distance(Point p1, Point p2) {
        double x1 = p1.x, y1 = p1.y, x2 = p2.x, y2 = p2.y;
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Calc the min dis from l to r
     *
     * @param ps the points array
     * @param l  the left end
     * @param r  the right end
     * @return the min distance
     */
    public double merge(Point[] ps, int l, int r) {
        double dis = Double.MAX_VALUE;
        if (l == r) return dis;
        if (l + 1 == r) return distance(ps[l], ps[r]);

        int mid = (l + r) >> 1;
        dis = Math.min(merge(ps, l, mid), merge(ps, mid + 1, r));
        List<Point> temp = new ArrayList<>();

        // 只需要检查距离中间距离不超过dis的点 Why如果在超过dis之外的两点作为了答案点两者距离必然大于2 * dis，而这时我们选择左侧或右侧较小的dis就更优，因此推翻
        for (int i = l; i <= r; i++) if (Math.abs(ps[i].x - ps[mid].x) <= dis) temp.add(ps[i]);
        temp.sort(Comparator.comparingDouble(p -> p.y));
        for (int i = l; i < temp.size(); i++) {
            // 此处还是暴力，但是剪枝，因为y方向大于dis的点也不可能作为答案，均大于之前的dis
            for (int j = i + 1; j < temp.size() && temp.get(j).y - temp.get(i).y < dis; j++) {
                dis = Math.min(dis, distance(temp.get(i), temp.get(j)));
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        ClosestPoints solve = new ClosestPoints();
        Point[] ps = {new Point(1, 1), new Point(1, 2), new Point(2, 2), new Point(500, 1)};
        Arrays.sort(ps, (p1, p2) -> (int) (p1.x == p2.x ? p1.y - p2.y : p1.y));
        System.out.println(solve.merge(ps, 0, ps.length - 1));
    }
}

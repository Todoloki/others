/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public class Pair {
        int x;
        int y;
        double distance;
        Pair (int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(10, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (Math.abs(p1.distance - p2.distance) < 1e-6) {
                    if (p1.x != p2.x) {
                        return p2.x - p1.x;
                    }
                    else {
                        return p2.y - p1.y;
                    }
                }
                if (p1.distance > p2.distance) {
                    return -1;
                }
                return 1;
            }
        });
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            double distance = Math.sqrt((p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y));
            if (queue.size() < k) {
                queue.add(new Pair(p.x, p.y, distance));
            }
            else {
                double maxDistance = queue.peek().distance;
                //System.out.println(distance + " " + maxDistance);
                if (Math.abs(distance - maxDistance) < 1e-6) {
                    if (p.x < queue.peek().x) {
                        queue.poll();
                        queue.add(new Pair(p.x, p.y, distance));
                    }
                    if (p.x == queue.peek().x && p.y < queue.peek().y) {
                        queue.poll();
                        queue.add(new Pair(p.x, p.y, distance));
                    }
                }
                else if (distance < maxDistance) {
                    queue.poll();
                    queue.add(new Pair(p.x, p.y, distance));
                }
            }
        }
        Point[] res = new Point[queue.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            Pair pair = queue.poll();
            res[i] = new Point(pair.x, pair.y);
        }
        return res;
    }
}
// bug: in constructor use this.distance = this.distance instead of this.distance = distance.
// time complexity O(nlogk), O(n) maximum number of delete the first element from queue and add a new one to it. each cost O(logk)
// other solution sort the array according to distance, and pick up the first k
// maybe explain time complexity for each part of the code is better.

// today also give you galaxy
// zelda dlc come out today~
// space complexity O(

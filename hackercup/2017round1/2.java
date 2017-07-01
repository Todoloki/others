import java.util.*;
public class Solution {
    public static class Pair {
        int x;
        int y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class startPoint {
        int x;
        int y;
        startPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int r = scanner.nextInt();
            List<Pair> list = new ArrayList<Pair>();
            for (int j = 0; j < n; j++) {
                list.add(new Pair(scanner.nextInt(), scanner.nextInt()));
            }
            List<startPoint> startPoints = new ArrayList<startPoint>();
            HashSet<String> set = new HashSet<String>();
            for (int t1 = 0; t1 < n; t1++) {
                for (int t2 = t1; t2 < n; t2++) {
                    int minX = Math.min(list.get(t1).x, list.get(t2).x);
                    int minY = Math.min(list.get(t1).y, list.get(t2).y);
                    String key = minX + " " + minY;
                    if (set.contains(key)) {
                        continue;
                    }
                    startPoints.add(new startPoint(minX, minY));
                    set.add(key);
                }
            }
            Collections.sort(startPoints, new Comparator<startPoint>() {
                @Override
                public int compare(startPoint s1, startPoint s2) {
                    return s1.x - s2.x;
                }
            });
            List<Integer> list2 = new ArrayList<Integer>();
            for (int t1 = 0; t1 < startPoints.size(); t1++) {
                list2.add(getNumOfPoints(startPoints.get(t1).x, startPoints.get(t1).y, list, r));
            }
            int max = 0;
            for (int t1 = 0; t1 < n; t1++) {
                for (int t2 = t1; t2 < n; t2++) {
                    int x = Math.min(list.get(t1).x, list.get(t2).x);
                    int y = Math.min(list.get(t1).y, list.get(t2).y);
                    int numOfM = getNumOfPoints(x, y, list, r);
                    int index1 = findLargerOrEqualToX(startPoints, x - r);
                    int index2 = findLessOrEqualToX(startPoints, x + r);
                    int cur = 0;
                    for (int t3 = index1; t3 <= index2; t3++) {
                        int x2 = startPoints.get(t3).x;
                        int y2 = startPoints.get(t3).y;
                        cur = Math.max(cur, getNumOfPoints2(x, y, x2, y2, list, r));
                    }
                    for (int t3 = 0; t3 < index1; t3++) {
                        cur = Math.max(cur, numOfM + list2.get(t3));
                    }
                    for (int t3 = index2 + 1; t3 < startPoints.size(); t3++) {
                        cur = Math.max(cur, numOfM + list2.get(t3));
                    }
                    max = Math.max(cur, max);
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.println(max);
        }
    }
    public static int getNumOfPoints(int x, int y, List<Pair> list, int r) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x >= x && list.get(i).x <= x + r && list.get(i).y >= y && list.get(i).y <= y + r) {
                counter++;
            }
        }
        return counter;
    }
    public static int getNumOfPoints2(int x, int y, int x2, int y2, List<Pair> list, int r) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x >= x && list.get(i).x <= x + r && list.get(i).y >= y && list.get(i).y <= y + r) {
                counter++;
                continue;
            }
            if (list.get(i).x >= x2 && list.get(i).x <= x2 + r && list.get(i).y >= y2 && list.get(i).y <= y2 + r) {
                counter++;
            }
        }
        return counter;
    }
    public static int findLargerOrEqualToX(List<startPoint> list, int x) {
        if (list.size() == 0) {
            return list.size();
        }
        int low = 0;
        int high = list.size() - 1;
        // binary search
        // return the first one with x larger or equal to x;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (list.get(mid).x < x) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        if (list.get(low).x >= x) {
            return low;
        }
        if (high >= 0 && list.get(high).x >= x) {
            return high;
        }
        return high + 1;
    }
    public static int findLessOrEqualToX(List<startPoint> list, int x) {
        if (list.size() == 0) {
            return -1;
        }
        int low = 0;
        int high = list.size() - 1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (list.get(mid).x > x) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        if (high >= 0 && list.get(high).x <= x) {
            return high;
        }
        if (list.get(low).x <= x) {
            return low;
        }
        return low - 1;
    }
}
// O(n * n) time find startpoints. for each O(n * n), there are O(logn) time find the bonds, O(n * r * r) time for getting overlapped
points.
// O(n * n) space used here.

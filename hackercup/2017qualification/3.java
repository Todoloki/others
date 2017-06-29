import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        HashMap<String, Double> map = new HashMap<String, Double>();
        for (int i = 0; i < numOfCases; i++) {
            int damage = scanner.nextInt();
            int times = scanner.nextInt();
            double max = 0.0;
            for (int j = 0; j < times; j++) {
                String s = scanner.next();
                int index = -1;
                index = s.indexOf("+");
                if (index < 0) {
                    index = s.indexOf("-");
                }
                int z = 0;
                if (index >= 0) {
                    z = Integer.parseInt(s.substring(index + 1));
                }
                if (index >= 0 && s.charAt(index) == '-') {
                    z = -z;
                }
                String xy = s;
                if (index >= 0) {
                    xy = s.substring(0,index);
                }
                int posOfD = xy.indexOf("d");
                int x = Integer.parseInt(xy.substring(0, posOfD));
                int y = Integer.parseInt(xy.substring(posOfD + 1));
                double possibility = getPossibility(damage - z, x, y, map);
                max = Math.max(max, possibility);
            }
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.format("%.6f\n", max);
        }
    }
    public static double getPossibility(int d, int x, int y, HashMap<String, Double> map) {
        if (d <= 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        String key = d + " " + x + " " + y;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        double sum = 0;
        for (int i = 1; i <= y; i++) {
            sum += 1.0 / y * getPossibility(d - i, x - 1, y, map);
        }
        map.put(key, sum);
        return sum;
    }
}
// need to know that f(n, k) = f(n - i, k - 1) i >= 1 && i <= y
// memorizatation is used here.

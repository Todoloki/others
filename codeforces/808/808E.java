/**
 * Wanna play splatoon.
 */
 // althought we can use back-pack way to solve this problem, that will cost too much time
 // for each item O(m) is needed, so time complexity is up to O(m * n)
 // but here we first consider best cases for 1-element and 2-element, and fix 3-items into them
 // cost at most O(nlogn) time for sorting. O(m) for finding the optimal solution. So
 // time complexity decreased to O(nlogn + m), which is much less time compared to former one.
 // O(m + n) space is used and is considered as space complexity
 
 // zelda just entered first village. afraid of finghting monsters. good to be an archer.
 // thank you for spending four years in doing this game. really beautiful. really amazing.
 // thank you again
import java.util.*;
public class Solution {
    public static class Pair {
        int index1;
        int index2;
        long cost;
        Pair (int index1, int index2, long cost) {
            this.index1 = index1;
            this.index2 = index2;
            this.cost = cost;
        }
    }
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();

        int sum = 0;
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int c = scanner.nextInt();
            if (w == 1) {
                list1.add(c);
            }
            else if (w == 2) {
                list2.add(c);
            }
            else {
                list3.add(c);
            }
            sum += w;
            totalCost += c;
        }

        if (sum <= m) {
            System.out.println(totalCost);
            return ;
        }

        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());
        Collections.sort(list3, Collections.reverseOrder());

        Pair[] pairs = new Pair[m + 1];
        pairs[0] = new Pair(0, 0, 0);
        pairs[1] = list1.size() > 0 ? new Pair(1, 0, list1.get(0)) : new Pair(0 ,0 ,0);
        long cost = pairs[1].cost;
        for (int i = 2; i <= m; i++) {
            long sum1 = 0;
            if (pairs[i - 1].index1 < list1.size()) {
                sum1 = pairs[i - 1].cost + list1.get(pairs[i - 1].index1);
            }
            long sum2 = 0;
            if (pairs[i - 2].index2 < list2.size()) {
                sum2 = pairs[i - 2].cost + list2.get(pairs[i - 2].index2);
            }
            if (sum1 == 0 && sum2 == 0) {
                pairs[i] = new Pair(0, 0, 0);
            }
            else if (sum1 > sum2) {
                pairs[i] = new Pair(pairs[i - 1].index1 + 1, pairs[i - 1].index2, sum1);
            }
            else {
                pairs[i] = new Pair(pairs[i - 2].index1, pairs[i - 2].index2 + 1, sum2);
            }
            cost = Math.max(cost, pairs[i].cost);
        }
        long[] sums = new long[list3.size()];
        for (int i = 0; i < list3.size(); i++) {
            sums[i] = list3.get(i);
        }
        for (int i = 1; i < list3.size(); i++) {
            sums[i] = sums[i] + sums[i - 1];
        }
        for (int i = m - 3; i >= 0; i--) {
            int diff = m - i;
            int numOfthree = diff / 3;
            if (numOfthree > list3.size()) {
                break;
            }
            cost = Math.max(cost, pairs[i].cost + sums[numOfthree - 1]);
        }
        System.out.println(cost);
    }
}

import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int num = scanner.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < num; j++) {
                list.add(scanner.nextInt());
            }
            Collections.sort(list);
            Collections.reverse(list);
            int left = 0;
            int right = list.size() - 1;
            int counter = 0;
            System.out.print("Case #" + (i + 1) + ": ");
            while (left <= right) {
                if (list.get(left) >= 50) {
                    counter++;
                    left++;
                    continue;
                }
                int minItem = 50 + list.get(left) - 1;
                minItem /= list.get(left);
                if (right - left + 1 < minItem) {
                    break;
                }
                left++;
                right -= minItem - 1;
                counter++;
            }
            System.out.println(counter);
        }
    }
}
// each time pick up the maximum one, calculate the minimum items for making a tour
// if we do not have so many items, we already reach the maximum number of tour
// otherwise we pick the maximum and fill the packet with minimum ones
// call it a tour
// time complexity O(nlogn)
// since the array need to be sorted.

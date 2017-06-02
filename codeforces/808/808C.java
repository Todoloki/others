// you have n friends, every friend has a cup with volume ai. you need to pour tea into these cups so that you pour integer
// volume to each cup and at least satisfy half the volume. Another rule is that if volume a > volume b than the tea
// in cup a should be larger or equal than cup b.

// Solution : use a class to group index, volume, tea
// at first satisfy the minimum volume.
// after that start from the largest volume, fill the cup to full if possible


// Time complexity: O(log n) because sorting is used in this problem.
// space complexity: O(n) because extra O(n) space is used to solve this problem.

// progress of the game; I met Lady Impa, but just talked with her once.
/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    static class Pair {
        int index;
        int volume;
        int tea;
        Pair (int index, int volume) {
            this.index = index;
            this.volume = volume;
            this.tea = 0;
        }
    }
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        // read all parameters
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        // create a list to store all the volumes for every friend
        List<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(i, scanner.nextInt()));
            // pour minimum volume to the cup;
            w -= ((list.get(i).volume + 1) / 2);
            list.get(i).tea = (list.get(i).volume + 1) / 2;
        }
        // if we can not satisfy the minimum volume, it is impossible for us to satisfy the requirement
        if (w < 0) {
            System.out.println(-1);
            return ;
        }
        // sort the list so friend with higher volume comes first
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.volume - p1.volume;
            }
        });
        // pour tea to the rest of the friends
        int index = 0;
        while (w > 0) {
            // pour tea to the cup of the friends with highest volume
            int curTea = Math.min(w, list.get(index).volume - list.get(index).tea);
            list.get(index).tea += curTea;
            w -= curTea;
            index++;
        }
        // sort the list by index
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.index - p2.index;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i).tea + " ");
        }
    }
}


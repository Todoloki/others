import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int percent = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            x -= 50;
            y -= 50;
            System.out.print("Case #" + (i + 1) + ": ");
            if (percent == 0) {
                System.out.println("white");
                continue;
            }
            if (x * x + y * y > 50 * 50) {
                System.out.println("white");
                continue;
            }
            if (x == 0) {
                if (y >= 0) {
                    System.out.println("black");
                }
                else {
                    if (percent >= 50) {
                        System.out.println("black");
                    }
                    else {
                        System.out.println("white");
                    }
                }
                continue;
            }
            if (y == 0) {
                if (x >= 0) {
                    if (percent >= 25) {
                        System.out.println("black");
                    }
                    else {
                        System.out.println("white");
                    }
                }
                else {
                    if (percent >= 75) {
                        System.out.println("black");
                    }
                    else {
                        System.out.println("white");
                    }
                }
                continue;
            }
            double myPercent = Math.toDegrees(Math.atan(Math.abs(((double)y) / x))) / 360 * 100;
            if (x > 0 && y < 0) {
                myPercent = myPercent + 25;
            }
            else if (x < 0 && y < 0) {
                myPercent = 75 - myPercent;
            }
            else if (x < 0 && y > 0){
                myPercent = 75 + myPercent;
            }
            else {
                myPercent = 25 - myPercent;
            }
            myPercent -= percent;
            if (Math.abs(myPercent) < 1e-6 || myPercent < 0) {
                System.out.println("black");
            }
            else {
                System.out.println("white");
            }
        }
    }
}
// bug: do not convert y to double before use it.
// should be more familiar with math.atan math.todegree
// math.atan return arc value to represent an angle, should use math.todegree to convert it to degree
// just be careful and everything will be fine


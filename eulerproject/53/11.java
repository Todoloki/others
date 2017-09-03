import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {

        int count = 0;
        int limit = 1000000;
        int n = 100;
        int r = 0;
        int cnr = 1;
        int rFact = 1;

        // initialize, find the cnr which is largest but less than the limit
        while (r < n / 2) {
            int nextCnr = cnr * (n - r) / (r + 1);
            if (nextCnr > limit) {
                break;
            }
            else {
                cnr = nextCnr;
                r++;
                rFact *= r;
            }
        }

        // climb, that is, find a possible shortcut and take it
        boolean findShortCut = false;
        while (r < n / 2) {
            int nCeil = (int) Math.floor(Math.pow(rFact * (r + 1) * (limit + 1), 1.0 / (r + 1)));
            int worth = n - nCeil - r;
            if (worth <= 0) {
                if (findShortCut) {
                    break;
                }
            }
            else {
                int nextR = 0;
                int nextCnr = 1;
                while (nextR < r) {
                    nextCnr = nextCnr * (nCeil - nextR) / (nextR + 1);
                    nextR++;
                }
                if (nextCnr * (nCeil - nextR) / (nextR + 1) <= limit) {
                    break;
                }
                else {
                    count += (n - nCeil) * (n + 1 + nCeil + 2 - 4 * (r + 1) );
                    n = nCeil;
                    cnr = nextCnr;
                    findShortCut = true;
                }
            }
            // up
            while (r < n / 2) {
                int right = cnr * (n - r) / (r + 1);
                if (right > limit) {
                    count += n + 1 - 2 * (r + 1);
                    cnr = cnr * (n - r) / n;
                    n--;
                }
                else {
                    break;
                }
            }
            // right
            while (r < n / 2) {
                int right = cnr * (n - r) / (r + 1);
                if (right <= limit) {
                    cnr = right;
                    r++;
                    rFact *= r;
                }
                else {
                    break;
                }
            }
            // at the boundary again
        }
        
        
        // normal solution
        while (r < n / 2) {
            int right = cnr * (n - r) / (r + 1);
            if (right <= limit) {
                r++;
                cnr = right;
            }
            else {
                count += n + 1 - 2 * (r + 1);
                cnr = cnr * (n - r) / n;
                n--;
            }
        }
        System.out.println(count);
    }
}

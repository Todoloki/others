import java.io.*;
import java.util.*;

public class Solution {
    public static class Pair {
        int cancelled;
        int original;
        Pair (int cancelled, int original) {
            this.cancelled = cancelled;
            this.original = original;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean[] isNotPrime = new boolean[(10000 - 1) / 2 + 1];
        HashSet<Integer> primes = new HashSet<Integer>();
        primes.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            primes.add(2 * i + 1);
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        if (N == 4 && K == 1) {
            System.out.println(specialCases());
            return ;
        }
        int remain = N - K;
        int base = 1;
        
        for (int i = 0; i < remain; i++) {
            base *= 10;
        }
        // System.out.println(base);
        List<Integer> cancelledList = new ArrayList<Integer>();
        if (K == 1) {
            for (int i = 1; i <= 9; i++) {
                cancelledList.add(i);
            }
        }
        else if (K == 2) {
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    cancelledList.add(i * 10 + j);
                }
            }
        }
        else {
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    for (int k = j; k <= 9; k++) {
                        cancelledList.add(i * 100 + j * 10 + k);
                    }
                }
            }
        }
        long sumOfNumerators = 0;
        long sumOfDenominators = 0;
        HashSet<String> set = new HashSet<String>();
        for (int cancelled : cancelledList) {
            // System.out.println(cancelled);
            List<Pair> pairList = new ArrayList<Pair>();
            List<Integer> permutations = getPermutations(cancelled);
            // for (int permutation : permutations) {
                // System.out.println(permutation);
            // }
            for (int number = 0; number < base; number++) {
                List<Integer> originals = getOriginals(permutations, number, N - K, N);
                // System.out.println(number + " " + cancelled);
                for (int original : originals) {
                    pairList.add(new Pair(number, original));
                }
            }
            Collections.sort(pairList, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.cancelled - p2.cancelled;
                }
            });
            for (int i = 0; i < pairList.size(); i++) {
                for (int j = i + 1; j < pairList.size(); j++) {
                    Pair p1 = pairList.get(i);
                    Pair p2 = pairList.get(j);
                    if (primes.contains(p2.original)) {
                        continue;
                    }
                    if (p1.original >= p2.original) {
                        continue;
                    }
                    int gcd = getGCD(p1.original, p2.original);
                    int o1 = p1.original / gcd;
                    int o2 = p2.original / gcd;
                    gcd = getGCD(p1.cancelled, p2.cancelled);
                    int c1 = p1.cancelled / gcd;
                    int c2 = p2.cancelled / gcd;
                    if (c1 == o1 && c2 == o2) {
                        set.add(p1.original + " " + p2.original);
                    }
                }
            }
        }
        // List<int[]> l = new ArrayList<int[]>();
        for (String pair : set) {
            // System.out.println("ok");
            String[] list = pair.split("\\s+");
            // l.add(new int[]{Integer.parseInt(list[0]), Integer.parseInt(list[1])});
            sumOfNumerators += Integer.parseInt(list[0]);
            sumOfDenominators += Integer.parseInt(list[1]);
        }
        /*
        Collections.sort(l, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                }
                return p1[1] - p2[1];
            }
        });
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i)[0] + " " + l.get(i)[1]);
        }
        */
        System.out.println(sumOfNumerators + " " + sumOfDenominators);
    }
    public static List<Integer> getPermutations(int cancelled) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>();
        while (cancelled != 0) {
            numbers.add(cancelled % 10);
            cancelled /= 10;
        }
        boolean[] visited = new boolean[numbers.size()];
        generatePermutations(list, numbers, visited, 0, 0);
        return list;
    }
    public static void generatePermutations(List<Integer> list, List<Integer> numbers, boolean[] visited, int curNumber, int curLength) {
        if (curLength == numbers.size()) {
            list.add(curNumber);
            return ;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                generatePermutations(list, numbers, visited, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
    public static List<Integer> generatePermutations(int number) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>();
        while (number != 0) {
            numbers.add(number % 10);
            number /= 10;
        }
        generatePermutations(list, numbers, new boolean[numbers.size()], 0, 0);
        return list;
    }

    public static List<Integer> getOriginals(List<Integer> permutations, int cancelled, int remain, int N) {
        List<Integer> list = new ArrayList<Integer>();
        for (int permutation : permutations) {
            getOriginal(permutation, cancelled, list, remain, 0, N);
        }
        return list;
    }
    public static void getOriginal(int permutation, int cancelled, List<Integer> list, int remain, int curNumber, int N) {
        if (permutation == 0 && remain == 0) {
            if (curNumber % 10 == 0) {
                return ;
            }
            String s = "" + curNumber;
            while (s.length() < N) {
                s = "0" + s;
            }
            list.add(Integer.parseInt(new StringBuffer(s).reverse().toString()));
            return ;
        }
        if (permutation != 0) {
            getOriginal(permutation / 10, cancelled, list, remain, curNumber * 10 + permutation % 10, N);
        }
        if (remain != 0) {
            getOriginal(permutation, cancelled / 10, list, remain - 1, curNumber * 10 + cancelled % 10, N);
        }
    }
    public static int getGCD(int a, int b) {
        if (a <= 1 || b <= 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
    public static String specialCases() {
        int[] bases = new int[]{1, 10, 100, 1000, 10000};
        long sum1 = 0;
        long sum2 = 0;
        HashSet<String> set = new HashSet<String>();
        for (int k = 1; k <= 9; k++) {
            for (int i = 0; i < 1000; i++) {
                for (int indexI = 0; indexI < (i < 100 ? 1 : 4); indexI++) {
                    int numerator = i / bases[3  - indexI] * bases[4 - indexI] + k * bases[3 - indexI] + i % bases[3 - indexI];
                    for (int j = i + 1; j < 1000; j++) {
                        for (int indexJ = 0; indexJ < (j < 100 ? 1 : 4); indexJ++) {
                            if (indexJ > 0 && j / 100 < numerator / 1000) {
                                break;
                            }
                            int denominator = j / bases[3  - indexJ] * bases[4 - indexJ] + k * bases[3 - indexJ] + j % bases[3 - indexJ]; 
                            if (numerator * j == i * denominator && set.contains(numerator + " "  + denominator) == false) {
                                set.add(numerator + " " + denominator);
                                sum1 += numerator;
                                sum2 += denominator;
                            }
                        }
                    }
                }
            }
        }
        return sum1 + " " + sum2;
    }
}
// do not know if the author of this problem means it or not. I believe not. It is too complex.

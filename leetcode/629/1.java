/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 3;
        // for numbers from 1 to n, find how many possible cases that have k inverse pairs

        // get permutations for all numbers from 1 to n

        // use a list to store all the permutations
        // every permutation is represented as a list

        // use a boolean array to represent if we have already used an element or not
        boolean[] visited = new boolean[n];
        // use a list of list of integers to store all permutations
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutation(visited, new ArrayList<Integer>(), permutations, 0);
        int counter = 0;
        for (List<Integer> l : permutations) {
            int numReversePair = getReversePair(l, 0, n - 1);
            if (numReversePair == k) {
                counter++;
            }
        }
        System.out.println(counter);
    }
    public static void getPermutation(boolean[] visited, List<Integer> list, List<List<Integer>> res, int numElements) {
        if (numElements == visited.length) {
            res.add(new ArrayList<Integer>(list));
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                list.add(i + 1);
                getPermutation(visited, list, res, numElements + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    public static int getReversePair(List<Integer> l, int left, int right) {
        if (right == left) {
            return 0;
        }
        int mid = (right + left) / 2;
        int leftCount = getReversePair(l, left, mid);
        int rightCount = getReversePair(l, mid + 1, right);
        List<Integer> list = new ArrayList<Integer>();
        int leftIndex = mid;
        int rightIndex = right;
        int counter = 0;
        while (leftIndex >= left && rightIndex >= mid + 1) {
            if (l.get(leftIndex) > l.get(rightIndex)) {
                counter += rightIndex - mid - 1 + 1;
                list.add(l.get(leftIndex));
                leftIndex--;
            }
            else {
                list.add(l.get(rightIndex));
                rightIndex--;
            }
        }
        while (leftIndex >= left) {
            list.add(l.get(leftIndex));
            leftIndex--;
        }
        while (rightIndex >= mid + 1) {
            list.add(l.get(rightIndex));
            rightIndex--;
        }
        for (int i = 0; i < list.size(); i++) {
            l.set(i + left, list.get(list.size() - 1 - i));
        }
        return leftCount + rightCount + counter;
    }
}

// time complexity O(nlogn) to find how many inverse pairs
// time complexity O(n! * n) to get all permutations
// total O(n! * nlogn)

// space complexity O(n!*n)

// brute force
// 1. find all permutations
// 2. get the number of inverse pairs for every permutation
// 3. if we find a permutation whose number of inverse pairs is equal to k, increase counter
// 4. after check all the permutations, we will find the solution for this problem

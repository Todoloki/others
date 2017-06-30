public class Solution {
    /**
     * @param n an integer
     * @return how much money you need to have to guarantee a win
     */
    public int getMoneyAmount(int n) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return getMinAmount(1, n, map);
    }
    public int getMinAmount(int left, int right, HashMap<String, Integer> map) {
        if (left >= right) {
            return 0;
        }
        if (left == right - 1) {
            return left;
        }
        String key = left + " " + right;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int min = Integer.MAX_VALUE;
        for (int i = left + 1; i <= right - 1; i++) {
            min = Math.min(min, i + Math.max(getMinAmount(left, i - 1, map), getMinAmount(i + 1, right, map)));
        }
        map.put(key, min);
        return min;
    }
}
// time complexity O(n * n) since only O(n * n) key for hashmap exist
// space complexity O(n * n)

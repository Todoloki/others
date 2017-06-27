public class Excel {
    public class Cell {
        int val;
        HashMap<String, Integer> map;
        Cell(int val) {
            this.val = val;
            map = new HashMap<String, Integer>();
        }
    }
    Cell[][] excel;
    public Excel(int H, char W) {
        excel = new Cell[H][W - 'A' + 1];
    }
    
    public void set(int r, char c, int v) {
        int diff = 0;
        if (excel[r - 1][c - 'A'] == null) {
            excel[r - 1][c - 'A'] = new Cell(v);
            diff = v;
        }
        else {
            diff = v - excel[r - 1][c - 'A'].val;
            excel[r - 1][c - 'A'].val = v;
        }
        excel[r - 1][c - 'A'].map.clear();
        adapt(r, c, diff);
    }
    public void adapt(int r, char c, int diff) {
        int original = excel[r - 1][c - 'A'].val;
        String key = "" + c + r;
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < excel.length; i++) {
            for (int j = 0; j < excel[0].length; j++) {
                if (excel[i][j] != null && excel[i][j].map.containsKey(key)) {
                    excel[i][j].val += diff * excel[i][j].map.get(key);
                    list.add(new int[]{i, j, diff * excel[i][j].map.get(key)});
                }
            }
        }
        for (int[] pair : list) {
            adapt(pair[0] + 1, (char)(pair[1] + 'A'), pair[2]);
        }
    }
    public int get(int r, char c) {
        if (excel[r - 1][c - 'A'] != null) {
            return excel[r - 1][c - 'A'].val;
        }
        return 0;
    }
    
    public int sum(int r, char c, String[] strs) {
        if (excel[r - 1][c - 'A'] == null) {
            excel[r - 1][c - 'A'] = new Cell(0);
        }
        else {
            excel[r - 1][c - 'A'].val = 0;
        }
        int sumOfCell = 0;
        for (String s : strs) {
            if (s.indexOf(":") >= 0) {
                String[] list = s.split(":");
                int r1 = Integer.parseInt(list[0].substring(1)) - 1;
                int c1 = list[0].charAt(0) - 'A';
                int r2 = Integer.parseInt(list[1].substring(1)) - 1;
                int c2 = list[1].charAt(0) - 'A';
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        increaseCounter("" + (char)(j + 'A') + (i + 1), r - 1, c - 'A');
                        if (excel[i][j] != null) {
                            sumOfCell += excel[i][j].val;
                        }
                    }
                }
            }
            else {
                increaseCounter(s, r - 1, c - 'A');
                int r1 = Integer.parseInt(s.substring(1)) - 1;
                int c1 = s.charAt(0) - 'A';
                if (excel[r1][c1] != null) {
                    sumOfCell += excel[r1][c1].val;
                }
            }
        }
        excel[r - 1][c - 'A'].val = sumOfCell;
        return sumOfCell;
    }
    public void increaseCounter(String key, int r, int c) {
        HashMap<String, Integer> curMap = excel[r][c].map;
        if (curMap.containsKey(key)) {
            curMap.put(key, curMap.get(key) + 1);
        }
        else {
            curMap.put(key, 1);
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */


// just create extra hashmap to store all the nodes that is depedent for the current cell.
// or we can also use range, every time just check if a node is in range will be fine.
// but in this solution for a cell, we can say immediately how many times it should be counted for current cell.
// for range we need to check each range.
// we need to chose which to use according to how those methods will be used.

// find a great song call "give you galaxy", but I perfer the cover by bigstar
// ^life is beautiful^

// for set, if the current cell has k edges in topological sort, then O(k * r * w) time
// can be reduced by get a topological list reversely and calculate accordingly O(r * w * r * w) space totally.(globally)
// space O(r * w * r * w) for O(r * w) cell, each cell has a hashmap of size O(h * w)
// for sum, the list of length l, then O(l * r * w) time
// for get O(1)

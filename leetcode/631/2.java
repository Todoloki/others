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
        //int diff = 0;
        if (excel[r - 1][c - 'A'] == null) {
            excel[r - 1][c - 'A'] = new Cell(v);
            //diff = v;
        }
        else {
            // diff = v - excel[r - 1][c - 'A'].val;
            excel[r - 1][c - 'A'].val = v;
        }
        excel[r - 1][c - 'A'].map.clear();
        //adapt(r, c, diff);
        List<String> list = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        getList("" + c + r, list, set);
        Collections.reverse(list);
        for (int i = 1; i < list.size(); i++) {
            String key = list.get(i);
            int row = Integer.parseInt(key.substring(1)) - 1;
            int column = key.charAt(0) - 'A';
            calculateSum(row, column);
        }
    }
    public void getList(String key, List<String> list, HashSet<String> set) {
        for (int i = 0; i < excel.length; i++) {
            for (int j = 0; j < excel[0].length; j++) {
                if (excel[i][j] != null && excel[i][j].map.containsKey(key)) {
                    String newKey = "" + (char)(j + 'A') + (i + 1);
                    if (set.contains(newKey)) {
                        continue;
                    }
                    set.add(newKey);
                    getList(newKey, list, set);
                }
            }
        }
        list.add(key);
    }

    public void calculateSum(int r, int c) {
        int sum = 0;
        for (String key : excel[r][c].map.keySet()) {
            int row = Integer.parseInt(key.substring(1)) - 1;
            int column = key.charAt(0) - 'A';
            if (excel[row][column] != null) {
                sum += excel[row][column].val * excel[r][c].map.get(key);
            }
        }
        excel[r][c].val = sum;
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
 // use topological sort to get all the cells that can be affected first.

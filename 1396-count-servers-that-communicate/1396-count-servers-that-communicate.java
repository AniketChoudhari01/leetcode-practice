class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean isIncluded[][] = new boolean[m][n];
        int total = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    st.push(j);// store column
                }
            }
            if (st.size() > 1) {
                total += st.size();
                while (!st.isEmpty()) {
                    // int idx = st.pop();
                    isIncluded[i][st.remove(0)] = true;
                }
            }
            st.removeAllElements();
        }
        for (int j = 0; j < n; j++) {
            int cntCol = 0;
            int notSeen = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    if (!isIncluded[i][j]) {
                        notSeen++;
                    }
                    cntCol++;
                }
            }
            if (cntCol > 1) {
                total += notSeen;
            }
        }

        return total;
    }
}
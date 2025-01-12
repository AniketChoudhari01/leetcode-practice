class Solution {
    Integer temp[][][];
    int NEG = Integer.MIN_VALUE;

    private int solve(int grid[][], int i, int j, int m, int n, int k) {
        if (i >= m || j >= n) {
            return NEG;
        }
        if(i<m && j< n && temp[i][j][k]!=null) return temp[i][j][k];
        int cost = grid[i][j];
        if (i == m - 1 && j == n - 1) {
            if (cost >= 0) {
                temp[i][j][k] = cost;
            } else {
                if (k > 0) {// can dodge robber
                    temp[i][j][k] = 0/* Math.max(cost, 0) */;
                } else {// can't dodge
                    temp[i][j][k] = cost;
                }
            }
            return temp[i][j][k];
        }

        int right = solve(grid, i + 1, j, m, n, k);
        int down = solve(grid, i, j + 1, m, n, k);
        int best = Math.max(down, right);
        if (cost >= 0) {
            temp[i][j][k] = best + cost;
        } else {
            int pay = cost + best; // must pay him
            int skip = NEG;
            if (k > 0) {// dodge the robber
                int right2 = solve(grid, i + 1, j, m, n, k - 1);
                int down2 = solve(grid, i, j + 1, m, n, k - 1);
                skip = Math.max(right2, down2);
            }
            temp[i][j][k] = Math.max(pay, skip);
        }
        return temp[i][j][k];
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        temp= new Integer[m][n][3];
        // for (int curr[] : temp) {
        //     Arrays.fill(curr, Integer.MIN_VALUE);
        // }
        return solve( coins, 0, 0, m, n, 2);
        
    }
}